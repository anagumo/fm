package io.github.gothwski.tarantulafm;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import io.github.gothwski.tarantulafm.ui.adapter.PagerAdapter;
import io.github.gothwski.tarantulafm.ui.fragment.HypedArtistFragment;
import io.github.gothwski.tarantulafm.ui.fragment.TopArtistFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setViewPager();

        if (toolbar != null)
            setSupportActionBar(toolbar);
    }

    private void setViewPager() {
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), buildFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_hyped_focus);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_top_focus);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private ArrayList<Fragment> buildFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new HypedArtistFragment());
        fragments.add(new TopArtistFragment());

        return fragments;
    }
}