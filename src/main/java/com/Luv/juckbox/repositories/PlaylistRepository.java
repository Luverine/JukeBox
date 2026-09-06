package com.Luv.juckbox.repositories;

import com.Luv.juckbox.entities.Playlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlaylistRepository implements IPlaylistRepository{
    private final Map<String, Playlist> playlistMap = new HashMap<>();
    @Override
    public Playlist save(Playlist playlist) {
        playlistMap.put(playlist.getName(), playlist);
        return playlist;
    }

    @Override
    public boolean existsById(String name) {
        return playlistMap.containsKey(name);
    }

    @Override
    public Optional<Playlist> findById(String name) {
        return Optional.ofNullable(playlistMap.get(name));
    }

    @Override
    public List<Playlist> findAll() {
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(String name) {
        playlistMap.remove(name);
    }
    
    @Override
    public long count() {
        return playlistMap.size();
    }
}
