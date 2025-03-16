package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.User.UserDetail;
import com.example.progymhome.User.UserManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField confirmPasswordTextField;

    @FXML
    private ImageView onClickBack;

    @FXML
    private Button onClickLogIn;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField usernameTextField;
    private UserManager userManager;
    private UserDetail user;

    public static boolean userExist = true;
    @FXML
    void initialize() {
        userManager = userManager.getInstance();
        onClickBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    SwitchScreenController.switchToScene1(mouseEvent, "sign-in.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        onClickLogIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                if(usernameTextField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || passwordTextField.getText().isEmpty() || confirmPasswordTextField.getText().isEmpty())
                {
                    alert.setContentText("You must fill all fields");
                    alert.show();
                    return;
                }
                else if (!passwordTextField.getText().equals(confirmPasswordTextField.getText()))
                {
                    alert.setContentText("Your password is not same");
                    alert.show();
                    return;
                }
                else
                {
                    user = new UserDetail();
                    user.setUsername(usernameTextField.getText());
                    user.setPassword(passwordTextField.getText());
                    ProfileSetupController.userName = user.getUsername();
                    userManager.addUser(user);
                    userManager.saveToFile("src/main/java/com/example/progymhome/User/userData.json");
                    userManager.loadFromFile("src/main/java/com/example/progymhome/User/userData.json");
                    userExist = false;
                }
                try
                {
                    SwitchScreenController.switchToScene(actionEvent, "sign-in.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

}
