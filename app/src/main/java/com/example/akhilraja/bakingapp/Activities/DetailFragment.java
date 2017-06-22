package com.example.akhilraja.bakingapp.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akhilraja.bakingapp.Adapter.DetailAdapter;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.Model.Ingredient;
import com.example.akhilraja.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AkhilRaja on 21/06/17.
 */

public class DetailFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private BakingModel bakingModel;

    @Nullable@BindView(R.id.ingredient)
    TextView textView_ing;
    @Nullable@BindView(R.id.ingredient_list)
    TextView editText_inglist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,container,false);

        ButterKnife.bind(this,view);



        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        bakingModel= getActivity().getIntent().getParcelableExtra("Model");
      //  Log.d("Model from detail", "" + bakingModel.getName());

        int i = 0;
        textView_ing.setText(R.string.ingredients);
        for(Ingredient ingredient : bakingModel.getIngredients() ) {
            i++;
            editText_inglist.append(i + ".  " + ingredient.getIngredient()+"\n");
        }

        adapter = new DetailAdapter(getContext(),bakingModel);
        recyclerView.setAdapter(adapter);


        return view;
    }


}
