package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.User.UserSession;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SetRepAndSetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nameLesson;

    @FXML
    private Button onClickClose;

    @FXML
    private Button onClickOK;

    @FXML
    private ImageView onRepDecrease;

    @FXML
    private ImageView onRepIncrease;

    @FXML
    private ImageView onSetDecrease;

    @FXML
    private ImageView onSetIncrease;

    @FXML
    private TextField repTextField;

    @FXML
    private TextField setTextField;

    private UserSession userSession;
    @FXML
    void initialize() {
        userSession = userSession.getInstance();
        repTextField.setText("0");
        setTextField.setText("0");
        nameLesson.setText(userSession.getNamePratice());
        System.out.println(nameLesson.getText());

        onClickClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = (Stage) onClickClose.getScene().getWindow();
                stage.close();
            }
        });
        onClickOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try
                {
                    userSession.setDetailPratice(setTextField.getText() + "x" + repTextField.getText());
                    System.out.println(setTextField.getText() + " " + repTextField.getText());
                    Stage stage = (Stage) onClickClose.getScene().getWindow();
                    stage.close();
                    SwitchScreenController.openNewWindow(actionEvent, "add-screen.fxml", 376,640);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        onRepIncrease.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int rep = Integer.parseInt(repTextField.getText());
                repTextField.setText(String.valueOf(rep + 1));
            }
        });
        onRepDecrease.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int rep = Integer.parseInt(repTextField.getText());
                repTextField.setText(String.valueOf(rep - 1));
            }
        });
        onSetIncrease.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int rep = Integer.parseInt(setTextField.getText());
                setTextField.setText(String.valueOf(rep + 1));
            }
        });
        onSetDecrease.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int rep = Integer.parseInt(setTextField.getText());
                setTextField.setText(String.valueOf(rep - 1));
            }
        });

    }

}
