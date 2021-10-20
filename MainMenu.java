

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainMenu extends javafx.scene.layout.BorderPane{
	public MainMenu(Game g) {
		BorderPane bP = new BorderPane(); 
		ToolBar tool = new ToolBar();
		
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.1);
		
		Button i = new Button("Instructions");
		tool.getItems().add(i);
		Button sg = new Button("Start Game");
		Button k = new Button("Keys");
		tool.getItems().add(k);
		tool.getItems().add(sg);
		bP.setTop(tool);
		i.setEffect(bloom);
		sg.setEffect(bloom);
		k.setEffect(bloom);
		i.setStyle("-fx-border-color: #0307fc; -fx-font-size: 20; -fx-background-color: #4d91e3; -fx-border-width: 2");
		sg.setStyle("-fx-border-color: #0307fc; -fx-font-size: 20; -fx-background-color: #4d91e3; -fx-border-width: 2");
		k.setStyle("-fx-border-color: #0307fc; -fx-font-size: 20; -fx-background-color: #4d91e3; -fx-border-width: 2");
		
		
		
		ImageView background = new ImageView();
		String path = getClass().getClassLoader().getResource("resources/mainmenu.png").toString();
		Image img = new Image(path);
		background.setImage(img);
		bP.setLeft(background);
		bP.setPrefWidth(img.getWidth());
		
		Text text = new Text("Breakout Game");
		bP.setCenter(text);
		
		
		
		getChildren().addAll(bP);
		k.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {

					Dialog<String> dialog = new Dialog<String>();
					
					dialog.setTitle("Keys");
					dialog.setContentText("To move the paddle to the left, slide your mouse to the left\n"
							+ "or press the left arrow key.\n"
							+ "To move the paddle to the right, slide your mouse to the right\n"
							+ "or press the right arrow key.");
					ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
					dialog.getDialogPane().getButtonTypes().add(type);
					dialog.show();
				
			}
		});
		
		
		i.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Dialog<String> dialog = new Dialog<String>();
				dialog.setContentText("Instructions:\n"
						+ "Press Start Game to start the game. Slide your mouse or press the arrow"
						+ "keys to move the paddle. The goal is to break all the bricks in the level. "
						+ "Some bricks require two hits while others require only one. Each time you hit a brick,"
						+ "your score increases by 100. If you hit the ground, your score decreases by 500 points. Your "
						+ "goal is to pass all 3 levels of the game with at least a score of 1000. Certain powerups will "
						+ "be available:\n"
						+ "1. Extra ball: As soon as the extra ball hits the bottom of the screen, it will disappear\n"
						+ "2. Bigger ball: Ball size will be increased to twice the size. ");
				ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.show();
						
				
			}
			
		});
		sg.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				
				Level1 level1 = new Level1(g);
				Levels l = new Levels(level1);
				
				g.setScene(level1);

			}
			
		});
	}
}
