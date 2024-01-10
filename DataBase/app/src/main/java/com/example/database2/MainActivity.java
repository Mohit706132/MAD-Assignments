package com.example.database2;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog.Builder;
import android.widget.Button;
import android.widget.EditText;
import java.sql.SQLData;
import java.time.chrono.MinguoDate;

public class MainActivity extends Activity implements OnClickListener {
    EditText Name, Div, Roll, Prn;
    Button Insert, Delete, Update, View, ViewAll;
    SQLiteDatabase sql;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.editTextText);
        Div = findViewById(R.id.editTextText2);
        Roll = findViewById(R.id.editTextText3);
        Prn = findViewById(R.id.editTextText4);

        Insert = findViewById(R.id.button);
        Delete = findViewById(R.id.button2);
        Update = findViewById(R.id.button3);
        View = findViewById(R.id.button4);
        ViewAll = findViewById(R.id.button5);

        Insert.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Update.setOnClickListener(this);
        View.setOnClickListener(this);
        ViewAll.setOnClickListener(this);

        sql = openOrCreateDatabase("Student_Data", Context.MODE_PRIVATE, null);
        sql.execSQL("CREATE TABLE IF NOT EXISTS student(Name VARCHAR,Division VARCHAR,Roll_no VARCHAR,PRN VARCHAR);");
    }

    public void onClick(View view) {
        if (view == Insert) {
            if (Name.getText().toString().trim().length() == 0 ||
                    Div.getText().toString().trim().length() == 0 ||
                    Roll.getText().toString().trim().length() == 0 ||
                    Prn.getText().toString().trim().length() == 0) {
                showMessage("ERROR", "Please Enter All Values");
                return;
            }
            sql.execSQL("INSERT INTO student VALUES('" + Name.getText() + " '," + "'" + Div.getText() + "','" + Roll.getText() + "','" + Prn.getText() + "');");
            showMessage("Successfully", "Added All Records");
            clearText();
        }

        if (view == Delete) {
            if (Prn.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please Enter PRN");
                return;
            }
            Cursor c = sql.rawQuery("SELECT * FROM student WHERE PRN='" + Prn.getText() + "'", null);
            if (c.moveToFirst()) {
                sql.execSQL("DELETE FROM student WHERE PRN='" + Prn.getText() + "'");
                showMessage("Success", "Record Deleted");
            } else {
                showMessage("Error", "Invalid PRN");
            }
            clearText();
        }
        if (view == Update) {
            if (Prn.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please Enter PRN");
                return;
            }
            Cursor c = sql.rawQuery("SELECT * FROM student WHERE PRN='" + Prn.getText() + "'", null);
            if (c.moveToFirst()) {
                sql.execSQL("UPDATE student SET Name='" + Name.getText() + "',Division='" + Div.getText() + "',Roll_no ='" + Roll.getText() + "' WHERE PRN='" + Prn.getText() + "'");
                showMessage("Success", "Record Modified");
            } else {
                showMessage("Error", "Invalid PRN");
            }
            clearText();
        }
        // Display a record from the Student table
        if (view == View) {
            // Checking for empty roll number
            if (Prn.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter PRN");
                return;
            }
            Cursor c = sql.rawQuery("SELECT * FROM student WHERE PRN='" + Prn.getText() + "'", null);
            if (c.moveToFirst()) {
                Name.setText(c.getString(0));
                Div.setText(c.getString(1));
                Roll.setText(c.getString(2));
                Prn.setText(c.getString(3));
            } else {
                showMessage("Error", "Invalid PRN");
                clearText();
            }
        }
        // Displaying all the records
        if (view == ViewAll) {
            Cursor c = sql.rawQuery("SELECT * FROM student", null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Name : " + c.getString(0) + "\n");
                buffer.append("Div : " + c.getString(1) + "\n");
                buffer.append("Roll No. : " + c.getString(2) + "\n");
                buffer.append("PRN : " + c.getString(3) + "\n\n");
            }
            showMessage("Student Details", buffer.toString());
        }
    }

    public void showMessage(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText() {
        Name.setText("");
        Div.setText("");
        Roll.setText("");
        Prn.setText("");
        Name.requestFocus();
    }
}