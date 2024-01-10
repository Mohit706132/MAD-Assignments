package com.example.shapes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Creating a Bitmap
            Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);

            //Setting the Bitmap as background for the ImageView
            ImageView i = (ImageView) findViewById(R.id.imageView);
            i.setBackgroundDrawable(new BitmapDrawable(bg));

            //Creating the Canvas Object
            Canvas canvas = new Canvas(bg);

            //Creating the Paint Object and set its color & TextSize
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setTextSize(50);

            //To draw a square
            paint.setColor(Color.MAGENTA);
            canvas.drawText("Square", 100, 120, paint);
            canvas.drawRect(50, 150, 350, 400, paint);

            //to draw oval
            paint.setColor(Color.YELLOW);
            canvas.drawText("Oval", 500, 120, paint);
            canvas.drawOval(450, 150, 650, 400, paint);

            //to draw a line
            paint.setColor(Color.CYAN);
            canvas.drawText("Line", 300, 550, paint);
            canvas.drawLine(50, 600, 650, 600, paint);

            //to draw a rectangle
            paint.setColor(Color.RED);
            canvas.drawText("Rectangle", 250, 700, paint);
            canvas.drawRect(100, 750, 625, 900, paint);

            //to draw a circle
            paint.setColor(Color.BLUE);
            canvas.drawText("Circle", 100, 975, paint);
            canvas.drawCircle(150, 1125, 120, paint);

            //to draw a Triangle
            paint.setColor(Color.MAGENTA);
            canvas.drawText("Triangle",500 , 1200, paint);
            canvas.drawLine(550, 925, 320,1200, paint);
            canvas.drawLine(320,1200,400,1250,paint);
            canvas.drawLine(400,1250,550,925,paint);

        }
    }
}