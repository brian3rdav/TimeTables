package com.example.timetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;


import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ArrayList<String> timesTableArray = new ArrayList<String>();

    //function that update and populates the array based on Seekbar
    public void arrayFiller(int i){


        for(int j=1;j<10;j++){

            timesTableArray.add(Integer.toString(i*j));

            ListView myListView = (ListView) findViewById(R.id.myListView);

            ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableArray);

            myListView.setAdapter(myArrayAdapter);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        SeekBar mySeekBar = (SeekBar) findViewById(R.id.mySeekBar);
        mySeekBar.setMax(20);
        mySeekBar.setProgress(10);


        ListView myListView = (ListView) findViewById(R.id.myListView);

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableArray);

        //populate initial array
        for(int z =1; z<=10;z++) {
            timesTableArray.add(Integer.toString(z));

        }

        myListView.setAdapter(myArrayAdapter);


        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("progress", Integer.toString(i));

                timesTableArray.clear();
                arrayFiller(i);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        int number = 10;









    }
}
