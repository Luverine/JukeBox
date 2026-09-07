package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.PlaylistService;

import java.util.List;

public class PreviousSongCommand implements ICommand {
    private final PlaylistService playlistService;

    public PreviousSongCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        playlistService.previousSong();
    }
}
