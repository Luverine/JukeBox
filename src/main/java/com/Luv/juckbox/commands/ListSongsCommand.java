package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.SongService;

import java.util.List;

public class ListSongsCommand implements ICommand{
    private final SongService songService;

    public ListSongsCommand(SongService songService){
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        songService.listSongs();
    }
}
