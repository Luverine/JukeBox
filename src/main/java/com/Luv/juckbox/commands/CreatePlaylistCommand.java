package com.Luv.juckbox.commands;

import com.Luv.juckbox.services.PlaylistService;

import java.util.List;
import java.util.stream.Collectors;

public class CreatePlaylistCommand implements ICommand{
    private final PlaylistService playlistService;

    public CreatePlaylistCommand(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        if(tokens.size() < 2) throw new RuntimeException("❌ INVALID COMMAND");

        String playlistName = tokens.get(1);
        List<Long> songIds = tokens.subList(2, tokens.size())
                .stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        playlistService.createPlaylist(playlistName, songIds);
    }
}
