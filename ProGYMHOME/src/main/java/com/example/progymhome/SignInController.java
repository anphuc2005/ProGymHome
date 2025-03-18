package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.User.UserManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView onClickBack;

    @FXML
    private Button onClickLogIn;

    @FXML
    private Label onClickSignUp;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private ImageView showPassword;

    boolean isShowPass;

    private UserManager userManager;

    @FXML
    void initialize() {
        userManager = userManager.getInstance();

        onClickBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    SwitchScreenController.switchToScene1(mouseEvent, "welcome-screen.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        onClickLogIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);


                if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
                    alert.setContentText("You must fill all fields.");
                    alert.show();
                    return;
                }


                if (userManager.checkUserOnList(usernameTextField.getText(), passwordTextField.getText())) {
                    if(SignUpController.userExist == false)
                    {
                        try {
                            SwitchScreenController.switchToScene(actionEvent, "profile-set-screen.fxml");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else
                    {
                        try {

                            SwitchScreenController.switchToScene(actionEvent, "profile-screen.fxml");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {
                    alert.setContentText("User does not exist or incorrect password.");
                    alert.show();
                }
            }
        });
        onClickSignUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try
                {
                    SwitchScreenController.switchToScene1(mouseEvent, "sign-up.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        showPassword.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!isShowPass) {
                    showPassword.setImage(new Image(getClass().getResource("/img/hide.png").toExternalForm()));
                    passwordTextField.setVisible(false);
                    isShowPass = true;
                } else {
                    showPassword.setImage(new Image(getClass().getResource("/img/show.png").toExternalForm()));
                    passwordTextField.setVisible(true);
                    passwordTextField.setText(passwordTextField.getText());
                    isShowPass = false;
                }
            }
        });
    }
}
