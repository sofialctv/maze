package com.tpa.maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private int rows, columns;
    private final ArrayList<ArrayList<String>> labyrinth = new ArrayList<>();

    public Maze(String filename) {
        this.readDimensions(filename);
    }

    // Reads the CSV file and constructs the grid of the maze
    private void readDimensions(String filename){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            this.rows = 0;
            this.columns = 0;

            String fileLine;
            while((fileLine = reader.readLine()) != null) {
                rows++;
                String[] values = fileLine.split(",");
                labyrinth.add(new ArrayList<>(Arrays.asList(values)));
                columns = Math.max(columns, values.length);
            }

            reader.close();

        } catch (IOException e) {
            System.err.println("Error on read file: "+ e.getMessage());
        }
    }
    // Checks if the current position corresponds to the maze exit
    public boolean solved(int row, int col) {
        return (row == getRows()-1 && col == getColumns()-1);
    }

    public int getRows() { return rows; }

    public int getColumns() { return columns; }

    public ArrayList<ArrayList<String>> getLabyrinth() { return labyrinth; }

    // Returns a string representation of the maze
    public String show(){

        String result = "";

        for(ArrayList<String> row : labyrinth){
            for(String value : row){
                result += value + " ";
            }
            result += "\n";
        }
        return result;
    }
}
