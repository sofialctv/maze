package com.tpa.maze;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the CSV file containing the maze: ");
        String fileCSV = scanner.nextLine();

        Maze maze = new Maze(fileCSV);

        System.out.println("Number of rows: " + maze.getRows());
        System.out.println("Number of columns: " + maze.getColumns());

    }
}

//import java.util.Stack;
//
//public class DFS {
//    private Maze maze;
//    private boolean[][] visited;
//    private Stack<int[]> path; // Using a stack structure to store the path
//
//    // Possible directions: up, down, left, right and diagonals
//    private int[][] directions = {
//            {-1, 0}, // North
//            {1, 0}, // South
//            {0, -1}, // West
//            {0, 1}, // East
//            {-1, -1}, // Northwest
//            {-1, 1}, // Northeast
//            {1, -1}, // Southwest
//            {1, 1} // Southeast
//    };
//
//    public int[][] solveMaze(Maze maze) {
//        this.maze = maze;
//        this.visited = new boolean[maze.getRows()][maze.getColumns()];
//        this.path = new Stack<>();
//    }
//
//    public boolean resolve(int startX, int startY, int endX, int endY){
//        path.push(new int[]{startX, startY});
//        visited[startX][startY] = true;
//        return dfs(startX, startY, endX, endY);
//    }
//
//    private boolean dfs(int x, int y, int endX, int endY){
//        if (x == endX && y == endY){
//            return true;
//        }
//
//        for (int[] direction : directions) {
//            int newX = x + direction[0];
//            int newY = y + direction[1];
//
//            if (itsValid(newX, newY) && !visited[newX][newY] && maze.getMatriz()[newX][newY] == 1){
//                visited[newX][newY] = true;         // Mark as visited
//                path.push(new int[]{newX, newY});   // Add to path
//
//                if (dfs(newX, newY, endX, endY)){
//                    return true;
//                }
//                path.pop();                 // Backtracking: remove the invalid path
//            }
//        }
//        return false;                           // Can't find the end of the maze from this position
//    }
//
//    private boolean itsValid(int x, int y){
//        return x >= 0 && x < maze.getRows() && y =>  0 && y < maze.getColumns();
//    }
//}

