import java.util.Arrays;
public class Playlist {
	private static final int MIN_CAPACITY = 3;
	private Song[] songs;
	private int numSongs;
	
	//Default constructor
	public Playlist() {
		this(MIN_CAPACITY);
	}
	
	//Constructor with capacity
	public Playlist(int capacity) {
		if (capacity < MIN_CAPACITY) {
			capacity = MIN_CAPACITY;
		}
		songs = new Song[capacity];
		numSongs = 0;
	}
	
	//Getters
	public int getCapacity() {
		return songs.length;
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
		if (index >= 0 && index < numSongs) {
			return songs[index];
		}
		return null;
	}
	
	public Song[] getSongs() {
		return Arrays.copyOf(songs, numSongs);
	}
	
	//Add song to first empty position
	public boolean addSong(Song song) {
		if (numSongs < songs.length && song != null) {
			songs[numSongs++] = song;
			return true;
		}
		return false;
	}
	
	//Add a song at a specific index
	public boolean addSong(int index, Song song) {
		if (index >= 0 && index <= numSongs && numSongs < songs.length && song != null) {
			//Shift elements to thr right
			for (int i = numSongs; i > index; i--) {
				songs[i] = songs[i-1];
			}
			songs[index] = song;
			numSongs++;
			return true;
		}
		return false;
	}
	
	//Add all songs from another playlist
	public int addSongs(Playlist playlist) {
		if (playlist == null) {
			return 0;
		}
		int count = 0;
		for(Song song : playlist.getSongs()) {
			if (addSong(song)) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	
	public Song removeSong() {
		if (numSongs > 0) {
			Song removedSong = songs[--numSongs];
			songs[numSongs] = null;
			return removedSong;
		}
		return null;
	}
	
	//Remove and return the last song
	public Song removeSong(int index) {
		if (index >= 0 && index < numSongs) {
			Song removedSong = songs[index];
			//Shift elements to the left
			for (int i = index; i < numSongs - 1; i++) {
				songs[i] = songs[i+1];
			}
			songs[--numSongs] = null;
			return removedSong;
		}
		return null;
	}
	


}
