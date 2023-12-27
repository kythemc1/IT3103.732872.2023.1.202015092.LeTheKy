package com.example.aimsproject.media;

import java.util.ArrayList;

public class Book extends Media{
	private ArrayList<String> authors = new ArrayList<String>();
	
	// 	Constructors
	public Book(String book_title, String book_category, float book_cost) {
		super(book_title, book_category, book_cost);
	}
	public Book(String book_title) {
		this(book_title, "Unknown", 0);
	}
	
	// 	Add author
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Author already exists.");
			return;
		}
		authors.add(authorName);
		System.out.println("Author added successfully.");
	}
	
	//	Remove author
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			boolean isRemoved = authors.remove(authorName);
			if(isRemoved) {
				System.out.println("Author removed successfully.");				
			} else {
				System.out.println("Something wrong happened...");	
			}
		} else {
			System.out.println("Author does not exist.");
		}
	}
	
	@Override 	// 	Method Print
	public void print() {
		String res = getTitle() + " - " + getCategory() + " - " + authorsToString() + " - " + getCost() + " - " + (getId()+1);
		System.out.println(res);
	}
	
	private String authorsToString() {
		return "";
	}
	
}
