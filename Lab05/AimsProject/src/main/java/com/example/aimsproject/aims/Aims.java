package com.example.aimsproject.aims;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import com.example.aimsproject.cart.Cart;
import com.example.aimsproject.exception.PlayerException;
import com.example.aimsproject.media.*;
import com.example.aimsproject.store.Store;

public class Aims {
	public static Store store = new Store();
	public static Cart cart = new Cart();
	
	public static void showMenu() { 
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 
	} 

	public static void storeMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
	} 
	
	public static void mediaDetailsMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2"); 
	} 
	
	public static void init() {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("a");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("b","c",10);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("e", "f", "g", 5);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("h", "i", "j", 99, 7.5f);
		
		Track track1 = new Track("abcdefg");
		Track track2 = new Track("hijklmnop", 5);
		
		CompactDisc cd1 = new CompactDisc("aa", "b", "cc", 60, 9);
		cd1.addTrack(track1, track2);
		CompactDisc cd2 = new CompactDisc("ab", "bb", "dd", 6);
		CompactDisc cd3 = new CompactDisc("zz", "yz", 10);
		CompactDisc cd4 = new CompactDisc("a-z");
		
		
		Book book1 = new Book("JJ");
		Book book2 = new Book("AA", "ZZ", 8);
		
		store.addMedia(dvd1,dvd2,dvd3,dvd4,cd1,cd2,cd3,cd4,book1,book2);
	}
	
	public static void cartMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5"); 
		} 
	
	public static void main(String[] args) throws LimitExceededException, PlayerException {
		init();
		Scanner scanner = new Scanner(System.in);
		showMenu:while(true) {
			showMenu();
			String option = scanner.nextLine();
			switch (option) {
			case "1": {
				viewStoreInteractive();
				break;
			}
			case "2": {
				updateStoreInteractive();
				break;
			}
			case "3": {
				cartMenuInteractive();
				break;
			}
			case "0": {
				scanner.close();
				break showMenu;
			}
			default:
				System.out.println("Wrong option, please try again.");
			}
		}
	}
	
	private static void viewStoreInteractive() throws LimitExceededException, PlayerException {
		Scanner scanner = new Scanner(System.in);
		storeMenu:while(true) {
			storeMenu();
			String option = scanner.nextLine();
			switch (option) {
			case "1": {
				String keyword = scanner.nextLine();
				ArrayList<Media> medias= store.searchByTitle(keyword);
				System.out.println("No. - Title - Category - Director/Artist/Author - Length - Cost - ID");
				if(medias == null) {
					break;
				}
				for (int i = 0; i < medias.size(); i++) {
					System.out.print(i+1 + " - ");
					medias.get(i).print();
				}
				mediaInteractive(medias);
				break;
			}
			case "2": {
				System.out.println("Enter exact title: ");
				String title = scanner.nextLine();
				boolean hasMedia = false;
				for (Media m: store.searchByTitle(title)) {
					if(m.getTitle().equals(title)) {
						cart.addMedia(m);
						hasMedia = true;
					}
				}
				if(!hasMedia) {
					System.out.println("Title not found");
				}
				cart.print();
				break;
			}
			case "3": {
				System.out.println("Enter exact title: ");
				String title = scanner.nextLine();
				for (Media m: store.searchByTitle(title)) {
					if(m instanceof Disc) {
						((Disc) m).play();
					}
				}
				break;
			}
			case "4": {
				cartMenuInteractive();
				break;
			}
			case "0": {
				break storeMenu;
			}
			default:
				System.out.println("Wrong option, please try again.");
			}
		}
	}
	
	private static void mediaInteractive(ArrayList<Media> medias) throws LimitExceededException, PlayerException {
		Scanner scanner = new Scanner(System.in);
		mediaDetail:while(true) {
			mediaDetailsMenu();
			String option = scanner.nextLine();
			switch (option) {
			case "1": {
				System.out.println("Enter exact title: ");
				String title = scanner.nextLine();
				boolean hasMedia = false;
				for (Media m: medias) {
					if(m.getTitle().equals(title)) {
						cart.addMedia(m);
						hasMedia = true;
					}
				}
				if(!hasMedia) {
					System.out.println("Title not found");
				}
				break;
			}
			case "2": {
				for (Media m: medias) {
					if(m instanceof Disc) {
						((Disc) m).play();
					}
				}
				break;
			}
			case "0": {
				break mediaDetail;
			}
			default:
				System.out.println("Wrong option, please try again.");
			}
		}
	}
	
	public static void updateMenu() {
		System.out.println("Options:");
		System.out.println("---------------------------"); 
		System.out.println("1. Add media from store."); 
		System.out.println("2. Remove media from store.");
		System.out.println("0. Back"); 
		System.out.println("---------------------------"); 
	}
	
	private static void updateStoreInteractive() {
		Scanner scanner = new Scanner(System.in);
		updateMenu:while(true) {
			updateMenu();
			String option = scanner.nextLine();
			switch (option) {
			case "1": {
				System.out.println("Enter media type: DVD or CD or book");
				String type = scanner.nextLine();
				boolean isValidType = type.equals("DVD") || type.equals("CD") || type.equals("book");
				if(!isValidType) {
					System.out.println("invalid type");
					break;
				}
				System.out.println("Enter media title:");
				String title = scanner.nextLine();
				System.out.println("Enter media category or skip if unknown:");
				String category = scanner.nextLine();
				category = category.isBlank() ? "Unknown" : category;
				System.out.println("Enter media director/author/artitst or skip if unknown or media is book:");
				String director = scanner.nextLine();
				director = director.isBlank() ? "Unknown" : director ;
				System.out.println("Enter media length or skip if unknown or media is book:");
				String slength = scanner.nextLine();
				int length = 0;
				try {
					length = Integer.parseInt(slength);
					if(length < 0) {
						throw new IllegalArgumentException();
					}
				} catch (NumberFormatException e) {
					System.out.println("invalid length");
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("length must be greater than 0");
					break;
				}
				System.out.println("Enter media cost or skip if unknown:");
				String scost = scanner.nextLine();
				float cost = 0;
				try {
					cost = Float.parseFloat(scost);
					if(cost < 0) {
						throw new IllegalArgumentException();
					}
				} catch (NumberFormatException e) {
					System.out.println("invalid cost");
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("cost must be greater than 0");
					break;
				}
				if(type.equals("DVD")) {
					store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
				} else if (type.equals("CD")) {
					store.addMedia(new CompactDisc(title, category, director, length, cost));
				} else {
					store.addMedia(new Book(title, category, cost));
				}
			}
			case "2": {
				System.out.println("Enter media title:");
				String title = scanner.nextLine();
				System.out.println("Enter media length or skip if unknown or media is book:");
				String slength = scanner.nextLine();
				int length = 0;
				try {
					if(slength.length() > 0) {
						length = Integer.parseInt(slength);						
					}
					if(length < 0) {
						throw new IllegalArgumentException();
					}
				} catch (NumberFormatException e) {
					System.out.println("invalid length");
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("length must be greater than 0");
					break;
				}
				ArrayList<Media> toBeDeleted = store.searchByTitle(title);
				if(toBeDeleted.equals(null)) {
					break;
				}
				for (Media m: toBeDeleted) {
					if(m instanceof Book) {
						if(m.getTitle().equals(title)) {
							store.removeMedia(m);
						}
					}
					else {
						if(((Disc) m).getLength() == length && m.getTitle().equals(title)) {
							store.removeMedia(m);
						}
					}
				}
				break;
			}
			case "0": {
				break updateMenu;
			}
			default:
				System.out.println("Wrong option, please try again.");
			}
		}
	}
	
	private static void cartMenuInteractive() throws PlayerException {
		Scanner scanner = new Scanner(System.in);
		cartMenu:while(true) {
			cartMenu();
			String option = scanner.nextLine();
			switch (option) {
			case "1": {
				ArrayList<Media> medias;
				System.out.println("Do you want to filter by id or by title?");
				String key = scanner.nextLine();
				if(key.equals("id")) {
					String keyword = scanner.nextLine();
					scanner.nextLine();
					ArrayList<Media> media = cart.searchById(keyword);
					if(media.equals(null)) {
						System.out.println("no media found");
					} else {
						for (Media m: media) {							
							m.print();
						}
					}
					break;
				} else if (key.equals("title")) {
					String keyword = scanner.nextLine();
					medias = cart.searchByTitle(keyword);
					System.out.println("No. - Title - Category - Director/Artist/Author - Length - Cost - ID");
					if(medias == null) {
						break;
					}
					for (int i = 0; i < medias.size(); i++) {
						System.out.print(i+1 + " - ");
						medias.get(i).print();
					}
					break;
				} else {
					System.out.println("invalid option.");
					break;
				}
			}
			case "2": {
				List<Media> medias = cart.getItemOrdered();
				System.out.println("Do you want to sort by cost or by title?");
				String key = scanner.nextLine();
				if(key.equals("cost")) {					
					Collections.sort(medias, Media.COMPARE_BY_COST_TITLE);
				} else if (key.equals("title")){
					Collections.sort(medias, Media.COMPARE_BY_COST_TITLE);
				} else {
					System.out.println("invalid option.");
					break;
				}
				for (int i = 0; i < medias.size(); i++) {
					System.out.print(i+1 + " - ");
					medias.get(i).print();
				}
				break;
			}
			case "3": {
				System.out.println("Enter media title:");
				String title = scanner.nextLine();
				System.out.println("Enter media length or skip if unknown or media is book:");
				String slength = scanner.nextLine();
				int length = 0;
				try {
					if(slength.length() > 0) {
						length = Integer.parseInt(slength);						
					}
					if(length < 0) {
						throw new IllegalArgumentException();
					}
				} catch (NumberFormatException e) {
					System.out.println("invalid length");
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("length must be greater than 0");
					break;
				}
				ArrayList<Media> toBeDeleted = cart.searchByTitle(title);
				if(toBeDeleted.equals(null)) {
					break;
				}
				for (Media m: toBeDeleted) {
					if(m instanceof Book) {
						if(m.getTitle().equals(title)) {
							cart.removeMedia(m);
						}
					}
					else {
						if(((Disc) m).getLength() == length && m.getTitle().equals(title)) {
							cart.removeMedia(m);
						}
					}
				}
				break;
			}
			case "4": {
				System.out.println("Enter exact title: ");
				String title = scanner.nextLine();
				for (Media m: cart.searchByTitle(title)) {
					if(m instanceof Disc) {
						((Disc) m).play();
					}
				}
				break;
			}
			case "5": {
				System.out.println("Order is created");
				cart = new Cart();
				break;
			}
			case "0": {
				break cartMenu;
			}
			default:
				System.out.println("Wrong option, please try again.");
			}
		}
	}
}
