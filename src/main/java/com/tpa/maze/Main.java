package com.tpa.maze;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the CSV file containing the maze: ");
        String fileCSV = scanner.nextLine();

        Maze maze = new Maze(fileCSV);

        System.out.println(maze.show());

    }
}


