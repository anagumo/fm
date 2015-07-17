package io.github.gothwski.tarantulafm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.gothwski.tarantulafm.ui.fragment.HypedArtistFragment;
import io.github.gothwski.tarantulafm.ui.fragment.TopArtistFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new TopArtistFragment())
                    .commit();
        }
    }
}