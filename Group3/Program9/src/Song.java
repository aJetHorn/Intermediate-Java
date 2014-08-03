import java.util.Comparator;

public class Song {
	private String title;
	private String artist;
	private String album;
	private int time;
	private int year;
	
	public static Comparator<Song> SongTitleComparator = new Comparator<Song>() {
		public int compare(Song o1, Song o2) {
			return String.CASE_INSENSITIVE_ORDER.compare(o1.title, o2.title);
		}
	};
	
	public static Comparator<Song> SongArtistComparator = new Comparator<Song>() {
		public int compare(Song o1, Song o2) {
			return String.CASE_INSENSITIVE_ORDER.compare(o1.artist, o2.artist);
		}
		
	};
	
	public static Comparator<Song> SongYearComparator = new Comparator<Song>() {
		public int compare(Song o1, Song o2) {
			return o1.year - o2.year;
		}
	};

	public Song(String title, String artist, String album, int year, int time) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.time = time;
	}
	
	public Song(String title, String artist, String album, int year, String timeString) {
		this(title, artist, album, year, Song.timeStringToSecs(timeString));
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getTime() {
		return time;
	}

	public String getTimeAsFormattedString() {
		int minutes = time / 60;
		int seconds = time % 60;
		
		String returnString = "";
		
		if (minutes < 10) {
			returnString += "0"; 
		}
		returnString += minutes;
		
		returnString += ":";
		
		if (seconds < 10) {
			returnString += "0"; 
		}
		returnString += seconds;
		
		return returnString;
	}

	public void printSongRow() {
		System.out.printf("%-25s\t %-25s\t %-30s\t %d\t %s", title, artist, album, year, getTimeAsFormattedString());
	}
	
	public String toString() {
		return String.format("\"%s\" by %s (%d)", title, artist, year);
	}
	
	public static int timeStringToSecs(String timeString) {
		String[] timeArray = timeString.split(":");
		
		int minutes = 0;
		int seconds = 0;
		if (timeArray.length > 1) {
			minutes = Integer.parseInt(timeArray[0]);
		}

		seconds = Integer.parseInt(timeArray[timeArray.length - 1]);
		
		return (minutes * 60) + seconds;
	}
}
