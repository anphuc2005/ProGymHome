module com.example.progymhome {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;
    requires javafx.graphics;
    requires java.desktop;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens com.example.progymhome to javafx.fxml;
    exports com.example.progymhome;

    opens com.example.exfxwebview to javafx.fxml;
    exports com.example.exfxwebview;
    exports com.example.progymhome.Screen;
    opens com.example.progymhome.Screen to javafx.fxml;
    opens com.example.progymhome.User to com.google.gson;
}
