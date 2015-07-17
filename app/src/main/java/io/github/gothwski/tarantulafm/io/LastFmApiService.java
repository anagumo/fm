package io.github.gothwski.tarantulafm.io;

import io.github.gothwski.tarantulafm.io.model.HypedArtistsResponse;
import io.github.gothwski.tarantulafm.io.model.TopArtistResponse;
import retrofit.Callback;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by ariana gothwski on 8/07/15.
 */
public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtists(Callback<HypedArtistsResponse> serverResponse);

    @GET(ApiConstants.URL_TOP_ARTIST)
    Observable<TopArtistResponse> getTopArtist();
}
