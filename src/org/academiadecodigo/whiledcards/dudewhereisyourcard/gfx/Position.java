package org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx;

import org.academiadecodigo.simplegraphics.pictures.*;

public class Position {
    private int col;
    private int row;
    private Grid grid;
    private Picture picture;

    public Position(Grid grid) {
        this.grid = grid;
        col = (int) (Math.random() * grid.getWidth());
        row = (int) (Math.random() * grid.getHeight());
    }

     public Position(int col, int row, Grid grid) {
        this.grid = grid;
        this.col = col;
        this.row = row;
    }

    public void show() {
        picture.draw();
    }

    public void hide() {
        picture.delete();
    }
}
