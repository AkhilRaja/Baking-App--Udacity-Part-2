package com.example.akhilraja.bakingapp.Widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.akhilraja.bakingapp.Activities.MainActivity;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.Model.Ingredient;
import com.example.akhilraja.bakingapp.R;
import com.example.akhilraja.bakingapp.Rest.ApiClient;
import com.example.akhilraja.bakingapp.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by akhilraja on 08/11/17.
 */

public class StackViewService extends RemoteViewsService{
    @Override
    public StackRemoteViewsFactory onGetViewFactory(Intent intent) {
        return new StackRemoteViewsFactory(this.getBaseContext(),intent);
    }
}

class StackRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);

    private Context mContext;
    private int mAppWidgetId;
    private List<BakingModel> bakingModels = new ArrayList<>();

    public StackRemoteViewsFactory(Context context,Intent intent)
    {
        mContext = context;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);;

    }
    @Override
    public void onCreate() {
    }

    @Override
    public void onDataSetChanged() {


                Call<List<BakingModel>> call = apiService.getBaking();
                try {
                     bakingModels = call.execute().body();
                     Log.d("Widget Bake ",""+bakingModels.size());
                }
                catch (Exception e)
                {

                }
//                call.enqueue(new Callback<List<BakingModel>>() {
//                    @Override
//                    public void onResponse(Call<List<BakingModel>> call, Response<List<BakingModel>> response) {
//
//                        bakingModels.addAll(response.body());
//                        Log.d("Widget", "Got the Data" + bakingModels.size());
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<BakingModel>> call, Throwable t) {
//                        Log.d("Response", "Fail" + t);
//                    }
//                });

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        Log.d("Widget Count ",""+bakingModels.size());
        return bakingModels.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        int i = 0;
        String Ing = "";
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.stackwidgetitem);
        Log.d("getViewAt","Inside");


        if(position <= bakingModels.size()) {

            BakingModel bake = bakingModels.get(position);
            Log.d("Widget Name", bake.getName());
            remoteViews.setTextViewText(R.id.textView8, bake.getName());
            remoteViews.setTextViewText(R.id.textView5, "Ingredients : ");

            for (Ingredient ingredient : bake.getIngredients()) {
                i++;
                Ing = Ing.concat(i + ".  " + ingredient.getIngredient() + "\n");
            }
            remoteViews.setTextViewText(R.id.textView, Ing);

            Intent fillInIntent = new Intent();
            remoteViews.setOnClickFillInIntent(R.id.stack, fillInIntent);
        }
        return remoteViews;
    }


    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}
