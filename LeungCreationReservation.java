package com.example.cherrychan.myapplication;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class LeungCreationReservation extends AppCompatActivity {

    Button myButton;
    private PopupWindow myPopUp;
    private RelativeLayout positionOfPopup;


    Button GoToLeungReservationActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leung_creation_reservation);

        ImageView myImageView = (ImageView) findViewById(R.id.leung_logo);
        myImageView.setImageResource(R.drawable.leung_logo);


        myButton = (Button) findViewById(R.id.btn_submit);
        positionOfPopup = (RelativeLayout) findViewById(R.id.popUp_position);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View customview = inflater.inflate(R.layout.popup_layout, null);

                myPopUp = new PopupWindow(
                        customview,
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

                ImageButton closePopUp = (ImageButton) customview.findViewById(R.id.close);
                closePopUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myPopUp.dismiss(); //It will close the popup window.
                    }
                });

                myPopUp.showAtLocation(positionOfPopup, Gravity.CENTER, 0, 0);

            }
        });

        GoToLeungReservationActivity = (Button)findViewById(R.id.btn_reset);

        GoToLeungReservationActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.

                Intent intent = new Intent(LeungCreationReservation.this, LeungCreationReservation.class);
                startActivity(intent);

            }
        });
    }
}
