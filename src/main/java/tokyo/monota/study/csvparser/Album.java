package tokyo.monota.study.csvparser;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

public class Album {

    @CsvBindByName(column = "Album")
    private String albumTitle;

    @CsvBindAndJoinByName(column = "Artist", elementType = String.class)
    private MultiValuedMap<String, String> artists;

    @CsvBindAndJoinByName(column = "Track[0-9]+", elementType = String.class, mapType = HashSetValuedHashMap.class, required = true)
    private MultiValuedMap<String, String> tracks;

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public MultiValuedMap<String, String> getArtists() {
        return artists;
    }

    public void setArtists(MultiValuedMap<String, String> artists) {
        this.artists = artists;
    }

    public MultiValuedMap<String, String> getTracks() {
        return tracks;
    }

    public void setTracks(MultiValuedMap<String, String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumTitle='" + albumTitle + '\'' +
                ", artists=" + artists +
                ", tracks=" + tracks +
                '}';
    }
}