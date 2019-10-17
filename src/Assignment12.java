import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Assignment12 extends Application
{
    private final int WIDTH = 640;
    private final int HEIGHT = 300;

    public void start(Stage primaryStage)
    {

        ControlPane pane = new ControlPane();
        StackPane rootPane = new StackPane();

        //rootPane.getChildren().add(pane);

        rootPane.getChildren().add(pane);

        // Create a scene and place rootPane in the stage
        Scene scene = new Scene(rootPane, 810, 400);

        primaryStage.setTitle("Two Bicycles");
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    public static void main(String[] args)
    {
        Application.launch(args);
    }

}