package com.example.aimsproject.media;
import com.example.aimsproject.exception.PlayerException;

public class Disc extends Media implements Playable {
	private int length;
	private String director;
	
	//	Getters
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	//	Constructors
	public Disc(String disc_title, String disc_category, String disc_director, int disc_length, float disc_cost) {
		super(disc_title, disc_category, disc_cost);
		director = disc_director;
		length = disc_length;
	}
	public Disc(String disc_title) {
		this(disc_title, "Unknown", "Unknown", 0, 0);
	}
	public Disc(String disc_title, String disc_category, float disc_cost) {
		this(disc_title, disc_category, "Unknown", 0, disc_cost);
	}
	public Disc(String disc_title, String disc_category, String disc_director, float disc_cost) {
		this(disc_title, disc_category, disc_director, 0, disc_cost);
	}
	
	public void play() throws PlayerException, PlayerException {
		if(getLength() > 0) {
			System.out.println("Playing: " + getTitle());			
			System.out.println("Length: " + String.valueOf(getLength()));
		} else {
			throw new PlayerException("ERROR: Disc length is non-positive .");
		}
	}
	@Override
	public boolean equals(Object e) {
		if(e instanceof Disc) {
			Disc m  = (Disc) e;
			return (m.getTitle() == getTitle() && m.getLength() == getLength()) ;
		}
		return false;
	}
}
