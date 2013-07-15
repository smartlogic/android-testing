package com.example;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class PlanetsActivity extends ListActivity {
    String[] listItems = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets); // You have to set a list view for Robolectric to work.

        setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems));
    }
}
