package com.example.cartonlogintest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecListActivity extends AppCompatActivity{

    ArrayList<Item> pantry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView listRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        pantry = Item.createPantryList(20);

        ListAdapter adapter = new ListAdapter(pantry);

        listRecyclerView.setAdapter(adapter);
        listRecyclerView.setLayoutManager(layoutManager);
    }
}
