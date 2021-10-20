import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Ball extends Actor{
	private double dx;
	private double dy;


	public Ball() {	
		String path = getClass().getClassLoader().getResource("resources/ball.png").toString();
		Image img = new Image(path);
		setImage(img);
		dx = 2;
		dy = 2; 

	}
	@Override
	public void act(long now) {
		//figure out how to do bouncing 
		this.move(dx, dy);
		if (this.getX() == 0|| (this.getX() + this.getWidth()) >= getWorld().getWidth()) {
			dx = -dx;
		}
		if (this.getY() == 0 || (this.getY() + this.getHeight() >=  getWorld().getWidth())) {
			dy = -dy;
		}
		if (this.getOneIntersectingObject(Paddle.class) != null) {
			Paddle p = this.getOneIntersectingObject(Paddle.class);
			if(this.getX() > p.getX() + (p.getWidth() / 3) && this.getX() < p.getX() + ((p.getWidth() * 2) / 3)) {
				if (getWorld().isPressedDown(KeyCode.LEFT) || getWorld().isPressedDown(KeyCode.RIGHT)) {
					dy = -dy;
				}
			}
			if(this.getX() > p.getX() && this.getX() < p.getX() + (p.getWidth() / 3)) {
				if (getWorld().isPressedDown(KeyCode.LEFT) || getWorld().isPressedDown(KeyCode.RIGHT)) {
					if((dx > 0 && dy > 0)) {
						dy = -dy;
						dx = -dx;
					}else {
						dy = -dy;
					}
				}
			}
			if(this.getX() > p.getX() + ((p.getWidth() * 2) / 3) && this.getX() < p.getX() + p.getWidth()) {
				if (getWorld().isPressedDown(KeyCode.LEFT) || getWorld().isPressedDown(KeyCode.RIGHT)) {
					if((dx < 0 && dy > 0) || (dx > 0 && dy < 0)) {
						dy = -dy;
						dx = -dx;
					}else {
						dy = -dy;
					}
				}
			}
			if(this.getX() == p.getX()) {
				dy = -dy * 0.5;
			}
			if(this.getX() == p.getX() + p.getWidth()) {
				dy = -dy * 0.5;
			}
			if(this.getX() > p.getX() && this.getX() < p.getX() + p.getWidth()) {
				if (!getWorld().isPressedDown(KeyCode.LEFT) && !getWorld().isPressedDown(KeyCode.RIGHT)) {
					dy = -dy;
				}
			}
			
		}
		if (this.getY() + this.getHeight() == this.getWorld().getHeight()) {
			((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getCurrentScore() - 1000);
		}
		Brick b = this.getOneIntersectingObject(Brick.class);

		if(b != null && !b.getFading()) {
			
			b.incrementHits();
			if (b.getHits() == 1) {
				FadeTransition ft = new FadeTransition(Duration.millis(1000), b);
				ft.setFromValue(1.0);
				ft.setToValue(0.1);
				ft.setCycleCount(1);
				ft.setAutoReverse(true);

				ft.play();
				b.setFading(true);

				((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getCurrentScore() + 100);
				ft.setOnFinished(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						getWorld().remove(b);

					}

				});
			}

			if(this.getX() > b.getX() && this.getX() < b.getX() + b.getWidth()) {
				dy = -dy;
			} else if(this.getY() > b.getY() && this.getY() < b.getY() + b.getHeight()) {
				dx= -dx;
			} else {
				dx= -dx;
				dy = -dy;
			}

		}
		if(this.getOneIntersectingObject(Brick2.class) != null && !this.getOneIntersectingObject(Brick2.class).getFading2()) {
			Brick2 b2 = this.getOneIntersectingObject(Brick2.class);
			b2.incrementHits();
			if (b2.getHits() == 2 || !b2.getFading2()) {
				FadeTransition ft = new FadeTransition(Duration.millis(1000), b2);
				ft.setFromValue(1.0);
				ft.setToValue(0.1);
				ft.setCycleCount(1);
				ft.setAutoReverse(true);

				ft.play();
				b2.setFading2(true);
				((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getCurrentScore() + 200);
				ft.setOnFinished(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						
						getWorld().remove(b2);

					}

				});
			}
			if(this.getX() > b2.getX() && this.getX() < b2.getX() + b2.getWidth()) {
				dy = -dy;
			} else if(this.getY() > b2.getY() && this.getY() < b2.getY() + b2.getHeight()) {
				dx= -dx;
			} else {
				dx= -dx;
				dy = -dy;
			}

		}

	}
	
	public void setdX(double x) {
		dx = x;
	}
	
	public void setdY(double y) {
		dy = y;
	}
}
