package com.tpa.maze;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

    private final Maze maze;
    private static final int CELL_SIZE = 15;  // Size of each cell in the maze

    public MazePanel(Maze maze) {
        this.maze = maze;
        setPreferredSize(new Dimension(maze.getColumns() * CELL_SIZE, maze.getRows() * CELL_SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < maze.getRows(); row++) {
            for (int col = 0; col < maze.getColumns(); col++) {
                String cell = maze.getLabyrinth().get(row).get(col);
                switch (cell) {
                    case "0": // Wall
                        g.setColor(Color.BLACK);
                        break;
                    case "1": // Possible path
                        g.setColor(Color.WHITE);
                        break;
                    case "2": // Solution path
                        g.setColor(Color.GREEN);
                        break;
                    case "3": // Backtracking
                        g.setColor(Color.RED);
                        break;
                }
                g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.GRAY);
                g.drawRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    // Update the panel
    public void updatePanel() {
        repaint();
    }
}
