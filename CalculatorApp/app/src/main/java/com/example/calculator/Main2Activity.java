package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // Intent intent = getIntent();
        float r = getIntent().getFloatExtra(MainActivity.EXTRA_NUMBER,6);
        displayMessage(r);

    }

    private void displayMessage(float message) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(""+message);
    }

}
