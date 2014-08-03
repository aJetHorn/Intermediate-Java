import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Playlist {
	private String name;
	private MyLinkedList<Song> songs;
	
	public Playlist(String name) {
		this.name = name;
		songs = new MyLinkedList<Song>();
	}
	
	public String getName() {
		return name;
	}
	
	public Song getSong(int index) {
		return songs.get(index - 1);
	}

	public int getNumSongs() {
		return songs.size();
	}
	
	public void addSong(Song song) {
		songs.add(song);
	}
	
	public void printList() {
		System.out.println(name);
		
		for (int i = 1; i <= getNumSongs(); i++) {
			System.out.print(i + "\t");
			getSong(i).printSongRow();
			System.out.println();
		}
		
		System.out.println();
	}
	
	public void sortByYear() {
		LinkedMergeSort.mergeSort(songs, Song.SongYearComparator);
	}
	
	public void sortByArtist() {
		LinkedMergeSort.mergeSort(songs, Song.SongArtistComparator);
	}
	
	public void sortByTitle() {
		LinkedMergeSort.mergeSort(songs, Song.SongTitleComparator);
	}
	
	public static Playlist readPlayListFromFile(String filename) {
		
		Scanner file;
		
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Cannot find file " + filename);
			return null;
		}
		
		String name = file.nextLine();
		
		Playlist playlist = new Playlist(name);
		
		while (file.hasNextLine()) {
			Scanner line = new Scanner(file.nextLine());
			line.useDelimiter("\\t|[\\n\\r\\f]+");
			
			String title = line.next();
			String artist = line.next();
			String album = line.next();
			int year = line.nextInt();
			String time = line.next();
			
			playlist.addSong(new Song(title, artist, album, year, time));
			
			line.close();
		}	
		file.close();
		
		return playlist;
	}
}
