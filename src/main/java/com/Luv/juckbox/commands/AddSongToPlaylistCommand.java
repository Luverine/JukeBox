package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.PlaylistService;
import com.Luv.juckbox.services.SongService;

import java.util.List;

public class AddSongToPlaylistCommand implements ICommand {
    private final PlaylistService playlistService;
    private final SongService songService;

    public AddSongToPlaylistCommand(PlaylistService playlistService, SongService songService) {
        this.playlistService = playlistService;
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Long songId = Long.parseLong(tokens.get(2));
        playlistService.addSongToPlaylist(playlistName, songId);
    }
}
