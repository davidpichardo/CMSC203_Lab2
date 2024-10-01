package application;



import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;




/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	private Button buttonHello, buttonHowdy, buttonChinese, buttonClear, buttonExit;
	private Label labelFeedback;
	private TextField txtField;
	
	private HBox hBox1, hBox2;
	
	//student Task #4:
	private DataManager dataManager;
	
	
    
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		buttonHello = new Button("Hello");
		buttonHowdy = new Button("Howdy");
		buttonChinese = new Button("Chinese");
		buttonClear = new Button("Clear");
		buttonExit = new Button("Exit");
		
		labelFeedback = new Label("Feedback:");
		txtField = new TextField();
		
		hBox1 = new HBox();
		hBox2 = new HBox();
		
		hBox1.setSpacing(10);
		hBox2.setSpacing(10);
		hBox1.setPadding(new Insets(15));
		hBox2.setPadding(new Insets(15));
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		
		
		//student Task #4:
		dataManager = new DataManager();
		
		buttonHello.setOnAction(new ButtonHandler());
		buttonHowdy.setOnAction(new ButtonHandler());
		buttonChinese.setOnAction(new ButtonHandler());
		buttonClear.setOnAction(new ButtonHandler());
		buttonExit.setOnAction(new ButtonHandler());
		
		
		//student Task #3:
		hBox1.getChildren().addAll(labelFeedback, txtField);
		hBox2.getChildren().addAll(buttonHello, buttonHowdy, buttonChinese, buttonClear, buttonExit);
		getChildren().addAll(hBox1, hBox2);
	}
	
	//Task #4:
	private class ButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			Object source = event.getSource();
			if(source == buttonHello) {
				txtField.setText(dataManager.getHello());
			}
			else if(source == buttonHowdy) {
				txtField.setText(dataManager.getHowdy());
				
			}
			else if(source == buttonChinese) {
				txtField.setText(dataManager.getChinese());
				
			}
			else if(source == buttonClear) {
				txtField.setText("");
			}
			else if (source == buttonExit) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
