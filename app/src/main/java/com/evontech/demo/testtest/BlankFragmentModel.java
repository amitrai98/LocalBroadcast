package com.evontech.demo.testtest;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v4.content.LocalBroadcastManager;

import java.util.Observable;

public class BlankFragmentModel extends ViewModel {
    private Context context;

    public BlankFragmentModel(Context context){
        this.context = context;
    }


    public void sendBroadCast(){
        Intent i = new Intent(context.getString(R.string.broadcast_action));
        i.putExtra("lat", "asdfasdf");
        i.putExtra("lon", "asdfasdf");
        i.putExtra("reset_coord", "asdfasdfasdf");
        LocalBroadcastManager.getInstance(context).sendBroadcast(i);
    }

}
