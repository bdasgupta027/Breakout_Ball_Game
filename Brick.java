import javafx.scene.image.Image;

public class Brick extends Actor{
	private int numHits;
	private boolean isFading;
	
	
	public Brick(){
		String path = getClass().getClassLoader().getResource("resources/brick.png").toString();
		Image img = new Image(path);
		setImage(img);
		isFading = false;
	}
	
	@Override
	public void act(long now) {
		
		
	}
	
	public void incrementHits() {
		numHits++;
	}
	
	public int getHits() {
		return numHits;
	}
	
	public boolean getFading() {
		return isFading;
	}

	public void setFading(boolean b) {
		isFading = b;
	}
}