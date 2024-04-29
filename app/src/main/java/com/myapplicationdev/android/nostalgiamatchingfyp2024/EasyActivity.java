package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EasyActivity extends AppCompatActivity {
    private ListView listViewPuzzles;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> puzzleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_selection);

        // Initialize the list view and the array adapter
        listViewPuzzles = findViewById(R.id.listViewPuzzles);
        puzzleList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, puzzleList);
        listViewPuzzles.setAdapter(adapter);

        // Add puzzle names to the list
        addPuzzle("Puzzle 1");
        addPuzzle("Puzzle 2");
        addPuzzle("Puzzle 3");
        // Add more puzzles as needed

        // Set click listener for list items
        listViewPuzzles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPuzzle = puzzleList.get(position);
                // Handle puzzle selection here, such as launching the selected puzzle activity
                Toast.makeText(getApplicationContext(), "Selected: " + selectedPuzzle, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to add puzzle names to the list
    private void addPuzzle(String puzzleName) {
        puzzleList.add(puzzleName);
        adapter.notifyDataSetChanged();
    }
}

