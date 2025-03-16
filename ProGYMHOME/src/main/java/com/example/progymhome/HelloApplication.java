package com.example.progymhome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        loadAllFonts();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("welcome-screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 376, 640);
            stage.setTitle("ProGymHome");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file.");
        }
    }

    private void loadAllFonts() {
        URL fontDirUrl = getClass().getResource("/fonts/");
        if (fontDirUrl == null) {
            System.out.println("Font directory not found!");
            return;
        }

        File fontDir = new File(fontDirUrl.getPath());

        if (fontDir.isDirectory()) {
            for (File fontFile : Objects.requireNonNull(fontDir.listFiles())) {
                if (fontFile.getName().endsWith(".ttf") || fontFile.getName().endsWith(".otf")) {
                    try {
                        String fontPath = "/fonts/" + fontFile.getName();
                        Font font = Font.loadFont(getClass().getResource(fontPath).toExternalForm(), 20);
                        if (font != null) {
                            System.out.println("Loaded font: " + font.getName());
                        } else {
                            System.out.println("Failed to load: " + fontFile.getName());
                        }
                    } catch (Exception e) {
                        System.out.println("Error loading font: " + fontFile.getName());
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        launch();
    }
}