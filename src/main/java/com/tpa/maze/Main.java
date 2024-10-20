package com.tpa.maze;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the CSV file containing the maze: ");
        String fileCSV = scanner.nextLine();

        Maze maze = new Maze(fileCSV);
        MazeSolver solver = new MazeSolver(maze);

        // Starts the graphical interface
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Solver");
            MazePanel mazePanel = new MazePanel(maze);
            frame.add(mazePanel);
            frame.setSize(800, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        // Solve the maze with animation
            new Thread(() -> {
                if (solver.solve(mazePanel)) {
                    System.out.println("Solution found!");
                } else {
                    System.out.println("\nOH NO :(\nCould not find a valid path. Labyrinth with no way out!");
                }
                System.out.println(maze.show());
            }).start();
        });
    }
}