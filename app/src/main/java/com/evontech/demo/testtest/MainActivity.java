package com.evontech.demo.testtest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.Person;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.Observable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.evontech.demo.testtest.models.DummyDoodle;
import com.evontech.demo.testtest.models.DummyModel;
import com.evontech.demo.testtest.models.Persons;
import com.evontech.demo.testtest.models.UserComprator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    FrameLayout layout_frame = null;
    private BroadcastReceiver listener = null;
    private Button btnSort = null;
    private final String TAG = getClass().getSimpleName();
    List<Persons> dummyModelList = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_frame = findViewById(R.id.layout_frame);
        btnSort = findViewById(R.id.btnSort);

        initView();
    }


    private void initView(){

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sortData();

            }
        });
    }

    private String getRandomDateString(){
        String day= ""+getRandomNumber(10, 28);
        String month= ""+getRandomNumber(1, 9);
        String year= ""+getRandomNumber(2018, 2019);

        return day+"-"+month+"-"+year;

    }

    private void sortData(){
        for(int i =0; i<100; i++){
            String date_is = getRandomDateString();
//
            try {
                Date date = dateFormat.parse(date_is);

                Log.e("calender date is ",""+date.getTime()+" "+date_is);

                Persons persons = new Persons(date_is, "asdf", 21);
                persons.setCreatedDate(date);
                dummyModelList.add(persons);
            }catch (Exception exp){
                Log.e("parse exception", exp.getLocalizedMessage());
            }
        }

        Collections.sort(dummyModelList);
        // Print out list item after ordering.
        for(Persons ua : dummyModelList)
        {
            System.out.println(ua.toString());
        }

    }


    // Function to sort map by Key
    public void sortbykey(Map<Long ,List<Persons>> map )
    {
        // TreeMap to store values of HashMap
        TreeMap<Long ,List<Persons>> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(map);

        // Display the TreeMap which is naturally sorted

        for (Map.Entry<Long ,List<Persons>> entry : sorted.entrySet())
            try {
            long key = entry.getKey();
                Log.e("ouput ","Key = " +entry.getKey() +
                        ", Value = " + entry.getValue());
            }catch (Exception exp){
            exp.printStackTrace();
            }

    }

    private Date getDate(String datestring){


            try {
                Date date = dateFormat.parse(datestring);
//                System.out.println(date);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }

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


    public int getRandomNumber(int min , int max){

        return new Random().nextInt((max - min) + 1) + min;
    }
}
