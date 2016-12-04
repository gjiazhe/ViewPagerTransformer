package com.gjiazhe.viewpagertransformer.sample;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gjiazhe.viewpagertransformer.CubePageTransformer;
import com.gjiazhe.viewpagertransformer.DepthPageTransformer;
import com.gjiazhe.viewpagertransformer.LayerTransformer;
import com.gjiazhe.viewpagertransformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Default");

        fragments = new ArrayList<>();
        fragments.add(new MyFragment(1, Color.parseColor("#b7bf70")));
        fragments.add(new MyFragment(2, Color.parseColor("#8394a4")));
        fragments.add(new MyFragment(3, Color.parseColor("#b0886f")));
        fragments.add(new MyFragment(4, Color.parseColor("#42a662")));
        fragments.add(new MyFragment(5, Color.parseColor("#a9aabd")));

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_transformers, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ViewPager.PageTransformer pageTransformer = null;
        switch (item.getItemId()) {
            case R.id.transformer_default:
                pageTransformer = null;
                break;
            case R.id.transformer_depth:
                pageTransformer = new DepthPageTransformer();
                break;
            case R.id.transformer_zoom_out:
                pageTransformer = new ZoomOutPageTransformer();
                break;
            case R.id.transformer_layer:
                pageTransformer = new LayerTransformer();
                break;
        }
        viewPager.setPageTransformer(true, pageTransformer);
        actionBar.setTitle(item.getTitle());
        return true;
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
