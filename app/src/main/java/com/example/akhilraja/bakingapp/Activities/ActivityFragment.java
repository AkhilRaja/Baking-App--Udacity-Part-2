package com.example.akhilraja.bakingapp.Activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.akhilraja.bakingapp.Adapter.MyAdapter;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.R;
import com.example.akhilraja.bakingapp.Rest.ApiClient;
import com.example.akhilraja.bakingapp.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AkhilRaja on 16/06/17.
 */

public class ActivityFragment extends Fragment {



    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    private List<BakingModel> bakingModelList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,
                container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapter(getContext(),bakingModelList);
        recyclerView.setAdapter(adapter);


        //       Log.d("Count ",adapter.getItemCount() + "");

        Call<List<BakingModel>> call = apiService.getBaking();
        call.enqueue(new Callback<List<BakingModel>>() {
            @Override
            public void onResponse(Call<List<BakingModel>> call, Response<List<BakingModel>> response) {
                bakingModelList.addAll(response.body());
                Log.d("Response  :  "," " + bakingModelList.get(0).getName());

                adapter.notifyDataSetChanged();
                Log.d("Count After response ",adapter.getItemCount() + "");
            }

            @Override
            public void onFailure(Call<List<BakingModel>> call, Throwable t) {
                Log.d("Response","Fail" + t);
            }
        });




        return view;


    }
}
