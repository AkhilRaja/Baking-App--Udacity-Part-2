package com.example.akhilraja.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.Rest.ApiClient;
import com.example.akhilraja.bakingapp.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    private List<BakingModel> bakingModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<List<BakingModel>> call = apiService.getBaking();
        call.enqueue(new Callback<List<BakingModel>>() {
            @Override
            public void onResponse(Call<List<BakingModel>> call, Response<List<BakingModel>> response) {
                bakingModelList = response.body();
                Log.d("Response  :  "," " + bakingModelList.get(0).getName());
            }

            @Override
            public void onFailure(Call<List<BakingModel>> call, Throwable t) {
                Log.d("Response","Fail" + t);
            }
     });
    }
}
