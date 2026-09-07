package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.PlaylistService;

import java.util.List;

public class DeleteSongFromPlaylistCommand implements ICommand{
    private final PlaylistService playlistService;

    public DeleteSongFromPlaylistCommand(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Long songId = Long.parseLong(tokens.get(2));
        playlistService.deleteSongFromPlaylist(playlistName, songId);
    }
}
