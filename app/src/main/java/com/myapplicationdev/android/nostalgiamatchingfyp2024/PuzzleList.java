package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import java.util.ArrayList;

public class PuzzleList {

    private ArrayList<String> puzzles;

    public PuzzleList() {
        puzzles = new ArrayList<>();
        // Initialize with some default puzzles
        puzzles.add("Puzzle 1");
        puzzles.add("Puzzle 2");
        puzzles.add("Puzzle 3");
        puzzles.add("Puzzle 4");
        puzzles.add("Puzzle 5");
        puzzles.add("Puzzle 6");
        puzzles.add("Puzzle 7");
        puzzles.add("Puzzle 8");
        // Add more puzzles as needed
    }

    // Method to add a puzzle to the list
    public void addPuzzle(String puzzleName) {
        puzzles.add(puzzleName);
    }

    // Method to remove a puzzle from the list
    public void removePuzzle(String puzzleName) {
        puzzles.remove(puzzleName);
    }

    // Method to get the list of puzzles
    public ArrayList<String> getPuzzles() {
        return puzzles;
    }

    // Method to check if the list contains a puzzle
    public boolean containsPuzzle(String puzzleName) {
        return puzzles.contains(puzzleName);
    }
}
