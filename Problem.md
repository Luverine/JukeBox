## Assumptions

1. On choosing a playlist, the first song in the playlist will start playing.
2. On reaching the end, Next command will switch to the first song in the current playlist.
3. On reaching the start, Back command will switch to the last song in the current playlist.
4. You can assume that songId and playlistId are always valid.
5. Song will contain the artist, album and genre.
6. In the Add_Song and Create_playlist command, You have to create an ID by yourself.

## Features

1. A user can create a playlist from an available pool of songs.
2. A user can add songs to the playlist.
3. User can play the playlist and be able to switch songs (forward or backward)
4. List all the songs in the pool.

## Bonus Features

1. Users can search songs by name (Only prefix name matches should return).
2. Get the list of top 10 most played songs in a non-increasing order.

## Commands

- `ADD_SONG <song-name>,<artist/band-name>,<album-name>,<genre>`
    - Input : ADD_SONG **Something In the Way, Nirvana, NeverMind, Rock**
    - Output: Song [id=1]
- `CREATE_PLAYLIST <playlist-name> <song-ids>`
    - Input : CREATE_PLAYLIST  PLAYLIST_2  1 2 3
    - Output : Playlist [id=1]
- `ADD_SONG_TO_PLAYLIST <playlist-name> <song-id>`
    - Input : ADD_SONG_TO_PLAYLIST  PLAYLIST_2  8
    - Output : Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=9], Song [id=8]]
- `DELETE_SONG_FROM_PLAYLIST <playlist-name> <song-id>`
    - Input : DELETE_SONG_FROM_PLAYLIST PLAYLIST_2 9
    - Output : Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=8]]
- `DELETE_PLAYLIST <playlist-name>`
    - Input : DELETE_PLAYLIST PLAYLIST_1
    - Output : Playlist PLAYLIST_1 is deleted!
- `LOAD_PLAYLIST <playlist-name>`
    - Input : LOAD_PLAYLIST PLAYLIST_2
    - Output : Playlist PLAYLIST_2 is loaded!
- `PLAY_SONG`
    - Input : PLAY_SONG
    - Output : Song [id=2] is playing!
- `NEXT_SONG`
    - Input : NEXT_SONG
    - Output : Song [id=4] is playing!
- `PREVIOUS_SONG`
    - Input : PREVIOUS_SONG
    - Output : Song [id=2] is playing!
- `STOP_SONG`
    - Input : STOP_SONG
    - Output : Song [id=2] is stopped!
- `LIST_SONGS`
    - Output : List of all songs with name

      [Song [id=1], Song [id=2], Song [id=3], Song [id=4], Song [id=5], Song [id=6], Song [id=7], Song [id=8], Song [id=9], Song [id=10]]


## Expectations

- Code should be Demo-able and functionally complete.
- Code should fail gracefully with a proper error message for corner/invalid cases, use exceptions for handling these cases.
- Code should be modular, try thinking in terms of Object-Oriented Design.
- Input can be taken from the command line or in the main function.
- Do not use any database or NoSQL store, use in-memory data structure.
- Do not create any UI for the application
- Driver class can be designed as per your choice, but it should cover all the scenarios.
- Please prioritize code compilation, execution, and completion.
- Work on the expected output first and then only work on bonus features.

## Input

```bash
ADD_SONG Song_1 Artist_1 Album_1 Genre_1

ADD_SONG Song_2 Artist_2 Album_2 Genre_2

ADD_SONG Song_3 Artist_3 Album_3 Genre_3

ADD_SONG Song_4 Artist_4 Album_4 Genre_1

ADD_SONG Song_5 Artist_5 Album_5 Genre_2

ADD_SONG Song_6 Artist_6 Album_6 Genre_3

ADD_SONG Song_7 Artist_7 Album_7 Genre_1

ADD_SONG Song_8 Artist_8 Album_8 Genre_2

ADD_SONG Song_9 Artist_9 Album_9 Genre_3

ADD_SONG Song_10 Artist_10 Album_10 Genre_1

LIST_SONGS

CREATE_PLAYLIST PLAYLIST_1 2 4 6 8

CREATE_PLAYLIST PLAYLIST_2 1 3 5 7 9

LOAD_PLAYLIST PLAYLIST_1

PLAY_SONG

NEXT_SONG

NEXT_SONG

NEXT_SONG

PREVIOUS_SONG

PREVIOUS_SONG

PREVIOUS_SONG

PLAY_SONG

STOP_SONG

DELETE_PLAYLIST PLAYLIST_1

ADD_SONG_TO_PLAYLIST PLAYLIST_2 8

DELETE_SONG_FROM_PLAYLIST PLAYLIST_2 9

LOAD_PLAYLIST PLAYLIST_2

PLAY_SONG

NEXT_SONG

NEXT_SONG

PREVIOUS_SONG
```

## Output

```bash
Song [id=1]

Song [id=2]

Song [id=3]

Song [id=4]

Song [id=5]

Song [id=6]

Song [id=7]

Song [id=8]

Song [id=9]

Song [id=10]

[Song [id=1], Song [id=2], Song [id=3], Song [id=4], Song [id=5], Song [id=6], Song [id=7], Song [id=8], Song [id=9], Song [id=10]]

Playlist [id=1]

Playlist [id=2]

Playlist PLAYLIST_1 is loaded!

Song [id=2] is playing!

Song [id=4] is playing!

Song [id=6] is playing!

Song [id=8] is playing!

Song [id=6] is playing!

Song [id=4] is playing!

Song [id=2] is playing!

Song [id=2] is paused!

Song [id=2] is stopped!

Playlist PLAYLIST_1 is deleted!

Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=9], Song [id=8]]

Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=8]]

Playlist PLAYLIST_2 is loaded!

Song [id=1] is playing!

Song [id=3] is playing!

Song [id=5] is playing!

Song [id=3] is playing!
```