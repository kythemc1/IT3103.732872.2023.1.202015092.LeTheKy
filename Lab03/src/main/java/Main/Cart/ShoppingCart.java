package Main.Cart;

import Main.model.DVD;
import Main.model.Media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingCart {
    private List<Media> items = new ArrayList<>();

    public void addItem(Media media) {
        items.add(media);
        System.out.println("Added " + media.getTitle() + " to the cart.");
    }

    public void removeItem(int id) {
        items.removeIf(item -> item.getId() == id);
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

    public void sortByName() {
        items.sort(Comparator.comparing(Media::getTitle).thenComparing(Media::getCost));
    }

    public void sortByCost() {
        items.sort(Comparator.comparing(Media::getCost).reversed().thenComparing(Media::getTitle));
    }

    public float totalCost() {
        float total = 0;
        for (Media media : items) {
            total += media.getCost();
        }
        return total;
    }
    public void addDigitalVideoDisc(DVD []listCart){
        items.addAll(List.of(listCart));
    }
}