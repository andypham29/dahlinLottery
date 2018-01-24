package com.example.andy.dahlinLottery;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class nhl extends AppWidgetProvider {

    private static final String SYNC_CLICKED = "WidgetImageClick";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        //CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.nhl);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

        Random r = new Random();

        RemoteViews remoteViews;
        ComponentName componentName;

        remoteViews = new RemoteViews(context.getPackageName(), R.layout.nhl);
        componentName = new ComponentName(context, nhl.class);

        remoteViews.setImageViewResource(R.id.img, setImage(7));

        remoteViews.setOnClickPendingIntent(R.id.img, getPendingSelfIntent(context,SYNC_CLICKED));
        appWidgetManager.updateAppWidget(componentName, remoteViews);
    }
    public void onReceive(Context context, Intent intent){
        super.onReceive(context, intent);

        if(SYNC_CLICKED.equals(intent.getAction())){
            Random r = new Random();

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName componentName;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.nhl);
            componentName = new ComponentName(context, nhl.class);

            remoteViews.setImageViewResource(R.id.img, setImage(r.nextInt(6)));

            appWidgetManager.updateAppWidget(componentName, remoteViews);
        }
    }

    protected PendingIntent getPendingSelfIntent(Context context, String action){
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    public int setImage(int num){
        int image = 0;

        switch (num){

            case 0:
                image = R.drawable.mtl;
                break;
            case 1:
                image = R.drawable.cgy;
                break;
            case 2:
                image = R.drawable.edm;
                break;
            case 3:
                image = R.drawable.ott;
                break;
            case 4:
                image = R.drawable.tor;
                break;
            case 5:
                image = R.drawable.van;
                break;
            case 6:
                image = R.drawable.wpg;
                break;
            case 7:
                image = R.drawable.nhl;
                break;
        }
        return image;
    }
}

