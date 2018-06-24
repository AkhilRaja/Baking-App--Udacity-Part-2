package com.example.akhilraja.bakingapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.FrameLayout;

import com.example.akhilraja.bakingapp.R;

/**
 * Created by AkhilRaja on 18/06/17.
 */

public class DetailActivity extends AppCompatActivity {

    private boolean isTwoPane = false;

    DetailFragment detailFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

    }


}
