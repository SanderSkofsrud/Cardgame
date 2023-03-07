package edu.ntnu.idatt2001;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;

public class CardGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("CardGame");
        stage.setScene(scene);
        stage.show();
    }
}
