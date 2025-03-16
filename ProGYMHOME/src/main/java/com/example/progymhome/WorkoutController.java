package com.example.progymhome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.progymhome.Lesson.LessonLink;
import com.example.progymhome.Screen.ScreenBackManager;
import com.example.progymhome.User.UserListSession;
import com.example.progymhome.User.UserSession;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class WorkoutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nameLesson;

    @FXML
    private ImageView onClickBack;

    @FXML
    private ImageView onClickBack10s;

    @FXML
    private Button onClickDone;

    @FXML
    private ImageView onClickForward10s;

    @FXML
    private ImageView onClickNext;

    @FXML
    private ImageView onClickPlay;

    @FXML
    private AnchorPane onPlayVideo;

    @FXML
    private Label repLesson;

    @FXML
    private Label setLesson;

    @FXML
    private ImageView returnScreen;

    private WebView webView;
    private boolean isPlaying = false;
    private UserSession userSession;
    private String[] part;
    private String videoID;
    private UserListSession userListSession;
    public static double time;

    @FXML
    void initialize() {
        long startTime = System.currentTimeMillis();
        userSession = userSession.getInstance();
        userListSession = userListSession.getInstance();
        nameLesson.setText(userSession.getNamePratice());
        videoID = getVideoIDFromLesson(nameLesson.getText());
        System.out.println(videoID);
        setUpWebView(videoID);


        part = userSession.splitString();
        for (int i = 0 ; i < part.length ; ++i)
        {
            System.out.println(part[i]);
        }
        if (part.length == 1) {
            repLesson.setText(part[0]);
        } else {
            setLesson.setText(part[1] + " sets");
            repLesson.setText(part[0] + " reps");
        }


        onClickPlay.setOnMouseClicked(event -> {
            if (!isPlaying) {
                executeJS("playVideo()");
                onClickPlay.setImage(new Image(getClass().getResource("/img/pause.png").toExternalForm()));
                isPlaying = true;
            } else {
                executeJS("pauseVideo()");
                onClickPlay.setImage(new Image(getClass().getResource("/img/play.png").toExternalForm()));
                isPlaying = false;
            }
        });

        onClickBack10s.setOnMouseClicked(event -> executeJS("rewindVideo()"));
        onClickForward10s.setOnMouseClicked(event -> executeJS("forwardVideo()"));

        returnScreen.setOnMouseClicked(event -> {
            try {

                executeJS("pauseVideo()");
                String backScreen = ScreenBackManager.popScreen();
                if(backScreen != null)
                {
                    System.out.println(backScreen);
                    SwitchScreenController.switchToScene1(event, backScreen);
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        onClickDone.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                long endTime = System.currentTimeMillis();
                time = (endTime - startTime) /60000.0;
//                userSession.setTime(lessionTime);
                System.out.println(time);
                try {
                    executeJS("pauseVideo()");
                    String backScreen = ScreenBackManager.popScreen();
                    if(backScreen != null)
                    {
                        System.out.println(backScreen);
                        SwitchScreenController.switchToScene1(mouseEvent, backScreen);
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });



    }

    private void setUpWebView(String videoLink) {
        webView = new WebView();
        webView.setPrefSize(onPlayVideo.getPrefWidth(), onPlayVideo.getPrefHeight());

        String htmlContent = "<html><body>"
                + "<iframe id='player' type='text/html' width='100%' height='100%'"
                + " src='https://www.youtube.com/embed/" + videoLink + "?enablejsapi=1'"
                + " frameborder='0'></iframe>"
                + "<script>"
                + "  var player;"
                + "  function onYouTubeIframeAPIReady() {"
                + "    player = new YT.Player('player');"
                + "  }"
                + "  function playVideo() { player.playVideo(); }"
                + "  function pauseVideo() { player.pauseVideo(); }"
                + "  function rewindVideo() { player.seekTo(player.getCurrentTime() - 10, true); }"
                + "  function forwardVideo() { player.seekTo(player.getCurrentTime() + 10, true); }"
                + "</script>"
                + "<script src='https://www.youtube.com/iframe_api'></script>"
                + "</body></html>";

        webView.getEngine().loadContent(htmlContent, "text/html");
        onPlayVideo.getChildren().add(webView);
    }


    private void executeJS(String script) {
        webView.getEngine().executeScript(script);
    }
    private String getVideoIDFromLesson(String lessonName) {
        for (LessonLink lesson : LessonLink.values()) {
            if (lesson.name().equalsIgnoreCase(lessonName.replace(" ", "_"))) {
                return lesson.getVideoID();
            }
            else if(lessonName.equals("Meditation"))
            {
                return LessonLink.MEDITATION.getVideoID();
            }
            else if(lessonName.equals("Running") || lessonName.equals("Ride Bicycle") || lessonName.equals("Drink Water"))
            {
                return LessonLink.CHILLING.getVideoID();
            }
            else if(lessonName.equals("Warm Up"))
            {
                return LessonLink.WARM_UP.getVideoID();
            }
        }
        return "defaultVideoID";
    }

}
