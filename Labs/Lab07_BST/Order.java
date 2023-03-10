import java.util.*;

public class Order {

    public static class byArtist implements Comparator<Track> {

        @Override
        public int compare(Track track1, Track track2) {
           return track1.artist().compareTo(track2.artist());
        }
    }

    // TODO: finish this one
    public static class byTitle implements Comparator<Track> {

        @Override
        public int compare(Track track1, Track track2) {
            return 0;
        }
    }

    // TODO: Create one for danceability called byDanceability
    // Use the song title as the tie-breaker
}