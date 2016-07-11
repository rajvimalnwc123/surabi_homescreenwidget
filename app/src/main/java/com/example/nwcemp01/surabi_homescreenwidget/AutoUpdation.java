package com.example.nwcemp01.surabi_homescreenwidget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by nwcemp01 on 11/7/16.
 */
public class AutoUpdation extends Service {

    public Emitter.Listener onNewMessage = new Emitter.Listener() {

        @Override
        public void call(final Object... args) {

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // doing some work

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(String.valueOf(args[0]));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONUtils.saveSocketData(jsonObject);
                }
            };
//            new Thread(runnable).start();
        }
    };
    com.github.nkzawa.socketio.client.Socket mSocket;
    String FEED_URL = "http://demo.surabibullion.com:8001/";//socket
    private int m;


    @Override
    public void onCreate() {
        // TODO Auto-generated method stub.
        super.onCreate();
        Log.w("AutoUpdation", "onCreate.");
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);

        connect();
        Log.w("AutoUpdation", "onStart.");
  /*      Timer timer = new Timer();
        TimerTask hourlyTask = new TimerTask() {
            @Override
            public void run() {
                connect();
                Log.w("AutoUpdation", " On Calling Auto timer");


            }
        };

        timer.schedule(hourlyTask, 01, 20000);
  */  }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.w("AutoUpdation", "onDestroy.");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void doRequest() {



        doPostRequest();
        /*try {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // doing some work
                    doPostRequest();
                }


            };
            new Thread(runnable).start();

        } catch (Exception e) {
            Log.e("Uploadinfo:", e.getMessage());
            e.printStackTrace();
        }*/
    }

    private void doPostRequest() {
        HelloWidgetProvider hh = new HelloWidgetProvider();
        hh.appDoUpdate(getApplicationContext());
    }

    private void connect() {
        try {
            mSocket = IO.socket(FEED_URL);
            doRequest();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        mSocket.on("feedxml", onNewMessage);
        mSocket.connect();
    }


}
