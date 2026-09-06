package com.Luv.juckbox.repositories;

import com.Luv.juckbox.entities.Playlist;

import java.util.List;
import java.util.Optional;

public interface IPlaylistRepository {
    Playlist save(Playlist playlist);
    boolean existsById(String name);
    Optional<Playlist> findById(String name);
    List<Playlist> findAll();
    void deleteById(String name);
    long count();
}
