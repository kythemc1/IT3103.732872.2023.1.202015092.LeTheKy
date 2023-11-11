import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Cart dvd1 = new Cart(1, "đá", "Action", "Director 1", 120.5, 15.99);
        Cart dvd2 = new Cart(2, "xc", "Comedy", "Director 2", 105.0, 12.99);
        Cart dvd3 = new Cart(3, "sldk", "drama", "Director 2", 106.0, 12.99);
        Cart dvd4 = new Cart(4, "dee", "anime", "Director 2", 105.0, 12.99);
        Cart dvd5 = new Cart(5, "dvsdd5", "anime", "Director 2", 105.0, 12.99);


        ShoppingCart cartTotal = new ShoppingCart();
        cartTotal.addItem(dvd1);
        cartTotal.addItem(dvd2);
        cartTotal.addItem(dvd3);
        cartTotal.addItem(dvd4);
        cartTotal.addItem(dvd5);


        while (true) {
            System.out.println("AIMS Project Menu:");
            System.out.println("1. View all DVD");
            System.out.println("2. Sort all DVD by name");
            System.out.println("3. Sort all DVD by cost");
            System.out.println("4. remove dvd from card ");
            System.out.println("0. Exit");
            System.out.print("Please select an option: ");

            String a, b, c;
            a = JOptionPane.showInputDialog(null, "choice = ", JOptionPane.INFORMATION_MESSAGE);
            int choice = Integer.parseInt(a);
            switch (choice) {
                case 1:
                    cartTotal.displayCart();
                    break;
                case 2:
                    cartTotal.sortByName();
                    cartTotal.displayCart();
                    break;
                case 3:
                    cartTotal.sortByCost();
                    cartTotal.displayCart();
                    break;
                case 4:
                    c = JOptionPane.showInputDialog(null, "id = ", JOptionPane.INFORMATION_MESSAGE);
                    int id = Integer.parseInt(c);
                    cartTotal.removeItem(id);
                    break;
                case 0:
                    // Exit
                    System.out.println("Exiting AIMS Project. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
