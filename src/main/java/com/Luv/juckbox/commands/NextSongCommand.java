package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.PlaylistService;

import java.util.List;

public class NextSongCommand implements ICommand {
    private final PlaylistService playlistService;

    public NextSongCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        playlistService.nextSong();
    }
}
