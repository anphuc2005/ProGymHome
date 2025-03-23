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


    public static void switchToScene(ActionEvent event, String fxml) throws IOException {
        Parent root = FXMLLoader.load(SwitchScreenController.class.getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void switchToScene1(MouseEvent event, String fxml) throws IOException {
        Parent root = FXMLLoader.load(SwitchScreenController.class.getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void openNewWindow(ActionEvent event, String fxml, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SwitchScreenController.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, width, height);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
    }


    public static void openNewWindow1(MouseEvent event, String fxml, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SwitchScreenController.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, width, height);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
    }
}
