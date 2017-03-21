package com.example.kim_wonhee.a170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("실습03.");

    }

    public void onMyClick(View v) {
        if (v.getId() == R.id.button) {
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.button2) {
            Intent intent = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.button3) {
            Intent intent = new Intent(MainActivity.this,Main4Activity.class);
            startActivity(intent);
        }
    }

}
