package com.tpa.maze;

// # CLASSE MazeSolver #
//Mét.odo que verifica os caminhos possíveis
//Mét.odo que verifica se terminou
//Mét.odo que faz a travessia

import java.util.Stack;

public class MazeSolver {

    private final Maze maze;
    private Stack<Position> path = new Stack<>();

    // Using Anticlockwise directions
    private static final int[][] directions = {
            {-1, 0},    // North
            {-1, 1},    // Northeast
            {0, 1},     // East
            {1, 1},     // Southeast
            {1, 0},     // South
            {1, -1},    // Southwest
            {0, -1},    // West
            {-1, -1}    // Northwest
    };

    public MazeSolver(Maze maze){
        this.maze = maze;
    }

    public boolean solve() {
        return solve(0, 0);  // Começa no ponto (0, 0)
    }

    private boolean solve(int x, int y) {
        // Verifica se chegou à saída
        if (maze.solved(x, y)) {
            path.add(new Position(x, y, "2"));
            maze.getLabyrinth().get(x).set(y, "2");// Marca o caminho no labirinto
            return true;
        }

        // Marca posição atual como parte do caminho
        path.add(new Position(x, y, "2"));
        maze.getLabyrinth().get(x).set(y, "2");  // Marca o caminho no labirinto

        // Explora as direções possíveis
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (isValid(newX, newY)) {
                if (solve(newX, newY)) {
                    return true;  // Caminho correto encontrado
                }
            }
        }

        // Backtracking: remove do caminho se for um caminho sem saída
        path.pop();
        maze.getLabyrinth().get(x).set(y, "3");  // Marca com "3" para indicar que já foi visitado e não faz parte da solução
        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < maze.getRows() &&
                y >= 0 && y < maze.getColumns() &&
                maze.getLabyrinth().get(x).get(y).equals("1");  // "1" indica caminho válido
    }

    public Stack<Position> getPath() {
        return path;
    }

//    public void setPath(Stack<Position> path) {
//        this.path = path;
//    }

    public static int[][] getDirections() {
        return directions;
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
//
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


//public class Maze {
//    private final int cols, rows;   // dimension of maze
//    private boolean[][] north;      // is there a wall to north of cell (col, row)
//    private boolean[][] east;
//    private boolean[][] south;
//    private boolean[][] west;
//    private boolean[][] visited;
//    private boolean isDone = false;
//
//    public Maze(int cols, int rows) {
//        this.cols = cols;
//        this.rows = rows;
//        int height = 800;
//        int width = (int) Math.round(1.0 * height * cols / rows);
//        StdDraw.setCanvasSize(width, height);
//
//        StdDraw.setXscale(0, cols + 2);
//        StdDraw.setYscale(0, rows + 2);
//        init();
//        generate();
//    }
//
//    https://algs4.cs.princeton.edu/41graph/Maze.java.html