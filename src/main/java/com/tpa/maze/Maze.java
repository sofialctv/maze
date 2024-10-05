package com.tpa.maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private int rows, columns;
    private final ArrayList<ArrayList<String>> labyrinth = new ArrayList<>();

    //TODO Substituir esse array de array por ArrayList
    // # CLASSE MazeSolver #
    //Método que verifica os caminhos possíveis
    //Método que verifica se terminou
    //Método que faz a travessia


    public Maze(String filename) {

        this.readDimensions(filename);

    }

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


    public int getRows() {
        return rows;
    }

    public int getColumns() { return columns; }

    public ArrayList<ArrayList<String>> getLabyrinth() { return labyrinth; }

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
