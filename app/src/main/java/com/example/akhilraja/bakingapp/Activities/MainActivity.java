package com.example.akhilraja.bakingapp.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.example.akhilraja.bakingapp.Adapter.MyAdapter;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.R;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnCreateListenerImage {

    private static boolean isTwoPane = false;
    private ActivityFragment activityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);


        if (findViewById(R.id.linear_tablet).getTag()!=null && findViewById(R.id.linear_tablet).getTag().equals("tablet")) {
            Log.d("Tablet","Populating");
            isTwoPane = true;
        }



    }

    @Override
    public void handleClick(BakingModel positionModel) {

        //Log.d("Click Event from the Adapter ", + position + "" );
       // Log.d("Model",positionModel.getName());
        if(isTwoPane)
        {
            final DetailFragment fragment = new DetailFragment();

            Bundle modelBundle = new Bundle();
            modelBundle.putParcelable("Model",positionModel);

            fragment.setArguments(modelBundle);


            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.DetailContainerFragment, fragment)
                    .commit();

        }
        //Do things with the recycler view
        else
        {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("Model",positionModel);
            startActivity(intent);
        }


    }
}




