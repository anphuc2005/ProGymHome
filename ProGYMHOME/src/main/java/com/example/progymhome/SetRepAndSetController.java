package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.User.UserDetail;
import com.example.progymhome.User.UserListSession;
import com.example.progymhome.User.UserManager;
import com.example.progymhome.User.UserSession;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private UserListSession userListSession;
    private Stage newStage;
    private UserManager userManager;
    private UserDetail userDetail;
    @FXML
    void initialize() {
        userSession = userSession.getInstance();
        userListSession= userListSession.getInstance();
        userManager = userManager.getInstance();
        userDetail = userManager.findUser(SignInController.userName);
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
                try {

                    UserSession newUserSession = new UserSession();


                    newUserSession.setDetailPratice(setTextField.getText() + "x" + repTextField.getText());
                    System.out.println(setTextField.getText() + " " + repTextField.getText());
                    newUserSession.setNamePratice(userSession.getNamePratice());


                    userListSession.addUserSession(newUserSession);
                    userDetail.setUserListSession(userListSession);
                    userManager.updateUser(userDetail,"D:\\Package IDE Java\\ProGYMHOME\\src\\main\\java\\com\\example\\progymhome\\User\\userData.json");


                    Stage stage = (Stage) onClickClose.getScene().getWindow();
                    stage.close();

                    if(newStage == null || !newStage.isShowing())
                    {
                        System.out.println("abc");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-screen.fxml"));
                        Parent root = loader.load();

                        newStage = new Stage();
                        Scene scene = new Scene(root);
                        newStage.setScene(scene);
                        newStage.show();
                    }
                    else
                    {
                        System.out.println("xyz");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-screen.fxml"));
                        Parent root = loader.load();

                        newStage.getScene().setRoot(root);
                    }


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
