package com.example.prninput;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner);
//create a list of items for the spinner.
        String[] items = new String[]{"Select","CS", "CS(AI)", "CS(AI & ML)", "IT","Chemical","Mechanical","Civil"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        EditText e1= findViewById(R.id.editTextText);
        EditText e2= findViewById(R.id.editTextText2);
        EditText e3= findViewById(R.id.editTextText3);
        EditText e4= findViewById(R.id.editTextText4);
        EditText e5= findViewById(R.id.editTextText5);
//        Spinner s= findViewById(R.id.spinner);
        Button b= findViewById(R.id.button);
        b.setOnClickListener(view -> {

            Intent i=new Intent(MainActivity.this,MainActivity2.class);
            String name=e1.getText().toString();
            i.putExtra("NAME",name);

            String year=e2.getText().toString();
            i.putExtra("YEAR",year);

            String div=e3.getText().toString();
            i.putExtra("DIV",div);

            String roll=e4.getText().toString();
            i.putExtra("ROLL",roll);

            String prn=e5.getText().toString();
            i.putExtra("PRN",prn);

            String bran;
            bran = dropdown.getSelectedItem().toString();
            i.putExtra("BRANCH",bran);
            startActivity(i);
                }
        );
    }
}