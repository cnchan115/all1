package com.example.cherrychan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReadDataActivity extends AppCompatActivity {


    ListView Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        Items = (ListView) findViewById(R.id.Items);

        Items.setAdapter(new ArrayAdapter<String>(ReadDataActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dataelements)));
    }
}
