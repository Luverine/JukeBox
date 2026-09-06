package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.SongService;

import java.util.List;

public class AddSongCommand implements ICommand {
    private final SongService songService;

    public AddSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String>  tokens) {
        String title = tokens.get(1);
        String artist = tokens.get(2);
        String album = tokens.get(3);
        String genre = tokens.get(4);

        songService.addSong(title, artist, album, genre);
    }
}
