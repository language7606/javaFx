package myapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class FxmlApp2 extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		
		loader.getController();
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
