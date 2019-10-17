import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class BicyclePane extends Pane
{
    Color bg;
    TranslateTransition transition;
    RotateTransition rotateTransition;
    RotateTransition rotateTransition2;
    boolean playing = false;
    Button testButton;
    Button testStopButton;
    Button testReverseButton;
    Boolean bOrR = false;
    String startLbl = "Start Red";
    String stopLbl = "Stop Red";
    String revLbl = "Reverse Red";
    private Slider slider;
    Group g;

    public BicyclePane(javafx.scene.paint.Color backgroundColor, int width, int height, Color CirColor)
    {
        if (CirColor == Color.BLUE)
        {
            startLbl = "Start Blue";
            stopLbl = "Stop Blue";
            revLbl = "Reverse Blue";
        }

        slider = new Slider(0,50,20);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setLayoutX(-50);
        slider.setLayoutY(20);
        slider.onDragDoneProperty();
        this.getChildren().add(slider);

        testButton = new Button(startLbl);
        testButton.setLayoutX(-140);
        testButton.setLayoutY(30);
        testButton.setOnAction(new PlayAnimation());
        this.getChildren().add(testButton);

        testStopButton = new Button(stopLbl);
        testStopButton.setLayoutX(-140);
        testStopButton.setLayoutY(70);
        testStopButton.setOnAction(new StopAnimation());
        this.getChildren().add(testStopButton);

        testReverseButton = new Button(revLbl);
        testReverseButton.setLayoutX(-140);
        testReverseButton.setLayoutY(110);
        testReverseButton.setOnAction(new ReverseAnimation());
        this.getChildren().add(testReverseButton);

        slider.setOnMouseReleased(new MouseHandler());

        /*******************************************Shape*************************************************************/
        Line line1 = new Line(140, 150, 50, 150);
        line1.setStrokeWidth(3);
        line1.setStroke(CirColor);

        Line back = new Line(95, 100, 50, 150);
        back.setStrokeWidth(3);
        back.setStroke(CirColor);

        Line front = new Line(140, 150, 95, 100);
        front.setStrokeWidth(3);
        front.setStroke(CirColor);

        Line seat = new Line(140, 100, 50, 100);
        seat.setStrokeWidth(3);
        seat.setStroke(CirColor);

        Rectangle rect = new Rectangle(110, 120, 60,60);
        rect.setFill(CirColor);

        Rectangle rect2 = new Rectangle(20, 120, 60,60);
        rect2.setFill(CirColor);

        /*********************************************Movement********************************************************/
        g = new Group();
        g.getChildren().addAll(rect,rect2, line1, front, back, seat);

        transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setToX(460);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(g);

        rotateTransition = new RotateTransition(Duration.seconds(3), rect);
        rotateTransition.setByAngle(360);
        rotateTransition.setRate(1);
        rotateTransition.setCycleCount(0);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setDelay(Duration.seconds(0));

        rotateTransition2 = new RotateTransition(Duration.seconds(3), rect2);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setRate(1);
        rotateTransition2.setCycleCount(0);
        rotateTransition2.setDelay(Duration.seconds(0));
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.setCycleCount(Animation.INDEFINITE);
        rotateTransition2.setAutoReverse(true);
        rotateTransition2.setDelay(Duration.seconds(0));

        this.setPrefSize(width, height);
        this.bg = backgroundColor;
        String hexColor = Integer.toHexString(bg.hashCode());
        this.setStyle("-fx-background-color: #" + hexColor);
        this.getChildren().add(g);

    }

    public class PlayAnimation implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) throws NullPointerException        {
            if (playing == false)
            {
                transition.play();
                //transition2.play();
                rotateTransition.play();
                rotateTransition2.play();
                playing = true;
            }
        }
    }

    public class StopAnimation implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) throws NullPointerException
        {
            if (playing == true)
            {
                transition.pause();
                //transition2.pause();
                rotateTransition.pause();
                rotateTransition2.pause();
                playing = false;
            }
        }
    }

    public class ReverseAnimation implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) throws NullPointerException
        {
            if (playing == true)
            {
                transition.pause();
                transition.play();
                transition.setRate(transition.getRate()*-1);
                rotateTransition.setRate(transition.getRate()*-1);
                rotateTransition2.setRate(transition.getRate()*-1);

            }
        }
    }

    private class MouseHandler implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent event)//HANDLES MOUSE BUTTON PRESS
        {
            transition.setRate(slider.getValue()*.1);
            rotateTransition.setRate(slider.getValue()*.1);
            rotateTransition2.setRate(slider.getValue()*.1);
        } // end handler
    } // end MouseHandler




}
