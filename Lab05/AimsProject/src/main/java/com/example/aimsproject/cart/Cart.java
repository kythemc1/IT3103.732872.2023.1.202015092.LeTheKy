package com.example.aimsproject.cart;

import java.util.ArrayList;
import java.util.List;

import javax.naming.LimitExceededException;

import com.example.aimsproject.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered =  FXCollections.observableArrayList();
	
	public ObservableList<Media> getItemOrdered() {
		return itemsOrdered;
	}
	// Add Disc
	public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
		
		if (itemsOrdered.add(media)) {
			System.out.println("The media has been successfully added.");
		} else {
			System.out.println("Something wrong happened. Please try again.");
		}
		
		if(itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("Info: The cart is full.");
		}
	}
	
	public void addMedia(Media ...media) throws LimitExceededException {
		int numDisc = media.length;
		if (itemsOrdered.size() + numDisc > MAX_NUMBERS_ORDERED) {
			System.out.println("Cannot add all select media, the cart does not have enough space.");
			return;
		} else {
			for (Media m: media) {
				addMedia(m);
			}
		}
		
	}
	
	// Remove Disc
	public void removeMedia(Media media) {
		if (itemsOrdered.size() == 0) {
			System.out.println("Cannot remove media, the cart is empty.");
			return;
		}
		
		if (itemsOrdered.remove(media)) {
			System.out.println("The media has been successfully removed.");
		} else {
			System.out.println("Something wrong happened. Please try again.");
		}
		
		if(itemsOrdered.size() == 0) {
			System.out.println("Info: The cart is empty.");
		}
		
	}
	
	
	// Calculate the total cost
	public float totalCost() {
		float total = 0.0f;
		for (Media m : itemsOrdered) {
			total += m.getCost();
		}
		return total;
	}
	
	public ArrayList<Media> searchById(String id) {
		ArrayList<Media> res = new ArrayList<Media>();
		for (Media m: itemsOrdered) {
			if(String.valueOf(m.getId()).contains(id)) {
				res.add(m);
			}
		}
		if(res.size() == 0) {
			System.out.println("No media matches the search ID.");
			return null;
		}
		return res;
	}
	
	public ArrayList<Media> searchByTitle(String... titles) {
		ArrayList<Media> res = new ArrayList<Media>();
		for (Media d: itemsOrdered) {
			if(isMatch(d.getTitle(), titles)) {
				res.add(d);
			}
		}
		if(res.size() == 0) {
			System.out.println("No media matches the search titles.");
			return null;
		}
		return res;
	}
	
	// Method Print	
	public void print() {
		String cartString = "\n************************************CART************************************\n";
		System.out.println(cartString);
		if(itemsOrdered.size() == 0) {
			System.out.println("The cart is empty.");
		}
		for (int i = 0; i < itemsOrdered.size(); i++ ) {
			Media m = itemsOrdered.get(i);
			System.out.print(String.valueOf(i+1) + ". ");
			m.print();
		}
		System.out.println(cartString);
	}
	
	
	private boolean isMatch(String title, String[] searchTitles) {
		for (String t: searchTitles) {
			if(title.contains(t)) {
				return true;
			}
		}
		return false;
	}
	
	public void emptyCart() {
		itemsOrdered = FXCollections.observableArrayList();
	}
	
}
