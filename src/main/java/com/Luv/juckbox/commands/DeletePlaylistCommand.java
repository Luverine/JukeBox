package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.PlaylistService;

import java.util.List;

public class DeletePlaylistCommand implements ICommand{
    private final PlaylistService playlistService;

    public DeletePlaylistCommand(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        if(tokens.size() < 2){
            System.out.println("❌ INVALID COMMAND");
            return;
        }
        String playlistName = tokens.get(1);
        playlistService.deletePlaylist(playlistName);
    }
}
