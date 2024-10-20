package com.tpa.maze;
import java.util.Stack;

public class MazeSolver {

    private final Maze maze;
    private final Stack<Position> path = new Stack<>();
    private final static int DELAY = 200; // milliseconds

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

    public boolean solve(MazePanel panel) {
        return solve(0, 0, panel);  // Starts at (0, 0) coordinates
    }

    // Recursive method that explores the maze, marking paths and backtracking when necessary
    private boolean solve(int x, int y, MazePanel panel) {
        // Check if have reached the exit
        if (maze.solved(x, y)) {
            path.add(new Position(x, y, "2"));
            maze.getLabyrinth().get(x).set(y, "2"); // Mark the path in the labyrinth
            panel.updatePanel();
            return true;
        }

        // Mark current position as part of path
        path.add(new Position(x, y, "2"));
        maze.getLabyrinth().get(x).set(y, "2");  // Mark the path in the labyrinth
        panel.updatePanel();
        sleep();

        // Explore possible directions
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (isValid(newX, newY)) {
                if (solve(newX, newY, panel)) {
                    return true;  // Correct path found
                }
            }
        }

        // Backtracking: remove from path if it's a dead end
        path.pop();
        maze.getLabyrinth().get(x).set(y, "3");  // Mark with "3" to indicate that it has already been visited and is not part of the solution
        panel.updatePanel();
        sleep();    // Delay for animation
        return false;
    }

    // Checks if the current position is within bounds and is a valid path.
    private boolean isValid(int x, int y) {
        return x >= 0 && x < maze.getRows() &&
                y >= 0 && y < maze.getColumns() &&
                maze.getLabyrinth().get(x).get(y).equals("1");  // "1" indicates valid path
    }

    private void sleep() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}