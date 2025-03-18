package com.example.progymhome;

import java.io.IOException;
import com.example.exfxwebview.WebView;
import com.example.progymhome.User.UserSession;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CustomizeController {

    @FXML
    private AnchorPane OverheadTricep;

    @FXML
    private AnchorPane abRoller;

    @FXML
    private AnchorPane barbellPress;

    @FXML
    private AnchorPane barbellSquat;

    @FXML
    private AnchorPane benchPress;

    @FXML
    private AnchorPane cableRow;

    @FXML
    private AnchorPane cableTricep;

    @FXML
    private AnchorPane declinePress;

    @FXML
    private AnchorPane dips;

    @FXML
    private AnchorPane dumbbellPress;

    @FXML
    private AnchorPane dumbbellRaises;

    @FXML
    private AnchorPane flyMachine;

    @FXML
    private AnchorPane goToChest;

    @FXML
    private AnchorPane goToLat;

    @FXML
    private AnchorPane goToShoulder;

    @FXML
    private AnchorPane goToStomach;

    @FXML
    private AnchorPane goToThigh;

    @FXML
    private AnchorPane goToTricep;

    @FXML
    private AnchorPane halfSquat;

    @FXML
    private AnchorPane lateralRaises;

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
    private Label nameSession17;

    @FXML
    private Label nameSession18;

    @FXML
    private Label nameSession19;

    @FXML
    private Label nameSession2;

    @FXML
    private Label nameSession20;

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
    private Label nameSession1;

    @FXML
    private AnchorPane onClickChest;

    @FXML
    private AnchorPane onClickShoulder;

    @FXML
    private AnchorPane onClickStomach;

    @FXML
    private AnchorPane pressMachine;

    @FXML
    private AnchorPane pullDown;

    @FXML
    private AnchorPane pullUp;

    @FXML
    private AnchorPane pushdownTricep;

    @FXML
    private AnchorPane splitSquat;

    @FXML
    private AnchorPane squat;

    @FXML
    private ImageView onClickBack;
    private WebView webView;
    private String[] part;
    private String videoID;
    private UserSession userSession;

    @FXML
    void initialize() {
        userSession = userSession.getInstance();
        AnchorPane[] workoutPane = {
               benchPress,declinePress,dumbbellPress,flyMachine,dips,pressMachine,
               abRoller,barbellPress,lateralRaises,dumbbellRaises,cableTricep,OverheadTricep,
                pushdownTricep,pullUp,pullDown,cableRow,squat,barbellSquat,splitSquat,halfSquat
        };
        Label[] nameLabel ={
                nameSession1, nameSession2,nameSession3,nameSession4,nameSession5,nameSession6,
                nameSession7,nameSession8,nameSession9,nameSession10,nameSession11,nameSession12,
                nameSession13,nameSession14,nameSession15,nameSession16,nameSession17,nameSession18,
                nameSession19,nameSession20
        };

        onClickBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        for (int i = 0 ; i <workoutPane.length ; ++i)
        {
            if(workoutPane[i] != null)
            {
                int tmp = i;
                workoutPane[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                   @Override
                   public void handle(MouseEvent mouseEvent) {
                       userSession.setNamePratice(nameLabel[tmp].getText());
                       try {
                           SwitchScreenController.openNewWindow1(mouseEvent, "set-rep-and-set-screen.fxml",300,300);
                       } catch (IOException e) {
                           throw new RuntimeException(e);
                       }
                   }
               });
            }
        }
    }

}
