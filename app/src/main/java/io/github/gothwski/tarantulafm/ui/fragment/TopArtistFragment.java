package io.github.gothwski.tarantulafm.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.gothwski.tarantulafm.R;
import io.github.gothwski.tarantulafm.io.LastFmAdapter;
import io.github.gothwski.tarantulafm.io.model.TopArtistResponse;
import io.github.gothwski.tarantulafm.ui.adapter.TopArtistAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopArtistFragment extends android.support.v4.app.Fragment {

    private RecyclerView artistList;
    private TopArtistAdapter artistAdapter;

    public TopArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        artistAdapter = new TopArtistAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_top_artist, container, false);
        artistList = (RecyclerView) root.findViewById(R.id.top_artist_list);
        setupList();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        LastFmAdapter.getApiService()
                .getTopArtist()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TopArtistResponse>() {
                    @Override
                    public void call(TopArtistResponse topArtistResponse) {
                        artistAdapter.addAll(topArtistResponse.getArtists());
                    }
                });
    }

    public void setupList() {
        artistList.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistList.setAdapter(artistAdapter);
    }

}
