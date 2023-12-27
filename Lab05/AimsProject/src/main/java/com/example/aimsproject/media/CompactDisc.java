package com.example.aimsproject.media;
import com.example.aimsproject.exception.PlayerException;

import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}

	// 	Constructors
	public CompactDisc(String cd_title, String cd_category, String cd_director, int cd_length, float cd_cost) {
		super(cd_title, cd_category, cd_director, cd_length, cd_cost);
	}
	public CompactDisc(String cd_title) {
		super(cd_title, "Unknown", "Unknown", 0, 0);
	}
	public CompactDisc(String cd_title, String cd_category, float cd_cost) {
		this(cd_title, cd_category, "Unknown", 0, cd_cost);
	}
	public CompactDisc(String cd_title, String cd_category, String cd_director, float cd_cost) {
		this(cd_title, cd_category, cd_director, 0, cd_cost);
	}
	
	
	
	// 	Method: Print
	public void print() {
		String res = getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " - " + getCost() + " - " + (getId()+1);
		System.out.println(res);
	}
	
	//	Add track
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("This track is already in the CD.");
			return;
		}
		tracks.add(track);
		System.out.println("Track added successfully.");
	}
	
	public void addTrack(Track ...tracks) {
		for (Track t: tracks) {
			addTrack(t);
		}
	}
	
	//	Remove author
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			boolean isRemoved = tracks.remove(track);
			if(isRemoved) {
				System.out.println("Track removed successfully.");				
			} else {
				System.out.println("Something wrong happened...");	
			}
		} else {
			System.out.println("This track is not in the CD.");
		}
	}
	
	// Method get length of the CD, override the initialized length
	@Override
	public int getLength() {
		int totalLength = 0;
		for (Track t: tracks) {
			totalLength += t.getLength();
		}
		return totalLength;
	}
	
	// 	Method Play
	public void play() throws PlayerException {
		System.out.println("\nPlaying CD: " +getTitle());
		if(getLength() > 0) {
			for (int i = 0; i < tracks.size(); i++) {
				Track t = tracks.get(i);
				System.out.println("Track no." + String.valueOf(i+1) + "...");
				t.play();
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive .");
		}
	}
}
