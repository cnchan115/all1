package com.example.cherrychan.myapplication;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class XmlParser extends Activity {

    LinearLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parser);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        XmlResourceParser parser = getResources().getXml(R.xml.weather);
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
                if (locationValue.equals("location")) {
                    String city = parser.getAttributeValue(null, "city");
                    String temperature = parser.getAttributeValue(null, "temperature");
                    String weather = parser.getAttributeValue(null, "weather");
                    printValues (city, temperature, weather);
                }
            }
            eventType = parser.next();
        }
    }

    private void printValues(String city, String temperature, String weather) {
        LinearLayout weatherData = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        weatherData.setOrientation(LinearLayout.HORIZONTAL);
        TextView cityText = new TextView (this);
        TextView temperatureText = new TextView (this);
        TextView weatherText = new TextView (this);
        cityText.setLayoutParams(params);
        temperatureText.setLayoutParams(params);
        weatherText.setLayoutParams(params);
        cityText.setText(city);
        temperatureText.setText(temperature);
        weatherText.setText(weather);
        weatherData.addView(cityText);
        weatherData.addView(temperatureText);
        weatherData.addView(weatherText);
        ll1.addView(weatherData);
    }


}