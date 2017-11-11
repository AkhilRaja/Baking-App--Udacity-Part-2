package com.example.akhilraja.bakingapp.Activities;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.R;
import com.example.akhilraja.bakingapp.Rest.ApiClient;
import com.example.akhilraja.bakingapp.Rest.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityFragment activityFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);


        FragmentManager fm = getFragmentManager();
        activityFragment = (ActivityFragment) fm.findFragmentByTag("ActivityFragment");


        // create the fragment and data the first time
        if (activityFragment == null) {
            // add the fragment
            activityFragment = new ActivityFragment();
            fm.beginTransaction().add(activityFragment, "ActivityFragment").commit();
            // load data from a data source or perform any calculation
            activityFragment.setData(activityFragment.getData());
        }

    }
}
