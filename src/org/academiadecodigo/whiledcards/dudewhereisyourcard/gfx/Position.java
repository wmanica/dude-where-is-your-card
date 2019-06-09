package org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.*;

public class Position {
    private int col;
    private int row;
    private Grid grid;
    private Picture picture;

    public Position(Grid grid) {
        this.grid = grid;
        col = (int) (Math.random() * grid.getCols());
        row = (int) (Math.random() * grid.getRows());
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

    public void choosePicture(String picName) {
        int column = grid.colToX(col);
        int rows = grid.rowToY(row);
        picture = new Picture(column, rows, picName);
    }

    public int getCol() {
        return col;
    }
}
