import java.util.Comparator;

public class MyOrder {

    public static class ByArtist implements Comparator<Track> {

        @Override
        public int compare(Track track1, Track track2) {
           return track1.artist().compareTo(track2.artist());
        }
    }

    public static class ByTitle implements Comparator<Track> {

        @Override
        public int compare(Track track1, Track track2) {
            return track1.title().compareTo(track2.title());
        }
    }
    
    public static class ByPopularity implements Comparator<Track> {

        @Override
        public int compare(Track track1, Track track2) {
            int compValue = track1.popularity().compareTo(track2.popularity());
            return ((compValue!=0)?(compValue):(track1.compareTo(track2)));
        }
    }
}
