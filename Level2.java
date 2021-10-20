import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class Level2 extends BallWorld{

	private int numBricks;
	private Game game;
	private boolean ball1Added = false;
	private boolean ball2Added = false;
	
	
	@Override
	protected void act(long now) {
		if (((getScore().getCurrentScore() % 300) == 0 && getScore().getCurrentScore() != 0 && ball1Added == false && ball2Added == false)) {
			stop();
			if (ball1Added == false) {
				ExtraBall ex = new ExtraBall();
				ex.setX(0);
				ex.setY(0);
				getChildren().add(ex);
				ball1Added = true;
			}
			start();
			
		}
		if (((getScore().getCurrentScore() % 500) == 0 && getScore().getCurrentScore() != 0 && ball1Added == true && ball2Added == false)) {
			stop();
			if (ball2Added == false) {
				ExtraBall ex = new ExtraBall();
				ex.setX(0);
				ex.setY(0);
				getChildren().add(ex);
				ball2Added = true;
			}
			start();
		}
		if (getScore().getCurrentScore() >= 5000 || numBricks == 7) {
			stop();
			Dialog<String> dialog = new Dialog<String>();
			dialog.setContentText("Congratulations! You have successfully"
					+ " completed the game!");
			ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.show();
			MainMenu menu = new MainMenu(game);
			
			game.reset(menu);
		}
		
	}
	
	public Level2(Game g) {
		super();
		game = g;
		numBricks = 0;
		
		getBall().setdX(2.5);
		getBall().setdY(2.5);

		Brick brick = new Brick();
		brick.setX(100);
		brick.setY(50);
		getChildren().add(brick);
		numBricks++;
		
		Brick2 brick2 = new Brick2();
		brick2.setX(130);
		brick2.setY(50);
		getChildren().add(brick2);
		numBricks++;
		
		Brick brick3 = new Brick();
		brick3.setX(160);
		brick3.setY(50);
		getChildren().add(brick3);
		numBricks++;
		
		for (int x = 220; x < 600; x+= 60) {
			Brick brick4 = new Brick();
			brick4.setX(x);
			brick4.setY(50);
			getChildren().add(brick4);
			numBricks++;
		}
		
		for (int x = 190; x < 600; x+= 60) {
			Brick2 brick5 = new Brick2();
			brick5.setX(x);
			brick5.setY(50);
			getChildren().add(brick5);
			numBricks++;
		}
		
		for (int x = 220; x < 600; x+= 60) {
			Brick brick4 = new Brick();
			brick4.setX(x);
			brick4.setY(150);
			getChildren().add(brick4);
			numBricks++;
		}
		
		for (int x = 190; x < 600; x+= 60) {
			Brick2 brick5 = new Brick2();
			brick5.setX(x);
			brick5.setY(150);
			getChildren().add(brick5);
			numBricks++;
		}
		
		for (int x = 250; x < 600; x+= 60) {
			Brick brick4 = new Brick();
			brick4.setX(x);
			brick4.setY(250);
			getChildren().add(brick4);
			numBricks++;
		}
		
		for (int x = 220; x < 600; x+= 60) {
			Brick2 brick5 = new Brick2();
			brick5.setX(x);
			brick5.setY(250);
			getChildren().add(brick5);
			numBricks++;
		}
		
		for (int x = 280; x < 600; x+= 60) {
			Brick brick4 = new Brick();
			brick4.setX(x);
			brick4.setY(350);
			getChildren().add(brick4);
			numBricks++;
		}
		
		for (int x = 250; x < 600; x+= 60) {
			Brick2 brick5 = new Brick2();
			brick5.setX(x);
			brick5.setY(350);
			getChildren().add(brick5);
			numBricks++;
		}
		
		
		
		
		
	}
	
	public int getNumBricks() {
		return numBricks;
	}
	
	public void removeBrick() {
		numBricks --;
	}
	
}
