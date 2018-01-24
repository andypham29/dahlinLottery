package com.example.andy.dahlinLottery;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import org.json.JSONException;

import static java.lang.Integer.parseInt;


/**
 * Implementation of App Widget functionality.
 */
public class standing extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        data d = null;
        try {
            d = new data();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RemoteViews remoteViews;
        ComponentName componentName;
        remoteViews = new RemoteViews(context.getPackageName(), R.layout.standing);
        componentName = new ComponentName(context, standing.class);

        try {
            remoteViews.setTextViewText(R.id.standing_txt, d.showData());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        appWidgetManager.updateAppWidget(componentName, remoteViews);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

