package com.tpa.maze;

public class Position {

    private int x, y;
    private String track;
    private boolean visited = false;

    public Position(int x, int y, String track){
        this.x = x;
        this.y = y;
        this.track = track; // Guarda o valor do caminho "0 - Parede", "1 - Caminho possível", "2 - Caminho do Backtracking"
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public String getTrack() { return track; }

    public void setTrack(String track) {
        this.track = track;
    }

    public void setVisited(boolean visited) { this.visited = true; }

    public boolean getVisited(){ return visited; }

}
