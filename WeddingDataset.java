package com.example.cherrychan.myapplication;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class WeddingDataset extends Activity {

    LinearLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_dataset);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        XmlResourceParser parser = getResources().getXml(R.xml.weddingdataset);
        try {
            processData (parser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }


    }

    private void processData(XmlResourceParser parser) throws IOException, XmlPullParserException {

        int eventType = -1;
        while (eventType != XmlResourceParser.END_DOCUMENT) {
            if (eventType == XmlResourceParser.START_TAG) {
                String locationValue = parser.getName();
                if (locationValue.equals("record")) {
                    String date = parser.getAttributeValue(null, "date");
                    String district = parser.getAttributeValue(null, "district");
                    String venue = parser.getAttributeValue(null, "venue");
                    printValues (date, district, venue);
                }
            }
            eventType = parser.next();
        }
    }

    private void printValues(String date, String district, String venue) {
        LinearLayout weddingData = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        weddingData.setOrientation(LinearLayout.HORIZONTAL);
        TextView dateText = new TextView (this);
        TextView districtText = new TextView (this);
        TextView venueText = new TextView (this);
        dateText.setLayoutParams(params);
        districtText.setLayoutParams(params);
        venueText.setLayoutParams(params);
        dateText.setText(date);
        districtText.setText(district);
        venueText.setText(venue);
        weddingData.addView(dateText);
        weddingData.addView(districtText);
        weddingData.addView(venueText);
        ll1.addView(weddingData);
    }


}