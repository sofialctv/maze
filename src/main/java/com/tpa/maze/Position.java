package com.tpa.maze;

public class Position {

    private int x, y, track;

    public Position(int x, int y, int track){
        this.x = x;
        this.y = y;
        this.track = track;
    }

    public int getX() { return x; }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() { return y; }

    public void setY(int y) {
        this.y = y;
    }

    public int getTrack() { return track; }

    public void setTrack(int track) {
        this.track = track;
    }

    public void setVisited(boolean visited) {
    }

}
