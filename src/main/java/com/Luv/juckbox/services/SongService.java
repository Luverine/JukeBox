package com.Luv.juckbox.services;

import com.Luv.juckbox.entities.Song;
import com.Luv.juckbox.repositories.ISongRepository;

import java.util.List;

public class SongService {
    private final ISongRepository songRepository;
    private Long songIdcounter;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
        this.songIdcounter = 1L;
    }

    // Add a song and save it in songRepository
    public Song addSong(String title, String artist, String album, String genre) {
        Song song = new Song(songIdcounter++, title, artist, album, genre);
        songRepository.save(song); // Store in repository
        System.out.println("Song [id= " + song.getId() + "]");
        return song;
    }

    // List all songs from repository
    public void listSongs() {
        List<Song> songs = songRepository.findAll();
        System.out.println(songs);
    }

    // Get a song by ID from repository
    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    // Remove a song from repository (if needed)
    public void removeSong(Long id) {
        songRepository.deleteById(id);
    }
}
