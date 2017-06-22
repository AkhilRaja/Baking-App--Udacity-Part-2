package com.example.akhilraja.bakingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akhilraja.bakingapp.Activities.DetailActivity;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.Model.Ingredient;
import com.example.akhilraja.bakingapp.Model.Step;
import com.example.akhilraja.bakingapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AkhilRaja on 21/06/17.
 */

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Step> stepList;

    private boolean check;
    private int which_layout;
    private int count;




    public DetailAdapter(Context context, BakingModel bakingModel){
       // Log.d("Inside Adapter" , bakingModel.getIngredients().get(0).getIngredient());
        stepList = bakingModel.getSteps();
    }

    public class DetailView2 extends RecyclerView.ViewHolder{

        @Nullable @BindView(R.id.step)
        TextView textView_step;

        public DetailView2(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener((View view) -> {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Step",stepList.get(getAdapterPosition()));
                view.getContext().startActivity(intent);

            });
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

                View v2 = inflater.inflate(R.layout.fragment_detail2,viewGroup,false);
                Log.d("onCreateView","Create Layout 2" + i);
                return  new DetailView2(v2);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

                DetailView2 detailView2= (DetailView2) viewHolder;
                detailView2.textView_step.setText(i + ".  "+stepList.get(i).getShortDescription());
                Log.d("onBindView","Bind Layout 2");

    }

    @Override
    public int getItemCount() {
        return stepList.size();
    }
}
