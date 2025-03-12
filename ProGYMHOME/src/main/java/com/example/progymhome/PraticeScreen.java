package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.User.UserSession;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PraticeScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label detailSession;

    @FXML
    private Label detailSession1;

    @FXML
    private Label detailSession10;

    @FXML
    private Label detailSession11;

    @FXML
    private Label detailSession12;

    @FXML
    private Label detailSession13;

    @FXML
    private Label detailSession14;

    @FXML
    private Label detailSession15;

    @FXML
    private Label detailSession16;

    @FXML
    private Label detailSession2;

    @FXML
    private Label detailSession3;

    @FXML
    private Label detailSession4;

    @FXML
    private Label detailSession5;

    @FXML
    private Label detailSession6;

    @FXML
    private Label detailSession7;

    @FXML
    private Label detailSession8;

    @FXML
    private Label detailSession9;

    @FXML
    private Label goToCalis;

    @FXML
    private Label goToCardio;

    @FXML
    private Label goToGym;

    @FXML
    private Label goToMeditation;

    @FXML
    private Label goToPower;

    @FXML
    private Label nameSession;

    @FXML
    private Label nameSession1;

    @FXML
    private Label nameSession10;

    @FXML
    private Label nameSession11;

    @FXML
    private Label nameSession12;

    @FXML
    private Label nameSession13;

    @FXML
    private Label nameSession14;

    @FXML
    private Label nameSession15;

    @FXML
    private Label nameSession16;

    @FXML
    private Label nameSession2;

    @FXML
    private Label nameSession3;

    @FXML
    private Label nameSession4;

    @FXML
    private Label nameSession5;

    @FXML
    private Label nameSession6;

    @FXML
    private Label nameSession7;

    @FXML
    private Label nameSession8;

    @FXML
    private Label nameSession9;

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
    private AnchorPane getOnClickCustomize;

    @FXML
    private Pane openWorkout;

    @FXML
    private Pane openWorkout1;

    @FXML
    private Pane openWorkout11;

    @FXML
    private Pane openWorkout111;

    @FXML
    private Pane openWorkout1111;

    @FXML
    private Pane openWorkout11111;

    @FXML
    private Pane openWorkout111111;

    @FXML
    private Pane openWorkout1111111;

    @FXML
    private Pane openWorkout11111111;

    @FXML
    private Pane openWorkout111111111;

    @FXML
    private Pane openWorkout1111111111;

    @FXML
    private Pane openWorkout11111111111;

    @FXML
    private Pane openWorkout111111111111;

    @FXML
    private Pane openWorkout111111111112;

    @FXML
    private Pane openWorkout111111111113;

    @FXML
    private Pane openWorkout1111111111131;

    @FXML
    private Pane openWorkout111111112;

    @FXML
    private ScrollPane scrollToLocation;


    private UserSession userSession;

    @FXML
    void initialize() {

        userSession = UserSession.getInstance();


        Pane[] workoutPanes = {
                openWorkout, openWorkout1, openWorkout11, openWorkout111, openWorkout1111,
                openWorkout11111, openWorkout111111, openWorkout1111111, openWorkout11111111,
                openWorkout111111111, openWorkout1111111111, openWorkout11111111111, openWorkout111111111111,
                openWorkout111111111112, openWorkout111111111113, openWorkout1111111111131, openWorkout111111112
        };
        Label[] nameLabel = {
                nameSession, nameSession1, nameSession2, nameSession3, nameSession4, nameSession5, nameSession6, nameSession7, nameSession8,
                nameSession9, nameSession10, nameSession11, nameSession12, nameSession13, nameSession14, nameSession15, nameSession16
        };
        Label[] detailLabel = {
                detailSession, detailSession1, detailSession2, detailSession3, detailSession4, detailSession5, detailSession6, detailSession7
                , detailSession8, detailSession9, detailSession10, detailSession11, detailSession12, detailSession13, detailSession14, detailSession15,
                detailSession16
        };

        for (int i = 0; i < workoutPanes.length; ++i) {
            if (workoutPanes[i] != null) {
                int finalI = i;
                workoutPanes[i].setOnMouseClicked(event -> {
                    userSession.setNamePratice(nameLabel[finalI].getText());
                    userSession.setDetailPratice(detailLabel[finalI].getText());
                    handleWorkoutClick(event);
                });
            }
        }


        onClickPower.setOnMouseClicked(event -> scrollToLabel(goToPower));
        onClickGym.setOnMouseClicked(event -> scrollToLabel(goToGym));
        onClickCardio.setOnMouseClicked(event -> scrollToLabel(goToCardio));
        onClickMeditation.setOnMouseClicked(event -> scrollToLabel(goToMeditation));
        onClickCalisthenic.setOnMouseClicked(event -> scrollToLabel(goToCalis));
        onClickCustomize.setOnMouseClicked(event -> {
            try {
                SwitchScreenController.switchToScene1(event, "customize-pratice.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    private void handleWorkoutClick(MouseEvent event) {
        try {
            SwitchScreenController.switchToScene1(event, "workout-video-screen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scrollToLabel(Label label) {
        if (label != null && scrollToLocation != null) {
            double yOffset = label.getLayoutY() + 50;
            scrollToLocation.setVvalue(yOffset / scrollToLocation.getContent().getBoundsInLocal().getHeight());
        }
    }
}
