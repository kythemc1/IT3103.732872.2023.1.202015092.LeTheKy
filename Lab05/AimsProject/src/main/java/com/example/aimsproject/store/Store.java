package com.example.aimsproject.store;

import com.example.aimsproject.media.Media;

import java.util.ArrayList;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	//	Method Get items in store
	public Media[] getItemsInStore() {
		
		Media[] res = new Media[itemsInStore.size()];
		if(itemsInStore.size() == 0) {
			return null;
		}
		res = itemsInStore.toArray(res);
		return res;
	}

	// Add media
	public void addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println("The media has been successfully added.");
	}
	
	public void addMedia(Media ...medias) {
		for (Media m: medias) {
			addMedia(m);
		}
	}
	
	//	Remove media
	public void removeMedia(Media media) {
		if (itemsInStore.size() == 0) {
			System.out.println("Cannot remove media, the store is empty.");
			return;
		}
		
		if (itemsInStore.remove(media)) {
			System.out.println("The media has been successfully removed.");
		} else {
			System.out.println("Something wrong happened. Please try again.");
		}
	}
	
	public Media searchById(int id) {
		for (Media m: itemsInStore) {
			if(m.getId() == id) {
				return m;
			}
		}
		System.out.println("No media matches the search ID.");
		return null;
	}
	
	public ArrayList<Media> searchByTitle(String... titles) {
		ArrayList<Media> res = new ArrayList<Media>();
		for (Media d: itemsInStore) {
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

	private boolean isMatch(String title, String[] searchTitles) {
		for (String t: searchTitles) {
			if(title.contains(t)) {
				return true;
			}
		}
		return false;
	}
}








