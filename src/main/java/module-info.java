module com.example.java_project_library {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;

    opens com.example.java_project_library to javafx.fxml;
    exports com.example.java_project_library;
}