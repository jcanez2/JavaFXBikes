import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;

public class ControlPane extends GridPane
{
    private BicyclePane bicycle1, bicycle2;
    private TilePane Sub1, Sub2;
    private BorderPane Sub3, Sub4;

    private Button start1, start2, stop1, stop2, reverse1, reverse2;
    private Label label1, label2;
    private Slider slider1, slider2;

    public ControlPane()
    {

        this.setPrefSize(800, 400);

        /********************************************************************************/
        //instantiate slider1 and set its properties
        label1 = new Label("Red Speed");
        slider1 = new Slider(0,50,20);
        slider1.setMajorTickUnit(10);
        slider1.setMinorTickCount(1);
        slider1.setShowTickLabels(true);
        slider1.setShowTickMarks(true);
        slider1.setOrientation(Orientation.VERTICAL);
        Sub3 = new BorderPane();
        Sub3.setPrefWidth(30);
        Sub3.setTop(label1);
        //Sub3.setCenter(slider1);


        //instantiate slider2 and set its properties
        label2 = new Label("Blue Speed");
        slider2 = new Slider(0,50,20);
        slider2.setMajorTickUnit(10);
        slider2.setMinorTickCount(1);
        slider2.setShowTickLabels(true);
        slider2.setShowTickMarks(true);
        slider2.setOrientation(Orientation.VERTICAL);
        Sub4 = new BorderPane();
        Sub4.setTop(label2);
        //Sub4.setCenter(slider2);

        start1 = new Button("Start Red");
        stop1 = new Button("Stop Red");
        reverse1 = new Button("Reverse Red");
        Sub1 = new TilePane();
        //Sub1.getChildren().add(start1);
        //Sub1.getChildren().add(stop1);
        //Sub1.getChildren().add(reverse1);
        Sub1.setPrefColumns(1);
        Sub1.setVgap(10);
        Sub1.setHgap(10);


        start2 = new Button("Start Blue");
        stop2 = new Button("Stop Blue");
        reverse2 = new Button("Reverse Blue");
        Sub2 = new TilePane();
        Sub2.setPrefTileWidth(90);
        //Sub2.getChildren().add(start2);
        //Sub2.getChildren().add(stop2);
        //Sub2.getChildren().add(reverse2);
        Sub2.setPrefColumns(1);
        Sub2.setVgap(10);
        Sub2.setHgap(10);
        /********************************************************************************/





        BicyclePane pane1 = new BicyclePane(Color.YELLOW, 660, 200, Color.RED);
        BicyclePane pane2 = new BicyclePane(Color.BEIGE, 660,200,Color.BLUE);
        this.add(Sub1,0,0);
        this.add(Sub3,1,0);
        this.add(Sub2,0,1);
        this.add(Sub4,1,1);
        this.add(pane1,2,0);
        this.add(pane2,2,1);

    }

    /*public class PauseAnimation implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) throws NullPointerException
        {

        }
    }*/

    /*public class PlayAnimation implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) throws NullPointerException        {
            if (bicycle1.playing == false)
            {
                bicycle1.transition.play();
                bicycle1.playing = true;
            }
        }
    }*/

    /*public void playmyAnimation(ActionEvent event) throws IOException
    {
        if (event.getSource().equals(start1))
        {
            bicycle1.transition.play();
            bicycle1.playing = true;
        }
    }*/




}
