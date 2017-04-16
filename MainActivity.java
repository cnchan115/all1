package com.example.cherrychan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ImageButton myImageButton;

    Button GoToSubmitActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageButton = (ImageButton) findViewById(R.id.btn1);

        myImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentLoadNewActivity = new Intent(MainActivity.this, InesWeddingReservation.class);
                startActivity(intentLoadNewActivity);
            }
        });

        GoToSubmitActivity = (Button)findViewById(R.id.btn_submit);

        GoToSubmitActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.

                Intent intent = new Intent(MainActivity.this, LeungReservation.class);
                startActivity(intent);

            }
        });

    }
}
