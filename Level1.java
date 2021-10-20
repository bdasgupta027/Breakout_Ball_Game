import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class Level1 extends BallWorld{
	private int numBricks;
	private Game game;
	private boolean ballAdded;

	
	@Override
	protected void act(long now) {
		if ((getScore().getCurrentScore() % 300) == 0 && getScore().getCurrentScore() != 0) {
			stop();
			if (ballAdded == false) {
				ExtraBall ex = new ExtraBall();
				ex.setX(0);
				ex.setY(0);
				getChildren().add(ex);
				ballAdded = true;
			}
			start();
			
		}
		if (getScore().getCurrentScore() >= 1500 || numBricks == 7) {
			stop();
			Level2 level2 = new Level2(game);
			Levels l = new Levels(level2);
			game.setScene(level2);	
		}
		if (numBricks == 0 && getScore().getCurrentScore() <= 1500) {
			Dialog<String> dialog = new Dialog<String>();
			dialog.setContentText("Level failed. Try again!");
			ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.show();
			MainMenu m = new MainMenu(game);
			game.reset(m);
		}
		
		
	}
	
	public Level1(Game g) {
		super();
		ballAdded = false;
		game = g;
		numBricks = 0;
		
		for (int i = 0; i < 4; i++) {
			Brick brick = new Brick();
			brick.setX(100);
			brick.setY(i * 100);
			getChildren().add(brick);
			numBricks ++;
		}
		
		for (int i = 0; i < 4; i++) {
			Brick2 brick = new Brick2();
			brick.setX(200);
			brick.setY((i * 100) + 50);
			getChildren().add(brick);
			numBricks ++;
		}
		
		for (int i = 0; i < 4; i ++) {
			Brick brick = new Brick();
			brick.setX(300);
			brick.setY(i * 100);
			getChildren().add(brick);
			numBricks ++;
		}
		
		for (int i = 0; i < 4; i ++) {
			Brick2 brick = new Brick2();
			brick.setX(400);
			brick.setY((i * 100) + 50);
			getChildren().add(brick);
			numBricks ++;
		}
		
		for (int i = 0; i < 4; i ++) {
			Brick brick = new Brick();
			brick.setX(500);
			brick.setY(i * 100);
			getChildren().add(brick);
			numBricks ++;
		}
		
		
	}
	
	public int getNumBricks() {
		return numBricks;
	}
	
	public void removeBrick() {
		numBricks --;
	}

}
