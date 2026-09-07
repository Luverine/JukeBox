package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.PlaylistService;

import java.util.List;

public class LoadPlaylistCommand implements ICommand {
    private final PlaylistService playlistService;

    public LoadPlaylistCommand(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        playlistService.loadPlaylist(playlistName);
    }
}
