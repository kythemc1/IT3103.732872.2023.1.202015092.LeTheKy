package Main.model;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        // Initialize Book-specific fields if needed
        this.authors = new ArrayList<>();
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    // Method to remove an author
    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }
}