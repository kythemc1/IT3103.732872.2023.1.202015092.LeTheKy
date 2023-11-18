package Main.model;

public class DVD extends Media implements Playable{
    private String director;
    private double length;

    private static final int nbDigitalVideoDiscs = 0;


    public DVD(int id, String title, String category, String director, double length, float cost,int nbDigitalVideoDiscs) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public DVD( String title) {
        super(title);
    }
    public String getDirector() {
        return director;
    }

    public double getLength() {
        return length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", director='" + director + '\'' +
                ", length=" + length +
                ", cost=" + getCost() +
                '}';
    }


    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}

