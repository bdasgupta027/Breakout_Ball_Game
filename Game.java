


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application{
	private Stage s;
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage stage) throws Exception{
		s = stage;
		stage.setTitle("Ball World");
		
		BorderPane root = new BorderPane();

		
		MainMenu menu = new MainMenu(this);
		root.setCenter(menu);
		Scene scene = new Scene(root, 980, 600);
		
		
		
		
		stage.setScene(scene);
		stage.show();	
		
		
			
	}
	
	public void setScene(BallWorld l) {
		//Make it a Group
		BorderPane root = new BorderPane();
		root.setCenter(l);
		Scene scene = new Scene(root, 700, 700);
		s.setScene(scene);
	}
	
	public void reset(MainMenu m) {
		BorderPane root = new BorderPane();
		root.setCenter(m);
		Scene scene = new Scene(root, 980, 600);
		s.setScene(scene);
	}
}
