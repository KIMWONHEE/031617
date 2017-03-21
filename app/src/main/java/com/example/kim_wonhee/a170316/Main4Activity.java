package com.example.kim_wonhee.a170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main4Activity extends AppCompatActivity {

    Switch res_start;
    Chronometer time_ing;
    TimePicker res_time;
    DatePicker res_date;
    Button prev, next;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation);
        setTitle("레스토랑 예약시스템");
        init();
    }


    void init() {

        res_start = (Switch)findViewById(R.id.switch1);
        time_ing = (Chronometer)findViewById(R.id.chronometer1);
        res_time = (TimePicker)findViewById(R.id.timePicker);
        res_date = (DatePicker)findViewById(R.id.datePicker);
        prev = (Button)findViewById(R.id.button);
        prev = (Button)findViewById(R.id.button2);
        DatePicker res_date;
        Button prev, next;


        res_start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                }
                else {


                }
            }

        }

        );



    }

    public void onMyClick(View v) {
        if (v.getId() == R.id.switch1) {
//            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//            startActivity(intent);
            starting();
        }
    }



    void starting() {

        long start = System.currentTimeMillis();
        for (int i=0; i<1000000000; i++) {
            ;
        }
        long end = System.currentTimeMillis();
        long nowtime = (end - start)/1000 ;

        time_ing.setText((int) nowtime);


    }

}
