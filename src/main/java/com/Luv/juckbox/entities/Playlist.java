package com.Luv.juckbox.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Playlist {
    private final Long id;
    private final String name;
    private final List<Song> songs;
    private int currentSongIndex = -1;
    private boolean isPlaying = false;
    private boolean isPaused = false;

    // Constructor

    public Playlist(Long id, String name) {
        this.id = id;
        this.name = name;
        this.songs = new LinkedList<>();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void addSong(Song song) { songs.add(song); }
    public void removeSong(Song song) { songs.remove(song); }
    public boolean hasSong(Song song) { return !songs.isEmpty(); }
    public List<Song> getSongs() { return new ArrayList<>(songs); }

    public Song play() {
        if (songs.isEmpty()) {
            System.out.println("No songs in playlist!");
            return null;
        }

        if (isPaused) {
            isPaused = false;
            System.out.println("Song [id= " + songs.get(currentSongIndex).getId() + "] is playing!");
            return songs.get(currentSongIndex);
        }

        if (!isPlaying) {
            currentSongIndex = (currentSongIndex == -1) ? 0 : currentSongIndex;
            isPlaying = true;
            System.out.println("Song [id= " + songs.get(currentSongIndex).getId() + "] is playing!");
            return songs.get(currentSongIndex);
        }

        // if already playing, pause it
        isPaused =  true;
        System.out.println("Song [id= " + songs.get(currentSongIndex).getId() + "] is paused!");
        return null;

    }

    public Song nextSong() {
        if (songs.isEmpty()) {
            System.out.println("No songs in playlist!");
            return null;
        }

        currentSongIndex = (currentSongIndex + 1) % songs.size();
        isPlaying = true;
        isPaused = false;
        System.out.println("Song [id= " + songs.get(currentSongIndex).getId() + "] is playing!");
        return songs.get(currentSongIndex);
    }

    public Song previousSong() {
        if (songs.isEmpty()) {
            System.out.println("No songs in playlist!");
            return null;
        }

        currentSongIndex = (currentSongIndex - 1 + songs.size()) % songs.size();
        isPlaying = true;
        isPaused = false;
        System.out.println("Song [id= " + songs.get(currentSongIndex).getId() + "] is playing!");
        return songs.get(currentSongIndex);
    }

    public void stop() {
        if(!isPlaying) {
            System.out.println("No song is playing currently!");
            return;
        }

        System.out.println("Song [id= " + songs.get(currentSongIndex).getId() + "] is stopped!");
        isPlaying = false;
        isPaused = false;
        currentSongIndex = -1; // Reset playback
    }

    @Override
    public String toString() {
        return "Playlist [ " + name + " ]";
    }

    public String getSongList() {
        List<String> songIds = new ArrayList<>();
        for (Song song : songs) {
            songIds.add("Song [id= " + song.getId() + "]");
        }
        return songIds.toString();
    }
}
