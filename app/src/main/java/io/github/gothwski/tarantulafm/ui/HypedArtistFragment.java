package io.github.gothwski.tarantulafm.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import io.github.gothwski.tarantulafm.MainActivity;
import io.github.gothwski.tarantulafm.R;

/**
 * Created by ariana gothwski on 8/07/15.
 */
public class HypedArtistFragment extends Fragment {

    public static final String LOG_TAG = "HypedArtistFragment";

    //onAttach method that connect fragment -> Activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof MainActivity)
            Log.i(LOG_TAG, "Yes");
    }

    @Nullable
    @Override
    //ViewGroup -> Relative o Linear
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hyped_artist, container, false);

        return root;
    }
}
