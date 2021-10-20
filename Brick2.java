

import javafx.scene.image.Image;

public class Brick2 extends Actor{
	private int numHits;
	private boolean isFading;
	public Brick2(){
		numHits = 0;
		String path = getClass().getClassLoader().getResource("resources/brick2.png").toString();
		Image img = new Image(path);
		setImage(img);
		isFading = false;
	}
	
	public void act(long now) {
		
		
	}

	public void incrementHits() {
		numHits++;
	}
	
	public int getHits() {
		return numHits;
	}
	
	public boolean getFading2() {
		return isFading;
	}

	public void setFading2(boolean b) {
		isFading = b;
	}
	
}
