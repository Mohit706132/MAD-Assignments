package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

        @SuppressLint("SetTextI18n")
        public void add(View view)
        {
            EditText e1= findViewById(R.id.editTextNumber);
            EditText e2= findViewById(R.id.editTextNumber2);
            EditText e3= findViewById(R.id.editTextNumber3);
            int n1=Integer.parseInt(e1.getText().toString());
            int n2=Integer.parseInt(e2.getText().toString());
            int n=n1+n2;
            e3.setText(Integer.toString(n));
        }

    @SuppressLint("SetTextI18n")
    public void Div(View view)
    {
        EditText e1= findViewById(R.id.editTextNumber);
        EditText e2= findViewById(R.id.editTextNumber2);
        EditText e3= findViewById(R.id.editTextNumber3);

        int n1=Integer.parseInt(e1.getText().toString());
        int n2=Integer.parseInt(e2.getText().toString());
        int n=n1/n2;
        e3.setText(Integer.toString(n));
    }

@SuppressLint("SetTextI18n")
public void Sub(View view)
        {
        EditText e1= findViewById(R.id.editTextNumber);
        EditText e2= findViewById(R.id.editTextNumber2);
        EditText e3= findViewById(R.id.editTextNumber3);

        int n1=Integer.parseInt(e1.getText().toString());
        int n2=Integer.parseInt(e2.getText().toString());
        int n=n1-n2;
        e3.setText(Integer.toString(n));
        }

@SuppressLint("SetTextI18n")
public void Mul(View view)
        {
        EditText e1= findViewById(R.id.editTextNumber);
        EditText e2= findViewById(R.id.editTextNumber2);
        EditText e3= findViewById(R.id.editTextNumber3);

        int n1=Integer.parseInt(e1.getText().toString());
        int n2=Integer.parseInt(e2.getText().toString());
        int n=n1*n2;
        e3.setText(Integer.toString(n));
        }
}

