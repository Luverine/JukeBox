package com.Luv.juckbox.entities;

public class Song {
    private final Long id;
    private final String title;
    private final String artist;
    private final String album;
    private final String genre;

    // Constructor
    public Song(Long id, String title, String artist, String album, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
    public String getGenre() { return genre; }

    @Override
    public String toString() { return "Song[id=" + id + "]"; }
}
