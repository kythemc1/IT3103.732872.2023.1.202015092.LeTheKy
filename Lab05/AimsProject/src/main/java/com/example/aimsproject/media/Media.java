package com.example.aimsproject.media;
import com.example.aimsproject.comparator.MediaComparatorByCostTitle;
import com.example.aimsproject.comparator.MediaComparatorByTitleCost;

import java.util.Comparator;

public abstract class Media {
	private static int nbMedia = 0;
	private final int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
//	public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator.comparing(Media::getTitle).thenComparing(Media::getCost);
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	//	Setters
	public void setTitle(String title) {
		this.title = title;
	}
	
	//	Getters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}
	
	public float getCost() {
		return cost;
	}

	//	Constructors
	public Media(String media_title, String media_category, float media_cost) {
		if(media_title.isBlank()) {
			title = "Unknown";
			System.out.println("Warning: Media created without title.");
		} else {
			title = media_title;
		}
		category = media_category;
		cost = media_cost;
		id = nbMedia++;
	}
	
	// Method Print
	public void print() {
		String res = getTitle() + " - " + getCategory() + " - " + getCost() + " - " + (getId()+1);
		System.out.println(res);
	}
	
	@Override
	public boolean equals(Object e) {
		if(e instanceof Media) {
			Media m  = (Media) e;
			return (m.getTitle() == getTitle()) ;
		}
		return false;
	}
}
