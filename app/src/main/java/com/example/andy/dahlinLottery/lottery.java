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
public class lottery extends AppWidgetProvider {

    private static final String SYNC_CLICKED = "WidgetImageClick";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        //CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.lottery);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }


        RemoteViews remoteViews;
        ComponentName componentName;

        remoteViews = new RemoteViews(context.getPackageName(), R.layout.lottery);
        componentName = new ComponentName(context, lottery.class);

        remoteViews.setImageViewResource(R.id.img, setImage(1000));

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

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.lottery);
            componentName = new ComponentName(context, lottery.class);

            remoteViews.setImageViewResource(R.id.img, setImage(r.nextInt(999)));

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

        if(num<180){
            image = R.drawable.ari;
        }
        if(179<num && num<305){
            image = R.drawable.buf;
        }
        if(304<num && num<410){
            image = R.drawable.ott;
        }
        if(409<num && num<505){
            image = R.drawable.van;
        }
        if(504<num && num<590){
            image = R.drawable.mtl;
        }
        if(589<num && num<666){
            image = R.drawable.edm;
        }
        if(665<num && num<733){
            image = R.drawable.fla;
        }
        if(732<num && num<790){
            image = R.drawable.det;
        }
        if(789<num && num<845){
            image = R.drawable.car;
        }
        if(844<num && num<890){
            image = R.drawable.chi;
        }
        if(889<num && num<923){
            image = R.drawable.nyi;
        }
        if(922<num && num<950){
            image = R.drawable.pit;
        }
        if(949<num && num<972){
            image = R.drawable.ana;
        }
        if(971<num && num<990){
            image = R.drawable.lak;
        }
        if(989<num && num<1000){
            image = R.drawable.min;
        }
        if (num == 1000){
            image = R.drawable.dahlin;
        }
        return image;
    }
}

