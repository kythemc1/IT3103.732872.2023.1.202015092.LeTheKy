package Main;

import Main.Cart.ShoppingCart;
import Main.model.DVD;
import Main.model.Media;
import Main.model.Playable;
import Main.store.Store;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Media dvd1 = new DVD(1, "đá1", "Action", "Director 1", 120.5, 16,1);
        Media dvd2 = new DVD(2, "đá2", "Action", "Director 1", 120.5, 17,1);
        Media dvd4 = new DVD(4, "đá3", "Action", "Director 1", 120.5, 18,1);
        Media dvd5 = new DVD(5, "đá4", "Action", "Director 1", 120.5, 35,1);
        Media dvd6 = new DVD(6, "đá5", "Action", "Director 1", 120.5, 5,1);

        store.addItem(dvd1);
        store.addItem(dvd2);
        store.addItem(dvd4);
        store.addItem(dvd5);
        store.addItem(dvd6);



        ShoppingCart cart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void seeCurrentCart(ShoppingCart cart, Scanner scanner) {
        cart.displayCart();
    }

    private static void updateStore(Store store, Scanner scanner) {
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore(Store store, ShoppingCart cart, Scanner scanner) {
        // Display items in the store
        store.displayCart();

        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    seeMediaDetails(store,cart ,scanner);
                    break;
                case 2:
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3:
                    playMedia(store, scanner);
                    break;
                case 4:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails(Store store,ShoppingCart cart, Scanner scanner) {

        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.findByTitle(title);

        if (media != null) {
            media.displayInfo();
            int mediaDetailsChoice;
            do {
                mediaDetailsMenu();
                mediaDetailsChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (mediaDetailsChoice) {
                    case 1:
                        addMediaToCart(store,cart,scanner);
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("Cannot play this type of media.");
                        }
                        break;
                    case 0:
                        System.out.println("Returning to store menu.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            } while (mediaDetailsChoice != 0);
        } else {
            System.out.println("Media not found with title: " + title);
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart(Store store, ShoppingCart cart, Scanner scanner) {
        System.out.println("Enter the title of the media to add to cart:");
        String title = scanner.nextLine();
        Media media = store.findByTitle(title);

        if (media != null) {
            cart.addItem(media);
            System.out.println(media.getTitle() + " added to cart.");
        } else {
            System.out.println("Media not found with title: " + title);
        }
    }

    public static void playMedia(Store store, Scanner scanner) {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = store.findByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot play this type of media.");
        }
    }
}

