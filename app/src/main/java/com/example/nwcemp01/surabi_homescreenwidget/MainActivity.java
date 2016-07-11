package com.example.nwcemp01.surabi_homescreenwidget;

import android.appwidget.AppWidgetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 100000;
    public  Emitter.Listener onNewMessage = new Emitter.Listener() {

        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(String.valueOf(args[0]));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONUtils.saveSocketData(jsonObject);

                }
            });
        }
    };
    com.github.nkzawa.socketio.client.Socket mSocket;
    // public static JSONObject jsonObject = null;
    String FEED_URL = "http://demo.surabibullion.com:8001/";//socket

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect();
                Toast.makeText(MainActivity.this, "connected to widget", Toast.LENGTH_SHORT).show();
                HelloWidgetProvider widget = new HelloWidgetProvider();
                AppWidgetManager appWidgetManager = null;
                int[] appWidgetIds = new int[0];
                widget.onUpdate(MainActivity.this, appWidgetManager, appWidgetIds);
            }
        });
    }

    public  void connect() {
        try {
            mSocket = IO.socket(FEED_URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mSocket.on("feedxml", onNewMessage);
        mSocket.connect();
    }
}