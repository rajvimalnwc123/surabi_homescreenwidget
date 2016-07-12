package com.example.nwcemp01.surabi_homescreenwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nwcemp01 on 11/7/16.
 */
public class HelloWidgetProvider extends AppWidgetProvider{
    private static SimpleDateFormat formatter = new SimpleDateFormat(
            "dd MMM yyyy  hh:mm:ss a");
    static String strWidgetText = "";
    public static String MY_WIDGET_UPDATE = "MY_OWN_WIDGET_UPDATE";
//public static String chebarsellingrate,chebarbuyingrate,cheftsellingrate,cheftbuyingrate;


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        super.onReceive(context, intent);
        AppWidgetManager appWidgetManager = AppWidgetManager
                .getInstance(context);
        ComponentName thisAppWidget = new ComponentName(
                context.getPackageName(), HelloWidgetProvider.class.getName());
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget);
        Intent intent1 = new Intent(context, HelloWidgetProvider.class);
        intent1.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
        context.sendBroadcast(intent1);
        context.startService(new Intent(context, AutoUpdation.class));
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // TODO Auto-generated method stub
        // super.onDeleted(context, appWidgetIds);
        Toast.makeText(context, "onDeleted()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDisabled(Context context) {
        // TODO Auto-generated method stub
        Toast.makeText(context, "onDisabled()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onEnabled(Context context) {
        // TODO Auto-generated method stub
        Toast.makeText(context, "onEnabled()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        // TODO Auto-generated method stub
        super.onUpdate(context, appWidgetManager, appWidgetIds);

    }

    public static void appDoUpdate(Context con) {
        Log.w("appDoUpdate", " On Calling appDoUpdate Hello Widget Timer");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(con);
        RemoteViews remoteViews = new RemoteViews(con.getPackageName(),
                R.layout.hellowidget_layout);
        ComponentName thisWidget = new ComponentName(con,
                HelloWidgetProvider.class);
        Api api =new Api();
        String currentTime = formatter.format(new Date());
        strWidgetText = currentTime;
remoteViews.setTextViewText(R.id.chebarsellingrate,"BAR :" +" "+ getchebarsellingrate());
        remoteViews.setTextViewText(R.id.chebarbuyingrate,"    FT :" +" "+ getchebarbuyingrate());

        remoteViews.setTextViewText(R.id.cheftbuyingrate,"GOLD :" +" "+ getGoldBid());
        remoteViews.setTextViewText(R.id.cheftsellingrate,"   INR :" +" "+ getcheftsellingrate());
        remoteViews.setTextViewText(R.id.title, getMessage());
      ////  remoteViews.setTextViewText(R.id.desc,"+getDescription());
    // remoteViews.setTextViewText(R.id.content,getDescription2());
        appWidgetManager.updateAppWidget(thisWidget, remoteViews);
    }


    public static String getchebarsellingrate() {
        return Api.Chebarsellingrate;
    }

    public static String getchebarbuyingrate() {
        return Api.Chebarbuyingrate;
    }

    public static String getcheftsellingrate() {
        return Api.Cheftsellingrate;
    }

    public static String getcheftbuyingrate() {
        return Api.Cheftbarbuyingrate;
    }



    public static String getGoldBid() {
        return Api.GoldBid;
    }
    private static String getMessage() {
        return Api.GoldAsk;
    }
    private static String getDescription() {
        return Api.GoldBid;
    }
    private static String getDescription2() {
        return Api.Goldsesc;
    }
}