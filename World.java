import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public abstract class World extends javafx.scene.layout.Pane{
	private AnimationTimer timer;
	private HashSet<KeyCode> hash;
	
	public World() {
		
		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				act(now);
				for (int i = 0; i < getChildren().size(); i++) {
					if (getChildren().get(i) instanceof Actor) {
						((Actor) getChildren().get(i)).act(now);
					}
				}
			}
			
		};
		hash = new HashSet<KeyCode>();
		BackgroundImage myBI= new BackgroundImage(new Image("resources/worldBack.png",700,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		//then you set to your node
		this.setBackground(new Background(myBI));
		
	}

	protected abstract void act(long now);
	
	public void add(Actor actor) {
		getChildren().add(actor);
	}
	
	public void remove(Actor actor) {
		for (int i = 0; i < getChildren().size(); i++) {
			if (getChildren().get(i).equals(actor)) {
				getChildren().remove(i);
			}
		}
	}
	
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public <A extends Actor> java.util.List<A> getObjects(java.lang.Class<A> cls){
		ArrayList<A> arr = new ArrayList<A>();
		
		for (int i = 0; i < getChildren().size(); i++) {
			Node n = getChildren().get(i);
			if (n.getClass().equals(cls) || n.getClass().getSuperclass().equals(cls)) {
				
				arr.add((A) n);
			}
		}
		return arr;
	}
	
	public void addKeyCodes(KeyCode key) {
		hash.add(key);
	}
	
	public void removeKeyCodes(KeyCode key) {
		hash.remove(key);
	}
	
	public boolean isPressedDown(KeyCode key) {
		if (hash.contains(key)) {
			return true; 
		}else {
			return false;
		}
	}
	
	
	
}
