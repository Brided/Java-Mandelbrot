package mandelbrot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mandelbrot.image.Mandelbrot;

// Displays Mandelbrot
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Mandelbrot mandelbrot = new Mandelbrot(300, 300);

        Pane root = new Pane(mandelbrot.getImageView());
        Scene scene = new Scene(root, 300, 300);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                mandelbrot.paintBlack();
            }
        });

        primaryStage.setTitle("Mandelbrot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
