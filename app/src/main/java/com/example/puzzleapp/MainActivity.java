package com.example.puzzleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton blank;
    ImageButton[] b = new ImageButton[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b[0] = (ImageButton) findViewById(R.id.button0);
        b[1] = (ImageButton) findViewById(R.id.button1);
        b[2] = (ImageButton) findViewById(R.id.button2);
        b[3] = (ImageButton) findViewById(R.id.button3);
        b[4] = (ImageButton) findViewById(R.id.button4);
        b[5] = (ImageButton) findViewById(R.id.button5);
        b[6] = (ImageButton) findViewById(R.id.button6);
        b[7] = (ImageButton) findViewById(R.id.button7);
        b[8] = (ImageButton) findViewById(R.id.button8);

        blank = b[8];

        for(int i = 0; i < 9; i++){
            b[i].setTag(i);
            b[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable value = ((ImageButton)v).getBackground();
                    blank.setBackground(value);
                    ((ImageButton) v).setBackgroundColor(Color.BLACK);
                    blank = b[(Integer) ((ImageButton) v).getTag()];
                    updateClickable((int) ((ImageButton)v).getTag());
                }
            });
        }

        b[0].setClickable(false);
        b[1].setClickable(false);
        b[2].setClickable(false);
        b[3].setClickable(false);
        b[4].setClickable(false);
        b[5].setClickable(false);
        b[6].setClickable(false);
        b[7].setClickable(false);
        b[8].setClickable(false);
    }


    public void updateClickable(int buttonClicked){
        for(int i = 0; i < 9; i++){
            b[i].setClickable(false);
        }

        switch(buttonClicked){
            case 0:
                b[1].setClickable(true);
                b[3].setClickable(true);
                break;
            case 1:
                b[0].setClickable(true);
                b[2].setClickable(true);
                b[4].setClickable(true);
                break;
            case 2:
                b[5].setClickable(true);
                b[7].setClickable(true);
                break;

            default:
                break;

        }
    }
}