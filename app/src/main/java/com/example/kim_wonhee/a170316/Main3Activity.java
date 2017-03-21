package com.example.kim_wonhee.a170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    EditText write_ko, write_ma, write_en;
    TextView text_sum, text_avg;
    ImageView image_grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gradecal);
        setTitle("학점 계산기");
        init();
    }

    void init() {

        write_ko = (EditText)findViewById(R.id.editText2);
        write_ma = (EditText)findViewById(R.id.editText3);
        write_en = (EditText)findViewById(R.id.editText4);

        text_sum = (TextView)findViewById(R.id.textView6);
        text_avg = (TextView)findViewById(R.id.textView8);

        image_grade = (ImageView)findViewById(R.id.imageView);

    }


    public void onMyClick(View v) {

        if (v.getId() == R.id.button) {

            int num_ko, num_ma, num_en;

            if (write_ko.getText().toString().equals("")) {
                num_ko = 0;
                write_ko.setText("0");
            }
            else
                num_ko = Integer.parseInt(write_ko.getText().toString());

            if (write_ma.getText().toString().equals("")) {
                num_ma = 0;
                write_ma.setText("0");
            }
            else
                num_ma = Integer.parseInt(write_ma.getText().toString());

            if (write_en.getText().toString().equals("")) {
                num_en = 0;
                write_en.setText("0");
            }
            else
                num_en = Integer.parseInt(write_en.getText().toString());

            int sum = num_ko + num_ma + num_en;
            int avg = sum / 3;

            text_sum.setText(sum+"점");
            text_avg.setText(avg+"점");

            if (avg >= 90) {
                image_grade.setImageResource(R.drawable.a);
            }
            else if (avg >= 80) {
                image_grade.setImageResource(R.drawable.b);
            }
            else if (avg >= 70) {
                image_grade.setImageResource(R.drawable.c);
            }
            else if (avg >= 60) {
                image_grade.setImageResource(R.drawable.d);
            }
            else
                image_grade.setImageResource(R.drawable.f);

        }

        else if (v.getId() == R.id.button2) {

            write_ko.setText("");
            write_ko.setHint("점수 입력");

            write_ma.setText("");
            write_ma.setHint("점수 입력");

            write_en.setText("");
            write_en.setHint("점수 입력");

            text_sum.setText("");
            text_avg.setText("");

            image_grade.setImageResource(0);

            Toast.makeText(getApplicationContext(), "초기화 되었습니다.",Toast.LENGTH_SHORT).show();

        }

    }


}
