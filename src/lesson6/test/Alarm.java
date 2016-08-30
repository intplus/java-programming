package lesson6.test;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
public class Alarm extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Button btn = new Button();
        btn.setText("Hello World");
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
