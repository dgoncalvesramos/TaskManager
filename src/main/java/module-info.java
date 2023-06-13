module com.myapp.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.myapp.taskmanager to javafx.fxml;
    opens com.myapp.taskmanager.model to javafx.base, javafx.fxml;
    opens com.myapp.taskmanager.controller to javafx.fxml;
    exports com.myapp.taskmanager.controller to javafx.fxml;
    exports com.myapp.taskmanager;
}