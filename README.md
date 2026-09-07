# 🎵 JukeBox Music Simulator

A Java-based command-line music playlist and playback simulator built using object-oriented design principles. The application manages songs and playlists through commands read from an input file.

## Features

* ➕ Add new songs
* 📂 Create playlists
* 🎶 Add songs to playlists
* ❌ Remove songs from playlists
* 🗑 Delete playlists
* 📜 List songs in a playlist
* ▶️ Play songs
* ⏭ Play next song
* ⏮ Play previous song
* ⏹ Stop playback
* 📥 Load playlists from commands

## Tech Stack

* Java
* Gradle
* JUnit 5
* Object-Oriented Programming (OOP)

## Project Structure

```
src/
 ├── main/
 │   └── java/
 │       └── com/Luv/juckbox/
 │           ├── commands/
 │           ├── entities/
 │           ├── repositories/
 │           ├── services/
 │           ├── Configuration.java
 │           └── App.java
 └── test/
```

## Available Commands

The application supports commands such as:

* `ADD_SONG`
* `CREATE_PLAYLIST`
* `ADD_SONG_TO_PLAYLIST`
* `DELETE_SONG_FROM_PLAYLIST`
* `DELETE_PLAYLIST`
* `LIST_SONGS`
* `LOAD_PLAYLIST`
* `PLAY_SONG`
* `NEXT_SONG`
* `PREVIOUS_SONG`
* `STOP_SONG`

Commands are executed from an input text file.

## Running the Project

### Clone the repository

```bash
git clone https://github.com/<your-username>/JukeBox.git
cd JukeBox
```

### Build

```bash
./gradlew clean build
```

### Run

```bash
./gradlew run --args="INPUT_FILE=sample_input/sample_input_one.txt"
```

Or use the provided script:

```bash
bash run.sh
```

## Testing

Run the unit tests using:

```bash
./gradlew test
```

## Design

The project follows a layered architecture:

* **Commands** – Handles user commands.
* **Services** – Business logic.
* **Repositories** – Data storage.
* **Entities** – Domain models (`Song`, `Playlist`).
* **Configuration** – Dependency initialization.

This separation keeps the code modular, maintainable, and easy to extend.

## Future Improvements

* Persistent database storage
* Shuffle and repeat modes
* Search songs by title or artist
* Playlist sharing
* Better exception handling
* Interactive CLI mode
* Album and artist support

## Learning Outcomes

This project demonstrates:

* Object-Oriented Programming
* Command Pattern
* Repository Pattern
* Service Layer Architecture
* Gradle Project Structure
* Unit Testing with JUnit

## License

This project is intended for learning and portfolio purposes.
