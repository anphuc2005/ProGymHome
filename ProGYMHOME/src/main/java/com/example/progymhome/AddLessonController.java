package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.Lesson.LessonImage;
import com.example.progymhome.Screen.ScreenBackManager;
import com.example.progymhome.User.UserDetail;
import com.example.progymhome.User.UserListSession;
import com.example.progymhome.User.UserManager;
import com.example.progymhome.User.UserSession;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AddLessonController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox lessonContainer;

    @FXML
    private Button onClickStarted;
    private UserSession userSession;
    private UserListSession userListSession;
    private UserManager userManager;
    private String[] part;
    private ScreenBackManager screenBackManager;
    private UserDetail userDetail;


    @FXML
    void initialize() {
        //userManager.loadFromFile("src/main/java/com/example/progymhome/User/userData.json");
        userSession = userSession.getInstance();
        userManager = userManager.getInstance();
        userDetail = userManager.findUser(SignInController.userName);
        userListSession = userDetail.getUserCustomSession();
        for (UserSession user : userDetail.getUserCustomSession().getUsers())
        {
            System.out.println(user.getNamePratice() + " " + user.getDetailPratice());
            System.out.println("-----");
        }
        populateLessons();



    }

    public void addLessonToVbox(String name, String set, String rep) {
        HBox lessonPane = new HBox();
        lessonPane.setSpacing(10);
        lessonPane.setPadding(new Insets(10));
        lessonPane.setStyle("-fx-background-color: lightgray; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        Label lessonLabel = new Label(name);
        Label setLabel = new Label("Sets: " + set);
        Label repLabel = new Label("Reps: " + rep);
        String nameLabel = getImageVideo(lessonLabel.getText());
        ImageView imageLesson = new ImageView(nameLabel);
        ImageView deleteLesson = new ImageView("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\delete.png");
        imageLesson.setFitWidth(40);
        imageLesson.setFitHeight(40);
        deleteLesson.setFitWidth(30);
        deleteLesson.setFitHeight(30);
        imageLesson.setPreserveRatio(true);

        Font poppinsBold = Font.font("Poppins", FontWeight.BOLD, 14);
        lessonLabel.setFont(poppinsBold);
        setLabel.setFont(poppinsBold);
        repLabel.setFont(poppinsBold);

        lessonPane.getChildren().addAll(imageLesson, lessonLabel, setLabel, repLabel, deleteLesson);
        lessonPane.setAlignment(Pos.CENTER_LEFT);

        imageLesson.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try
                {
                    screenBackManager.pushScreen("add-screen.fxml");
                    SwitchScreenController.switchToScene1(mouseEvent, "workout-video-screen.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.lessonContainer.getChildren().add(lessonPane);
        deleteLesson.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Compare the actual text in lessonLabel with user.getNamePratice()
                for(UserSession user : userListSession.getUsers()) {
                    if(user.getNamePratice().equals(lessonLabel.getText())) {
                        userListSession.deleteUserSession(user);
                        System.out.println("User session deleted");
                        break;
                    }
                }
                userDetail.setUserCustomSession(userListSession);
                userManager.updateUser(userDetail, "D:\\Package IDE Java\\ProGYMHOME\\src\\main\\java\\com\\example\\progymhome\\User\\userData.json");
                lessonContainer.getChildren().remove(lessonPane);
                try {
                    SwitchScreenController.switchToScene1(mouseEvent, "add-screen.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public void populateLessons() {
        UserListSession userListSession1 = userListSession;
        System.out.println(userListSession1);
        for (UserSession user : userListSession1.getUsers()) {
            System.out.println(user.getNamePratice() + " " + user.getDetailPratice());
            userSession.setNamePratice(user.getNamePratice());
            userSession.setDetailPratice(user.getDetailPratice());
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

    private String getImageVideo(String lessonName)
    {
        for(LessonImage lesson : LessonImage.values())
        {
            if(lesson.name().equalsIgnoreCase(lessonName.replace(" ", "_")))
            {
                return lesson.getLinkImage();
            }
            else
            {
                System.out.println("Error");
            }
        }
        return lessonName;
    }
}