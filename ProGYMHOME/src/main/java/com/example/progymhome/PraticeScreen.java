package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PraticeScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView onClickBack;

    @FXML
    private AnchorPane onClickCalisthenic;

    @FXML
    private AnchorPane onClickCardio;

    @FXML
    private AnchorPane onClickCustomize;

    @FXML
    private AnchorPane onClickGym;

    @FXML
    private AnchorPane onClickMeditation;

    @FXML
    private AnchorPane onClickPower;

    @FXML
    private Pane openWorkout;
    @FXML
    private Pane openWorkout1;
    @FXML
    private Pane openWorkout11;
    @FXML
    private ScrollPane scrollToLocation;

    @FXML
    void initialize() {
        openWorkout.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    System.out.println("abc");
                    SwitchScreenController.switchToScene1(mouseEvent, "workout-video-screen.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

}
