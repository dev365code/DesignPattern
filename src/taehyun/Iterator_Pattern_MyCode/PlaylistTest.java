package Iterator_Pattern;

import java.util.Iterator;

public class PlaylistTest {
    public static void main(String[] args) {
        Playlist playlist = new Playlist(3);
        playlist.addSong(new Song("Imagine - John Lennon"));
        playlist.addSong(new Song("Let It Be - The Beatles"));
        playlist.addSong(new Song("Bohemian Rhapsody - Queen"));

        System.out.println("🎵 순서대로 노래 목록 출력:");
        for (Song song : playlist) {
            System.out.println(song.getTitle());
        }
    }
}

class Song {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Playlist implements Iterable<Song> {
    private Song[] songs;
    private int size = 0;

    public Playlist(int capacity) {
        songs = new Song[capacity];
    }

    public void addSong(Song song) {
        songs[size++] = song;
    }

    public Song getSongAt(int index) {
        return songs[index];
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Song> iterator() {
        return new SongIterator(this);
    }
}

class SongIterator implements Iterator<Song> {
    private Playlist playlist;
    private int index = 0;

    public SongIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSize();
    }

    @Override
    public Song next() {
        return playlist.getSongAt(index++);
    }
}
