package Main.store;

import Main.model.DVD;
import Main.model.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> items = new ArrayList<>();

    public void addItem(Media media) {
        items.add(media);
    }

    public void removeItem(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public void addDigitalVideoDisc(Media[]listCart){
        items.addAll(List.of(listCart));
    }
    public void displayCart() {
        double totalCost=0;
        System.out.println("\n"+"******************************************FB88******************************************"+"\n");
        for (Media item : items) {
            System.out.println(item.toString());
            totalCost=totalCost+item.getCost();
        }
        System.out.println("Total cost: "+ totalCost);
        System.out.println("\n"+"******************************************FB88******************************************"+"\n");
    }
    public Media findByTitle(String title) {
        for (Media media : items) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; // If not found
    }
}