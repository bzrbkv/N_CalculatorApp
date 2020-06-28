package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NUMBER = "com.example.calculator.EXTRA_NUMBER";
    EditText num1, num2;
    Button plus, minus, divide, multiply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.number1);
        num2 = (EditText) findViewById(R.id.number2);

        plus = (Button) findViewById(R.id.plus_id);
        minus = (Button) findViewById(R.id.minus_id);
        divide = (Button) findViewById(R.id.divide_id);
        multiply = (Button) findViewById(R.id.multiply_id);

        plus.setOnClickListener((View.OnClickListener) this);
        minus.setOnClickListener((View.OnClickListener) this);
        multiply.setOnClickListener((View.OnClickListener) this);
        divide.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v) {

        int n1,n2;
        float result=0;

        if ((TextUtils.isEmpty(num1.getText().toString())
                || TextUtils.isEmpty(num2.getText().toString())) ) {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_SHORT).show();
            return;
        }


        n1 = Integer.parseInt(num1.getText().toString());
        n2 = Integer.parseInt(num2.getText().toString());

        switch (v.getId()) {
            case R.id.plus_id:
                result = n1 + n2;
                break;
            case R.id.minus_id:
                result = n1 - n2;
                break;
            case R.id.multiply_id:
                result = n1 * n2;
                break;
            case R.id.divide_id:
                if(n2 == 0){
                    Toast.makeText(getApplicationContext(),"Division by zero is undefined",Toast.LENGTH_SHORT).show();
                    return;
                }
                result = n1 / n2;
                break;
            default:
                break;
        }
        openActivity2(result);
    }

    private void openActivity2(float res) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra(EXTRA_NUMBER, res);
        startActivity(i);
    }
}