package com.example.prninput;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText e1= findViewById(R.id.editTextText_2);
        EditText e2= findViewById(R.id.editTextText2_2);
        EditText e3= findViewById(R.id.editTextText3_2);
        EditText e4= findViewById(R.id.editTextText4_2);
        EditText e5= findViewById(R.id.editTextText5_2);
        EditText e6= findViewById(R.id._2);
        Intent i=getIntent();

        String name1= i.getStringExtra("NAME");
        e1.setText(name1);

        String year1= i.getStringExtra("YEAR");
        e2.setText(year1);

        String DIV1= i.getStringExtra("DIV");
        e3.setText(DIV1);

        String ROLL1= i.getStringExtra("ROLL");
        e4.setText(ROLL1);

        String PRN1= i.getStringExtra("PRN");
        e5.setText(PRN1);

        String BRANCH1= i.getStringExtra("BRANCH");
        e6.setText(BRANCH1);
    }
}