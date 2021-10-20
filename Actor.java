import java.util.ArrayList;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

public abstract class Actor extends javafx.scene.image.ImageView{
	public abstract void act(long now);
	
	public void move(double dx, double dy) {
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
	}
	
	public World getWorld() {
		return (World)this.getParent();
	}
	
	public double getWidth() {
		Bounds bounds = this.getBoundsInLocal();
		double width = bounds.getMaxX() - bounds.getMinX();
		return width;
	}
	
	public double getHeight() {
		Bounds bounds = this.getBoundsInLocal();
		double height = bounds.getMaxY() - bounds.getMinY();
		return height;
	}
	
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
		ArrayList<A> arr = new ArrayList<A>();
		for (A actor: ((World) getWorld()).getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                arr.add(actor);
            }
        }
		return arr;

	}
	
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
		for (A actor: ((World) getWorld()).getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                return actor;
            }
        }
		return null;
	}
	
	
}
