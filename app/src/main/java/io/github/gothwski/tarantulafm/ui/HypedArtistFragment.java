package io.github.gothwski.tarantulafm.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.gothwski.tarantulafm.R;
import io.github.gothwski.tarantulafm.io.LastFmAdapter;
import io.github.gothwski.tarantulafm.io.model.HypedArtistsResponse;
import io.github.gothwski.tarantulafm.ui.adapter.HypedArtistAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ariana gothwski on 8/07/15.
 */
public class HypedArtistFragment extends Fragment implements Callback<HypedArtistsResponse> {

    public static  final int NUM_COL = 2;

    //public static final String LOG_TAG = "HypedArtistFragment";

    private RecyclerView mHypedArtistList;
    private HypedArtistAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HypedArtistAdapter(getActivity());
    }

    /*onAttach method that connect fragment -> Activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof MainActivity)
            Log.i(LOG_TAG, "Yes");
    }*/

    @Nullable
    @Override
    //ViewGroup -> Relative o Linear
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hyped_artist, container, false);

        mHypedArtistList = (RecyclerView) root.findViewById(R.id.hyped_artist_list);

        setupArtistList();
        //setDummyContent();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        LastFmAdapter.getApiService()
                .getHypedArtists(this);
    }

    private void setupArtistList (){
        mHypedArtistList.setLayoutManager( new GridLayoutManager(getActivity(), NUM_COL));
        mHypedArtistList.setAdapter(adapter);
        mHypedArtistList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
    }

    @Override
    public void success(HypedArtistsResponse hypedArtistsResponse, Response response) {
        adapter.addAll(hypedArtistsResponse.getArtists());
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}
