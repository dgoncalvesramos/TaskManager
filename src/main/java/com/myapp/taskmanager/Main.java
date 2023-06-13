package com.myapp.taskmanager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
            primaryStage.setTitle("Task Manager");
        primaryStage.show();
    }
}
