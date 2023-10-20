module AppScreen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;

    opens AppScreen to javafx.fxml;
    exports AppScreen;
    exports Controller;
    opens Controller to javafx.fxml;
}