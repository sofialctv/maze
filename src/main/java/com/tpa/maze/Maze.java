package com.tpa.maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    private int rows, columns;

    public Maze(int row, int column) {

        int[][] labyrinth = new int[row][column];
        for (int i=0; i<labyrinth.length; i++){
            for (int j=0; j<labyrinth[i].length; j++){

            }


        }

    }

    public void readDimensions(String filename){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            this.rows = 0;
            this.columns = 0;


            String fileLine;
            while((fileLine = reader.readLine()) != null) {
                rows++;
                String[] values = fileLine.split(",");
                columns = Math.max(columns, values.length);
            }


            reader.close();


        } catch (IOException e) {
            System.err.println("Error on read file: "+ e.getMessage());
        }
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
