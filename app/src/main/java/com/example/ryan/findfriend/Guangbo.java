package com.example.ryan.findfriend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Guangbo extends BroadcastReceiver {
    String gender,sheng,nian,yue,ri,height,xl,hun,gz;
    @Override
    public void onReceive(Context context, Intent intent) {
        String gender=intent.getStringExtra("gender");

        Toast.makeText(context,gender+sheng, Toast.LENGTH_SHORT).show();
    }
}
