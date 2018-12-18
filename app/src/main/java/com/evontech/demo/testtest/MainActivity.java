package com.evontech.demo.testtest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FrameLayout layout_frame = null;
    private BroadcastReceiver listener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_frame = findViewById(R.id.layout_frame);

        initView();
    }


    private void initView(){
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        android.support.v4.app.Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        BlankFragment dialogFragment = new BlankFragment();


        registerReceiver();

        dialogFragment.show(ft, "dialog");


    }


    private void registerReceiver(){

        // Broadcast message from NearbyLocationActivity to this fragment
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getString(R.string.broadcast_action));
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mUpdateUIReceiver, intentFilter);
        registerReceiver(listener, intentFilter);



    }


    private BroadcastReceiver mUpdateUIReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equalsIgnoreCase("NearbyLocationEvent")) {
                Log.e("its a broadcast", "intent message= " + intent.getStringExtra("lat"));
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mUpdateUIReceiver != null)
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mUpdateUIReceiver);

    }
}
