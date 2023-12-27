package Main.screen;

import java.io.IOException;

import javax.naming.LimitExceededException;

import aims.Aims;
import cart.Cart;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import media.Book;
import media.CompactDisc;
import media.DigitalVideoDisc;


public class AddMediaController {
	private Cart cart = Aims.cart;
	@FXML
    private Button createBtn;

    @FXML
    private ToggleGroup mediaType;
    
    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    @FXML
    void bookSelected(ActionEvent event) {
    	tfDirector.setDisable(true);
    	tfLength.setDisable(true);
    }

    @FXML
    void cdSelected(ActionEvent event) {
    	
    }


    @FXML
    void dvdSelected(ActionEvent event) {

    }
    
    @FXML
    void createBtnPressed(ActionEvent event) throws LimitExceededException {
    	String title = tfTitle.getText();
    	String category = tfCategory.getText();
    	String director = tfDirector.getText();
    	int length;
    	float cost;
    	try {
    		length = Integer.parseInt(tfLength.getText());    		
    	} catch (Exception e) {
			// TODO: handle exception
    		length = 0;
		}
    	try {    		
    		cost = Float.parseFloat(tfCost.getText());
    	} catch (Exception e) {
    		cost = 0;
    	}
    	RadioButton curBtn = (RadioButton) mediaType.getSelectedToggle();
    	if(curBtn.getText().equals("DVD")) {
    		cart.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
    	} else if(curBtn.getText().equals("CD")) {
    		cart.addMedia(new CompactDisc(title, category, director, length, cost));
    	} else {
    		cart.addMedia(new Book(title, category, cost));
    		
    	}
    	String info = "Title: " + title
					+ "\nCategory: " + category
					+ "\nCost: " + cost;
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(curBtn.getText()+ " added");
    	alert.setContentText(info);
    	alert.show();
    	
    }

    
}
