import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane();

        Scene scene = new Scene(ballPane, 400, 400);
        
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                ballPane.moveLeft();
            } else if (e.getCode() == KeyCode.RIGHT) {
                ballPane.moveRight();
            } else if (e.getCode() == KeyCode.UP) {
                ballPane.moveUp();
            } else if (e.getCode() == KeyCode.DOWN) {
                ballPane.moveDown();
            }
        });

        primaryStage.setTitle("Move the Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        ballPane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class BallPane extends Pane {
    private final Circle ball;
    private final double radius = 20;
    private final double step = 10; 

    public BallPane() {
        ball = new Circle(200, 200, radius);
        ball.setFill(Color.RED);
        ball.setStroke(Color.BLACK);
        this.getChildren().add(ball);
    }

    public void moveLeft() {
        if (ball.getCenterX() - radius - step >= 0) {
            ball.setCenterX(ball.getCenterX() - step);
        }
    }

    public void moveRight() {
        if (ball.getCenterX() + radius + step <= this.getWidth()) {
            ball.setCenterX(ball.getCenterX() + step);
        }
    }

    public void moveUp() {
        if (ball.getCenterY() - radius - step >= 0) { 
            ball.setCenterY(ball.getCenterY() - step);
        }
    }

    public void moveDown() {
        if (ball.getCenterY() + radius + step <= this.getHeight()) {
            ball.setCenterY(ball.getCenterY() + step);
        }
    }
}
