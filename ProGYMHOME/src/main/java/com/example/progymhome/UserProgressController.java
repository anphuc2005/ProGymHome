package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.Lesson.LessonImage;
import com.example.progymhome.User.UserDetail;
import com.example.progymhome.User.UserListSession;
import com.example.progymhome.User.UserManager;
import com.example.progymhome.User.UserSession;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UserProgressController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Calories;

    @FXML
    private Label numExercises;

    @FXML
    private Label totalTime;

    @FXML
    private VBox addSession;

    @FXML
    private ImageView onClickBack;

    private UserSession userSession;
    private UserListSession userListSession;
    private UserListSession userListSession1;
    private UserManager userManager;
    private String[] part;
    private int totalExercise;
    private double totalTimeSession = 0;
    private UserDetail userDetail;

    @FXML
    void initialize() {
        userSession = userSession.getInstance();
        userManager = userManager.getInstance();
        userDetail = userManager.findUser(SignInController.userName);
        userListSession = userDetail.getUserListSession();
        userListSession1 = userDetail.getUserCustomSession();
//        for (UserSession user : userListSession.getUsers()) {
//            System.out.println(user.getNamePratice() + " " + user.getDetailPratice());
//        }
        populateLessons(userListSession);
        populateLessons(userListSession1);
        numExercises.setText(totalExercise + " Exercises");
        totalTime.setText(String.format("%.2f Minutes", totalTimeSession += WorkoutController.time));
        onClickBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    SwitchScreenController.switchToScene1(mouseEvent, "profile-screen.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

    public void addLessonToVbox(String name, String set, String rep) {
        HBox lessonPane = new HBox();
        lessonPane.setSpacing(10);
        lessonPane.setPadding(new Insets(10));
        lessonPane.setStyle("-fx-background-color: lightgray; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        Label lessonLabel = new Label(name);
        Label setLabel = new Label("Sets: " + set);
        Label repLabel = new Label("Reps: " + rep);
        String nameLabel = getImageVideo(name);
        ImageView imageLesson = new ImageView(nameLabel);
        imageLesson.setFitWidth(40);
        imageLesson.setFitHeight(40);
        imageLesson.setPreserveRatio(true);

        Font poppinsBold = Font.font("Poppins", FontWeight.BOLD, 14);
        lessonLabel.setFont(poppinsBold);
        setLabel.setFont(poppinsBold);
        repLabel.setFont(poppinsBold);

        lessonPane.getChildren().addAll(imageLesson, lessonLabel, setLabel, repLabel);
        lessonPane.setAlignment(Pos.CENTER_LEFT);
        this.addSession.getChildren().add(lessonPane);
    }

    public void populateLessons(UserListSession users) {

        for (UserSession user : users.getUsers()) {
            ++totalExercise;
            System.out.println(user.getNamePratice() + " " + user.getDetailPratice());
            userSession.setNamePratice(user.getNamePratice());
            userSession.setDetailPratice(user.getDetailPratice());
            userSession.setTime(user.getTime());
            System.out.println(user.getTime());
//            totalTimeSession += userSession.getTime();
            part = user.splitString();
            String name = user.getNamePratice();
            String set = "", rep = "";

            if (part.length == 1) {
                rep = part[0];
            } else {
                set = part[1] + " Sets";
                rep = part[0] + " Reps";
            }


            addLessonToVbox(name, set, rep);
        }
    }

    private String getImageVideo(String lessonName) {
        for (LessonImage lesson : LessonImage.values()) {
            String name = lessonName.replace(" ", "_").toUpperCase();
            System.out.println(name);
            if (lesson.name().equals(name)) {
                return lesson.getLinkImage();
            } else {
                System.out.println("No machting found" + lessonName);
            }
        }
        return lessonName;
    }

}
