package Main.model;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String director, double length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter method for artist
    public String getArtist() {
        return artist;
    }

    // Method to add a track
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists in the CD.");
        }
    }

    // Method to remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track does not exist in the CD.");
        }
    }

    // Method to get the total length of the CD
    public double getLength() {
        double totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("CD length: " + this.getLength());

        // Loop through each track and play
        for (Track track : tracks) {
            track.play();
        }
    }
}
