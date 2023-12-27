package com.example.aimsproject.media;

import com.example.aimsproject.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	// 	Constructors
	public DigitalVideoDisc(String dvd_title, String dvd_category, String dvd_director, int dvd_length, float dvd_cost) {
		super(dvd_title, dvd_category, dvd_director, dvd_length, dvd_cost);
	}
	public DigitalVideoDisc(String dvd_title) {
		this(dvd_title, "Unknown", "Unknown", 0, 0);
	}
	
	public DigitalVideoDisc(String dvd_title, String dvd_category, float dvd_cost) {
		this(dvd_title, dvd_category, "Unknown", 0, dvd_cost);
	}
	public DigitalVideoDisc(String dvd_title, String dvd_category, String dvd_director, float dvd_cost) {
		this(dvd_title, dvd_category, dvd_director, 0, dvd_cost);
	}
	
	// 	Method: Print
	public void print() {
		String res = getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " - " + getCost() + " - " + (getId()+1);
		System.out.println(res);
	}
	
	// Method Play
	public void play() throws PlayerException {
		if(getLength() > 0) {
			System.out.println("Playing DVD: " + getTitle());
			System.out.println("DVD length: " + String.valueOf(getLength()));
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive .");
		}
	}
	
}
