package io.github.gothwski.tarantulafm.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.github.gothwski.tarantulafm.domain.Artist;

/**
 * Created by ariana gothwski on 8/07/15.
 */
public class HypedArtistsResponse {

    @SerializedName(JsonKeys.ARTIST_RESULTS)
    HypedArtistsResults results;

    public ArrayList<Artist> getArtists(){
        return results.artists;
    }

    public void setArtist(ArrayList<Artist> artist){
        this.results.artists = artist;
    }

    private class HypedArtistsResults {
        ArrayList<Artist> artists;
    }
}
