package com.example.akhilraja.bakingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.akhilraja.bakingapp.Activities.DetailActivity;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AkhilRaja on 17/06/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    List<BakingModel> modelList;





    public MyAdapter(Context context, List<BakingModel> bakingModel)
    {
        this.context = context;

        modelList = bakingModel;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @Nullable @BindView(R.id.imageView1) ImageView imageView;
        @Nullable @BindView(R.id.textView2) TextView tv_name;
        @Nullable @BindView(R.id.textView4) TextView tv_noServings;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            //Check if two pane and then dont start another Activity

            itemView.setOnClickListener((View view) -> {

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Model",modelList.get(getAdapterPosition()));
                view.getContext().startActivity(intent);

            });

        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recepie_names_cards,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder viewHolder, int i) {


        if(viewHolder.tv_name != null && viewHolder.tv_noServings != null) {

            Log.d("Bind","Added");
            viewHolder.tv_name.setText(modelList.get(i).getName());
            viewHolder.tv_noServings.setText(String.valueOf(modelList.get(i).getServings()));
        }

        if(viewHolder.imageView!= null) {
            if (modelList.get(i).getImage() != "") {
                Glide.with(context).load(modelList.get(i).getImage()).into(viewHolder.imageView);
            }
        viewHolder.imageView.setImageResource(R.drawable.restaurant);
        }
    }

    @Override
    public int getItemCount() {
        return  modelList.size();
    }


}
