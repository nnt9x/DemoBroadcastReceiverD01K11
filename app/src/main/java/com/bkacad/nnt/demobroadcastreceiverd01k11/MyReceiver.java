package com.bkacad.nnt.demobroadcastreceiverd01k11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public abstract class MyReceiver extends BroadcastReceiver {

    public abstract void powerConnected();
    public abstract void powerDisconnected();

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case "android.intent.action.ACTION_POWER_CONNECTED":
                // Xu ly sau
                powerConnected();
                break;
            case "android.intent.action.ACTION_POWER_DISCONNECTED":
                powerDisconnected();
                // Xu ly sau
                break;
        }
    }
}
