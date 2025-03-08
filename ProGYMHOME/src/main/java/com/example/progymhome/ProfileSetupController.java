package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

import com.example.progymhome.User.UserDetail;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProfileSetupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker dateOfBirthTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private MenuButton heightUnit;

    @FXML
    private TextField nameTextField;

    @FXML
    private ImageView onClickBack;

    @FXML
    private Button onClickNext;

    @FXML
    private TextField weightTextField;

    @FXML
    private MenuButton weightUnit;

    @FXML
    private MenuItem menuItem;


    private UserDetail user;
    @FXML
    void initialize() {
        for(MenuItem item : weightUnit.getItems())
        {
            item.setOnAction(e -> weightUnit.setText(item.getText()));
        }
        for(MenuItem item : heightUnit.getItems())
        {
            item.setOnAction(e -> heightUnit.setText(item.getText()));
        }
        onClickBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try
                {
                    SwitchScreenController.switchToScene1(mouseEvent, "sign-in.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        user = user.getInstance();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        onClickNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent actionEvent) {
                if(nameTextField.getText().isEmpty() || dateOfBirthTextField.getValue() == null || weightTextField.getText().isEmpty() || heightTextField.getText().isEmpty())
                {
                    alert.setContentText("You must fill all fields");
                    alert.show();
                    return;
                }
                else
                {
                    user.setDateOfBirth(dateOfBirthTextField.getValue());
                    user.setName(nameTextField.getText());
                    user.setWeight(weightTextField.getText());
                    user.setHeight(heightTextField.getText());
                    user.setWeightUnit(weightUnit.getText());
                    user.setHeightUnit(heightUnit.getText());
                    LocalDate now = LocalDate.now();
                    int age = Period.between(dateOfBirthTextField.getValue(), now).getYears();
                    user.setAge(age);
//                    System.out.println(user.getUsername() + " " + user.getWeight() + user.getWeightUnit() + " " + user.getHeight() + user.getHeightUnit() + " " + user.getPassword() + " " + user.getPhoneNumber() + " " + user.getAge());



                }
                try
                {
                    SwitchScreenController.switchToScene(actionEvent, "profile-screen.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

}
