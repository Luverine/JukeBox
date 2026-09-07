package com.Luv.juckbox.commands;

public enum CommandKeyword {
    ADD_SONG("ADD_SONG"),
    PLAY_SONG("PLAY_SONG"),
    ADD_SONG_TO_PLAYLIST("ADD_SONG_TO_PLAYLIST"),
    CREATE_PLAYLIST("CREATE_PLAYLIST"),
    DELETE_SONG_FROM_PLAYLIST("DELETE_SONG_FROM_PLAYLIST"),
    LIST_SONGS("LIST_SONGS"),
    LOAD_PLAYLIST("LOAD_PLAYLIST"),
    DELETE_PLAYLIST("DELETE_PLAYLIST"),
    NEXT_SONG("NEXT_SONG"),
    PREVIOUS_SONG("PREVIOUS_SONG"),
    STOP_SONG("STOP_SONG");

    private final String name;

    CommandKeyword(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
