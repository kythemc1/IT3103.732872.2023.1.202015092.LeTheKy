package Main.model;

public class Disc extends Media {
    private String director;
    private double length;

    // Constructor
    public Disc(int id, String title, String category, float cost, String director, double length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getter methods for director and length
    public String getDirector() {
        return director;
    }

    public double getLength() {
        return length;
    }
}

