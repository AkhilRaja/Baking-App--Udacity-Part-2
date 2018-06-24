package com.example.akhilraja.bakingapp.Activities;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.akhilraja.bakingapp.Adapter.MyAdapter;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.R;
import com.example.akhilraja.bakingapp.Rest.ApiClient;
import com.example.akhilraja.bakingapp.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AkhilRaja on 16/06/17.
 */

public class ActivityFragment extends android.support.v4.app.Fragment {

    private List<BakingModel> bakingModelList = new ArrayList<>();

    private RecyclerView.Adapter adapter;

    @Nullable@BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,
                container, false);
        setRetainInstance(true);

        ButterKnife.bind(this,view);

        if(view.findViewById(R.id.recyclerView_tab)!= null)
        {
            recyclerView = view.findViewById(R.id.recyclerView_tab);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
            recyclerView.setLayoutManager(layoutManager);
        }
        else
        {
            try {
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
            }
            catch (Exception e)
            {
                Log.d("Exception",e+"");
            }

        }

        adapter = new MyAdapter(getContext(), bakingModelList);
        recyclerView.setAdapter(adapter);


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Observable<List<BakingModel>> bakingModelObservable =
                apiService.getBaking();

        bakingModelObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(bakeList -> {
                    bakingModelList.clear();
                    bakingModelList.addAll(bakeList);
            //Log.d("Response  :  "," " + bakingModelList.get(0).getName());
            adapter.notifyDataSetChanged();
        });
        return view;


    }
    public void setData(List<BakingModel> data) {
        this.bakingModelList = data;
    }

    public List<BakingModel> getData() {
        return bakingModelList;
    }
}
