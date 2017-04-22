package com.example.cherrychan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton myImageButton;

    Button GoToSubmitActivity;

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageButton = (ImageButton) findViewById(R.id.btn1);

        myImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentLoadNewActivity = new Intent(MainActivity.this, ReadDataActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        text = (TextView) findViewById(R.id.textView);

        text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, XmlParser.class);
                startActivity(intent);
            }
        });

        GoToSubmitActivity = (Button)findViewById(R.id.btn_submit);

        GoToSubmitActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.

                Intent intent = new Intent(MainActivity.this, MrRightReservation.class);
                startActivity(intent);

            }
        });

    }
}
