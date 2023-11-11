import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ShoppingCart {
    private List<Cart> items = new ArrayList<>();

    public void addItem(Cart dvd) {
        items.add(dvd);
    }

    public void removeItem(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public void displayCart() {
        for (Cart item : items) {
            System.out.println(item);
        }
    }

    public void sortByName() {
        items.sort(Comparator.comparing(Cart::getTitle).thenComparing(Cart::getCost));
    }

    public void sortByCost() {
        items.sort(Comparator.comparing(Cart::getCost).reversed().thenComparing(Cart::getTitle));
    }

    public void addDigitalVideoDisc(Cart []listCart){
        items.addAll(List.of(listCart));
    }
}