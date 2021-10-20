import javafx.scene.Scene;

public class Levels extends Scene{
	private Score score;
	private int numBricks;
	
	public Levels(BallWorld b) {
		super(b);
		
		numBricks = 0;
	}

	protected void act(long now) {
//		if (getWorld().getScore() == 500) {
//			
//		}
		
	}
	
	
	public int getNumBricks() {
		return numBricks;
	}
	
	public void setNumBricks(int num) {
		numBricks = num;
	}
	
}
