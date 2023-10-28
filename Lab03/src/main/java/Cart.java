public class Cart {
    private int id;
    private String title;
    private String category;
    private String director;
    private double length;
    private double cost;

    public Cart(int id, String title, String category, String director, double length, double cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public double getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }
    // Getter và setter cho thuộc tính DVD


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Category: " + category + ", Director: " + director +
                ", Length: " + length + ", Cost: " + cost;
    }
}
