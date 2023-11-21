module AppScreen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires com.google.gson;

    opens AppScreen to javafx.fxml;
    exports AppScreen;
    exports Controller;
    opens Controller to javafx.fxml;
}