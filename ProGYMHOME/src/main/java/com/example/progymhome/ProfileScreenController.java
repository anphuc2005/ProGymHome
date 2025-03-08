package com.example.progymhome;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.User.UserDetail;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class ProfileScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button onClickEdit;

    @FXML
    private ImageView onClickHome;

    @FXML
    private ImageView onClickProfile;

    @FXML
    private ImageView onClickProgress;

    @FXML
    private ImageView onClickSetUp;

    @FXML
    private Text setAgeUser;

    @FXML
    private Text setHeightUser;

    @FXML
    private ImageView setImage;

    @FXML
    private Label setNameTextFIeld;

    @FXML
    private Text setWeightUser;

    @FXML
    private Label upLoadImage;

    private UserDetail user;
    @FXML
    void initialize() {
            user = user.getInstance();
            setNameTextFIeld.setText(user.getName());
            setWeightUser.setText(user.getWeight() + user.getWeightUnit());
            setHeightUser.setText(user.getHeight() + user.getHeightUnit());
            setAgeUser.setText(user.getAge() + "y0");
            upLoadImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    upImage(mouseEvent);
                }
            });
            onClickHome.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try
                    {
                        SwitchScreenController.switchToScene1(mouseEvent, "pratice-screen.fxml");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            onClickProfile.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try
                    {
                        SwitchScreenController.switchToScene1(mouseEvent, "profile-set-screen.fxml");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
    }
    public void upImage(MouseEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chọn ảnh để upload");
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);


        File file = fileChooser.showOpenDialog(setImage.getScene().getWindow());

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            setImage.setImage(image);
        }
    }

}
