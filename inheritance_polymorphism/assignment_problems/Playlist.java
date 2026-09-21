package inheritance_polymorphism.assignment_problems;

import java.util.Arrays;

public class Playlist {

    private String[] songs;

    // Constructor
    public Playlist(String[] songs) {
        this.songs = Arrays.copyOf(songs, songs.length);
    }

    // Return a safe copy of songs
    public String[] getSongs() {
        return Arrays.copyOf(songs, songs.length);
    }

    // Return number of songs
    public int getSongCount() {
        return songs.length;
    }

    // Main method
    public static void main(String[] args) {

        String[] songs = {"Song1", "Song2", "Song3"};

        Playlist playlist = new Playlist(songs);

        System.out.println("Songs:");

        for (String song : playlist.getSongs()) {
            System.out.println(song);
        }

        System.out.println("Song count: " + playlist.getSongCount());
    }
}