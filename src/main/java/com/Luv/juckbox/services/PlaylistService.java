package com.Luv.juckbox.services;

import com.Luv.juckbox.entities.Playlist;
import com.Luv.juckbox.entities.Song;
import com.Luv.juckbox.repositories.IPlaylistRepository;
import com.Luv.juckbox.repositories.ISongRepository;

import java.util.List;
import java.util.Optional;

public class PlaylistService {
    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;
    private Playlist activePlaylist;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private int currentSongIndex = -1;
    private Song currentSong;
    private Long nextPlaylistId = 1L;

    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public void createPlaylist(String playlistName, List<Long> songIds) {
        if (!playlistRepository.existsById(playlistName)) {
            Playlist playlist = new Playlist(nextPlaylistId++, playlistName);

            // Fetch and add songs
            for (Long songId : songIds) {
                songRepository.findById(songId).ifPresent(playlist::addSong);
            }

            playlistRepository.save(playlist);
            System.out.println("Playlist [id=" + playlist.getId() + "]");
        }
    }

    public void loadPlaylist(String playlistName) {
        Optional<Playlist> playlistOpt = playlistRepository.findById(playlistName);
        if (playlistOpt.isPresent()) {
            activePlaylist = playlistOpt.get();
            currentSongIndex = -1;
            System.out.println("Playlist " + playlistName + " is loaded!");
        } else System.out.println("INVALID COMMAND");
    }

    public void playSong() {
        if (activePlaylist == null || activePlaylist.getSongs().isEmpty()) {
            System.out.println("No playlist loaded or playlist is empty.");
            return;
        }

        if (isPlaying) {
            // If already playing, toggle pause
            if (isPaused) {
                System.out.println("Song [id=" + currentSong.getId() + "] is resumed!");
                isPaused = false;
            } else {
                System.out.println("Song [id=" + currentSong.getId() + "] is paused!");
                isPaused = true;
            }
            return;
        }

        // If not playing, start the first song
        currentSongIndex = (currentSongIndex == -1) ? 0 : currentSongIndex;
        currentSong = activePlaylist.getSongs().get(currentSongIndex);
        System.out.println("Song [id=" + currentSong.getId() + "] is playing!");
        isPlaying = true;
        isPaused = false;
    }

    public void nextSong() {
        if (activePlaylist == null || !isPlaying || activePlaylist.getSongs().isEmpty()) {
            System.out.println("No playlist loaded or not playing.");
            return;
        }

        currentSongIndex = (currentSongIndex + 1) % activePlaylist.getSongs().size();
        currentSong = activePlaylist.getSongs().get(currentSongIndex);
        System.out.println("Song [id=" + currentSong.getId() + "] is playing!");
    }

    public void previousSong() {
        if (activePlaylist == null || !isPlaying || activePlaylist.getSongs().isEmpty()) {
            System.out.println("No playlist loaded or not playing.");
            return;
        }

        currentSongIndex = (currentSongIndex - 1 + activePlaylist.getSongs().size()) % activePlaylist.getSongs().size();
        currentSong = activePlaylist.getSongs().get(currentSongIndex);
        System.out.println("Song [id=" + currentSong.getId() + "] is playing!");
    }

    public void stopSong() {
        if (currentSong == null || !isPlaying) {
            System.out.println("No song is currently playing.");
            return;
        }

        System.out.println("Song [id=" + currentSong.getId() + "] is stopped!");
        isPlaying = false;
        isPaused = false;
        currentSong = null;
    }

    public void deletePlaylist(String playlistName) {
        if (playlistRepository.existsById(playlistName)) {
            playlistRepository.deleteById(playlistName);
            System.out.println("Playlist " + playlistName + " is deleted!");
        } else System.out.println("INVALID COMMAND");
    }

    public void addSongToPlaylist(String playlistName, Long songId) {
        Optional<Playlist> playlistOpt = playlistRepository.findById(playlistName);
        Optional<Song> songOpt = songRepository.findById(songId);

        if (playlistOpt.isPresent() && songOpt.isPresent()) {
            Playlist playlist = playlistOpt.get();
            playlist.addSong(songOpt.get());
            playlistRepository.save(playlist);

            System.out.println("Playlist " + playlistName + " is revised with " + playlist.getSongs());
        } else System.out.println("INVALID COMMAND");
    }

    public void deleteSongFromPlaylist(String playlistName, Long songId) {
        Optional<Playlist> playlistOpt = playlistRepository.findById(playlistName);
        Optional<Song> songOpt = songRepository.findById(songId);

        if (playlistOpt.isPresent() && songOpt.isPresent()) {
            Playlist playlist = playlistOpt.get();
            playlist.removeSong(songOpt.get());
            playlistRepository.save(playlist);

            System.out.println("Playlist " + playlistName + " is revised with " + playlist.getSongs());
        } else System.out.println("INVALID COMMAND");
    }
}
