package com.Luv.juckbox.repositories;

import com.Luv.juckbox.entities.Song;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SongRepository implements ISongRepository{
    private final Map<Long, Song> songMap = new HashMap<>();

    @Override
    public Song save(Song song) {
        songMap.put(song.getId(), song);
        return song;
    }

    @Override
    public boolean existsById(Long id) {
        return songMap.containsKey(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public List<Song> findAll() {
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        songMap.remove(id);
    }

    @Override
    public long count() {
        return songMap.size();
    }

}
