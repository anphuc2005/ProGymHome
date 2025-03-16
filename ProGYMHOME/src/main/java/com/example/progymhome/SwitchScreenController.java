package com.example.progymhome;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class SwitchScreenController {
    public static Stage stage;
    public static Scene scene;
    public static Parent root;

    public static void switchToScene(ActionEvent event, String fxml) throws IOException {

        root = FXMLLoader.load(SwitchScreenController.class.getResource(fxml));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToScene1(MouseEvent event, String fxml) throws IOException {

        root = FXMLLoader.load(SwitchScreenController.class.getResource(fxml));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
