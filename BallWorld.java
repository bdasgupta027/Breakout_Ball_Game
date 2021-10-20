import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class BallWorld extends World{
	private Ball ball;
	private Paddle paddle;
	private Score score;
	private ExtraBall exball;
	
	@Override
	protected void act(long now) {
		
		
	}

	public BallWorld() {
		
		ball = new Ball(); 
		ball.setX(0);
		ball.setY(0);
		
		getChildren().add(ball);
		
		score = new Score();
		score.setX(15);
		score.setY(15);
		getChildren().add(score);
		
		paddle = new Paddle();
		paddle.setX(300);
		paddle.setY(400);
		getChildren().add(paddle);
		
		setOnMouseMoved(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				paddle.setX(event.getX() - (paddle.getWidth() / 2));
			}
		});
		
		requestFocus();
		setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {
					paddle.setX(paddle.getX() - 15);
				}else if (event.getCode() == KeyCode.RIGHT) {
					paddle.setX(paddle.getX() + 15);
				}
				
					addKeyCodes(event.getCode());
				
			}
			
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				removeKeyCodes(event.getCode());
						
			}
			
		});
		
		start();
	}
	

	public Score getScore() {
		return score;
	
	}
	
	
	public Ball getBall() {
		return ball;
	}
	
	public Paddle getPaddle() {
		return paddle;
	}
	
	public void addExtraBall() {
		exball = new ExtraBall();
		exball.setX(paddle.getX() + (paddle.getWidth() / 2));
		exball.setY(paddle.getY() - this.getWidth());
		getChildren().add(exball);
		
	}
	
	public ExtraBall getExtraBall() {
		return exball;
	}
}




