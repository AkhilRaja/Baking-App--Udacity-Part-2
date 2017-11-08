package com.example.akhilraja.bakingapp.Activities;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);



    }
}
