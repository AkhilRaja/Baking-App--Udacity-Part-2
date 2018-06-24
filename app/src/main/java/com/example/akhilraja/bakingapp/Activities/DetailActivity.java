package com.example.akhilraja.bakingapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.akhilraja.bakingapp.Adapter.DetailAdapter;
import com.example.akhilraja.bakingapp.Adapter.MyAdapter;
import com.example.akhilraja.bakingapp.Model.BakingModel;
import com.example.akhilraja.bakingapp.Model.Step;
import com.example.akhilraja.bakingapp.R;

/**
 * Created by AkhilRaja on 18/06/17.
 */

public class DetailActivity extends AppCompatActivity implements DetailAdapter.OnCreateListenerImage {

    private boolean isTwoPane = false;
    DetailFragment detailFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        if(findViewById(R.id.linear_tablet)!=null)
            if (findViewById(R.id.linear_tablet).getTag().equals("tablet") && findViewById(R.id.linear_tablet).getTag()!=null ) {
                Log.d("Tablet","Populating");
                isTwoPane = true;
            }
            else {
                isTwoPane = false;
                Log.d("Mobile","Populating");
            }


    }

    @Override
    public void handleClick(Step positionModel) {

        if (isTwoPane) {

            StepFragment stepFragment = new StepFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("Step",positionModel);

            stepFragment.setArguments(bundle);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.DetailContainerFragment, stepFragment)
                    .commit();
        }

        else {
            Intent intent = new Intent(getApplicationContext(), StepActivity.class);
            intent.putExtra("Step",positionModel);
            startActivity(intent);
        }
    }

}
