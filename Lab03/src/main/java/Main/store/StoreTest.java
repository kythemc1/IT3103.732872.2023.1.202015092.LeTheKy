package Main.store;

import Main.model.DVD;

public class StoreTest {
    public static void main(String []args){
        DVD dvd1 = new DVD(1, "đá", "Action", "Director 1", 120.5, 15.99,1);
        DVD dvd2 = new DVD(2, "xc", "Comedy", "Director 2", 105.0, 12.99,2);
        DVD dvd3 = new DVD(3, "sldk", "drama", "Director 2", 106.0, 12.99,3);
        DVD dvd4 = new DVD(4, "dee", "anime", "Director 2", 105.0, 12.99,4);
        DVD dvd5 = new DVD(5, "dvsdd5", "anime", "Director 2", 105.0, 12.99,5);

        Store cartTotal = new Store();
        cartTotal.addItem(dvd1);
        cartTotal.addItem(dvd2);
        cartTotal.addItem(dvd3);
        cartTotal.addItem(dvd4);
        cartTotal.addItem(dvd5);

        cartTotal.displayCart();
    }

}
