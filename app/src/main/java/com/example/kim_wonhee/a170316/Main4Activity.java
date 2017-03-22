package com.example.kim_wonhee.a170316;

import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main4Activity extends AppCompatActivity {

    Switch res_start;
    Chronometer time_ing;
    TimePicker twopage;
    DatePicker onepage;
    GridLayout threepage, fourpage;
    Button prev, next;
    TextView date, time, adultnum, adolenum, childnum;
    EditText write_adultnum, write_adolenum, write_childnum;
    int pagenum;

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
        onepage = (DatePicker)findViewById(R.id.datePicker);
        twopage = (TimePicker)findViewById(R.id.timePicker);
        threepage = (GridLayout)findViewById(R.id.peoplenum);
        fourpage = (GridLayout)findViewById(R.id.result);
        prev = (Button)findViewById(R.id.button);
        next = (Button)findViewById(R.id.button2);
        date = (TextView)findViewById(R.id.textView8);
        time = (TextView)findViewById(R.id.textView10);
        adultnum = (TextView)findViewById(R.id.textView12);
        adolenum = (TextView)findViewById(R.id.textView14);
        childnum = (TextView)findViewById(R.id.textView16);
        write_adultnum = (EditText)findViewById(R.id.editText);
        write_adolenum = (EditText)findViewById(R.id.editText2);
        write_childnum = (EditText)findViewById(R.id.editText3);

        res_start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    time_ing.setVisibility(View.VISIBLE);
                    time_ing.start();
                    pagenum = 1;
                    pageChange();
                }
                else {
                    time_ing.setVisibility(View.INVISIBLE);
                    onepage.setVisibility(View.INVISIBLE);
                    twopage.setVisibility(View.INVISIBLE);
                    threepage.setVisibility(View.INVISIBLE);
                    fourpage.setVisibility(View.INVISIBLE);
                    prev.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.INVISIBLE);
                    time_ing.stop();
                    time_ing.setBase(SystemClock.elapsedRealtime());
                }
            }
        }
        );

    }

    void pageChange() {

        if (pagenum == 1) {
            onepage.setVisibility(View.VISIBLE);
            twopage.setVisibility(View.INVISIBLE);
            threepage.setVisibility(View.INVISIBLE);
            fourpage.setVisibility(View.INVISIBLE);
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);

            prev.setEnabled(false);
        }
        else if (pagenum == 2) {
            onepage.setVisibility(View.INVISIBLE);
            twopage.setVisibility(View.VISIBLE);
            threepage.setVisibility(View.INVISIBLE);
            fourpage.setVisibility(View.INVISIBLE);
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);

            prev.setEnabled(true);
        }
        else if (pagenum == 3) {
            onepage.setVisibility(View.INVISIBLE);
            twopage.setVisibility(View.INVISIBLE);
            threepage.setVisibility(View.VISIBLE);
            fourpage.setVisibility(View.INVISIBLE);
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);

            next.setEnabled(true);
        }
        else if (pagenum == 4) {
            onepage.setVisibility(View.INVISIBLE);
            twopage.setVisibility(View.INVISIBLE);
            threepage.setVisibility(View.INVISIBLE);
            fourpage.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);

            next.setEnabled(false);

            int year = onepage.getYear();
            int month = onepage.getMonth() + 1;
            int day = onepage.getDayOfMonth();

            date.setText(year + "년 " + month + "월 " + day + "일" );

            int hour = twopage.getHour();
            int min = twopage.getMinute();

            time.setText(hour + "시 " + min + "분");

            String adult = write_adultnum.getText().toString();
            String adole = write_adolenum.getText().toString();
            String child = write_childnum.getText().toString();

            int adult_num = Integer.parseInt(adult);
            int adole_num = Integer.parseInt(adole);
            int chile_num = Integer.parseInt(child);

            adultnum.setText(adult_num + "명");
            adolenum.setText(adole_num + "명");
            childnum.setText(chile_num + "명");
        }

    }

    public void onMyClick(View v) {
        if (v.getId() == R.id.button) {
            if (pagenum > 1)
                --pagenum;
            pageChange();
        }
        else if (v.getId() == R.id.button2) {
            if (pagenum < 4)
                ++pagenum;
            pageChange();
        }

    }

}
