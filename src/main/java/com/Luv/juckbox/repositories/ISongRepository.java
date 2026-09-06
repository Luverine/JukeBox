package com.Luv.juckbox.repositories;

import com.Luv.juckbox.entities.Song;

import java.util.List;
import java.util.Optional;

public interface ISongRepository {
    Song save(Song song);
    boolean existsById(Long id);
    Optional<Song> findById(Long id);
    List<Song> findAll();
    void deleteById(Long id);
    long count();
}
