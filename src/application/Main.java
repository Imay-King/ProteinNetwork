package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * @Yiming
 * This is main class for project
 * 
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Windows.fxml"));
	//		AnchorPane chart = (AnchorPane)FXMLLoader.load(getClass().getResource("Barchart.fxml"));
			Scene scene = new Scene(root,700,500);
		
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public  void showStatistics(Network nw) {
		 // TODO Auto-generated method stub
	    	 try {
	    		 	
	    		// 	loader.setLocation(Main.class.getResource("Barchart.fxml"));
	    	        // Load the fxml file and create a new stage for the table.
	    		  
	    		 	AnchorPane page = (AnchorPane)FXMLLoader.load(getClass().getResource("Barchart.fxml"));
	    	//	  	WindowsController wc=loader.getController();
	    	//      	wc.setNetwork(nw);
	    		 	Stage dialogStage = new Stage();
	    	        Scene scene = new Scene(page,700,600);
	    	        dialogStage.setScene(scene);
	    	        dialogStage.show();

	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }
	     }
  
	public static void main(String[] args) {
		launch(args);
	}
}
