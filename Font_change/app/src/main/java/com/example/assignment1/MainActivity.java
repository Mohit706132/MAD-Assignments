package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView e=(TextView) findViewById(R.id.textView);
        EditText e= findViewById(R.id.editTextText);
        EditText e1= findViewById(R.id.editTextText2);
        EditText e2= findViewById(R.id.editTextNumberDecimal);
        Button b1= findViewById(R.id.button);

        Spinner s=findViewById(R.id.spinner);
        String[] rang = {"Select","RED","BlUE","BLACK","DKGRAY","LTGRAY","GREEN","MAGENTA","YELLOW","CYAN"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, rang);
        s.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=e1.getText().toString();
                e.setText(a);

                b = e2.getText().toString();
                e.setTextSize(Float.parseFloat(b));

                String d = s.getSelectedItem().toString();
                e.setTextColor(Color.parseColor(d));
            }
        });
    }
}