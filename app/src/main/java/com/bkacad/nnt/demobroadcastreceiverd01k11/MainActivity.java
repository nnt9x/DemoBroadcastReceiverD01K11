package com.bkacad.nnt.demobroadcastreceiverd01k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView tvStatus;
    protected ConstraintLayout rootView;
    protected IntentFilter intentFilter;
    protected MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.tvStatus);
        rootView = findViewById(R.id.rootView);

        myReceiver = new MyReceiver() {
            @Override
            public void powerConnected() {
                rootView.setBackgroundResource(android.R.color.holo_green_light);
                tvStatus.setText("Cắm sạc");
            }

            @Override
            public void powerDisconnected() {
                rootView.setBackgroundResource(android.R.color.holo_red_light);
                tvStatus.setText("Rút sạc");
            }
        };

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }
}