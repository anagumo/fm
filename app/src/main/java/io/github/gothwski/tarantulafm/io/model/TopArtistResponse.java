package io.github.gothwski.tarantulafm.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.github.gothwski.tarantulafm.domain.Artist;

/**
 * Created by gothwski on 16/07/15.
 */
public class TopArtistResponse {
    @SerializedName(JsonKeys.ARTIST_RESULTS)
    TopArtistsResults results;

    public ArrayList<Artist> getArtists(){
        return results.artists;
    }

    public void setArtist(ArrayList<Artist> artist){
        this.results.artists = artist;
    }

    private class TopArtistsResults {
        ArrayList<Artist> artists;
    }
}
