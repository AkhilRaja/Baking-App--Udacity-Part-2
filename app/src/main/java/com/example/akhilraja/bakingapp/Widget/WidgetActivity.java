package com.example.akhilraja.bakingapp.Widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;

import com.example.akhilraja.bakingapp.Activities.MainActivity;
import com.example.akhilraja.bakingapp.R;

/**
 * Created by AkhilRaja on 04/07/17.
 */

public class WidgetActivity extends AppWidgetProvider {

    @Override
    public void onReceive(final Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)) {
            // refresh all your widgets
            AppWidgetManager mgr = AppWidgetManager.getInstance(context);
            ComponentName cn = new ComponentName(context, WidgetActivity.class);
            mgr.notifyAppWidgetViewDataChanged(mgr.getAppWidgetIds(cn), R.id.stack);
        }
        super.onReceive(context, intent);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        final int N = appWidgetIds.length;


        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);


            // set intent for widget service that will create the views
            Intent serviceIntent = new Intent(context, StackViewService.class);
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);

            // embed extras so they don't get ignored

            views.setRemoteAdapter(R.id.stack,serviceIntent);
            views.setEmptyView(R.id.stack,R.id.empty_view);

            Intent viewIntent = new Intent(context, MainActivity.class);

            viewIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            viewIntent.setData(Uri.parse(viewIntent.toUri(Intent.URI_INTENT_SCHEME)));
            PendingIntent viewPendingIntent = PendingIntent.getActivity(context, 0, viewIntent, 0);
           views.setPendingIntentTemplate(R.id.stack, viewPendingIntent);
            //views.setOnClickPendingIntent(R.id.stack,viewPendingIntent);

            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds[i], R.id.stack);
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetIds[i], views);

        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

}

