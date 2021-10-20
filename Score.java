import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Score extends Text{
	private int score; 
	
	public Score() {
		score = 0;
		setFont(new Font(18));
		setFill(Color.WHITE);
		updateDisplay();
	}
	public void updateDisplay() {
		setText(String.valueOf(score));
	}
	
	public int getCurrentScore() {
		return score;
	}
	
	public void setScore(int s) {
		score = s;
		updateDisplay();
	}
	
	

}
