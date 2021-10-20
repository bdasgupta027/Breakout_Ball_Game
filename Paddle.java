import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Paddle extends Actor{

	public Paddle() {
		String path = getClass().getClassLoader().getResource("resources/paddle.png").toString();
		Image img = new Image(path);
		setImage(img);
	}
	
	
	@Override
	public void act(long now) {
		if (getWorld().isPressedDown(KeyCode.LEFT)) {
			setX(getX() - 5);
		}else if (getWorld().isPressedDown(KeyCode.RIGHT)) {
			setX(getX() + 5);
		}
		
	}

}
