public class Program9 {
	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.out.println("USAGE: java Playlist playlist1 [playlist2] [playlist3]...");
			System.exit(1);
			return;
		}
		
		Playlist firstPlaylist = null;
		Playlist lastPlaylist = null;
		
		for (int i = 0; i < args.length; i++) {
			
			Playlist playlist = Playlist.readPlayListFromFile(args[i]);
			
			if (playlist != null) {
				playlist.printList();
			}

			if (i == 0) {
				firstPlaylist = playlist;
			}
			
			lastPlaylist = playlist;
		}
		
		// Merge sort the first list by artist and print it out again
		System.out.println("Sorting " + firstPlaylist.getName() + " by artist:");
		firstPlaylist.sortByArtist();
		firstPlaylist.printList();
		
		// Merge sort the last list by year and print it out again
		System.out.println("Sorting " + lastPlaylist.getName() + " by year:");
		lastPlaylist.sortByYear();
		lastPlaylist.printList();
		
		// Output the first and last song from the first playlist
		System.out.println("First and last song in " + firstPlaylist.getName());
		System.out.println(firstPlaylist.getSong(1).toString());
		System.out.println(firstPlaylist.getSong(firstPlaylist.getNumSongs()).toString());
	}
}
