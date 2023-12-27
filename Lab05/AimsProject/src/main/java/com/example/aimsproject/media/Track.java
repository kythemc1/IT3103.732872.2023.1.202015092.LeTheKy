package com.example.aimsproject.media;

import com.example.aimsproject.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	//Getters
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	// Constructors
	public Track(String track_title, int track_length) {
		title = track_title;
		length = track_length;
	}
	public Track(String track_title) {
		this(track_title, 0);
	}
	
	//	Method Play
	public void play() throws PlayerException {
		if(getLength() > 0) {
			System.out.println("Playing Track: " + getTitle());
			System.out.println("Track length: " + String.valueOf(getLength()));
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive .");
		}
	}
	@Override
	public boolean equals(Object e) {
		if(e instanceof Track) {
			Track t  = (Track) e;
			return (t.getTitle() == getTitle()) &&(t.getLength() == getLength());
		}
		return false;
	}
}


