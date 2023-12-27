package Main.screen;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddMediaScreen extends JFrame {
	
    public AddMediaScreen() {
    	super();
    	
    	JFXPanel fxPanel = new JFXPanel();
    	this.add(fxPanel);
    	
		this.setTitle("Add media");
		this.setSize(600, 450);
		this.setVisible(true);
    	Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/AddMedia.fxml"));
					Parent root = loader.load();
				 	fxPanel.setScene(new Scene(root));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		});
    }
    
    public static void main(String[] args) {
		new AddMediaScreen();
	}
}
