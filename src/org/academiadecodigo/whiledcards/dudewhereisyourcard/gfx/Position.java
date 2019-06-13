package org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx;

import org.academiadecodigo.simplegraphics.pictures.*;

public class Position {
    private int col;
    private int row;
    private Grid grid;
    private Picture picture;
    private String picName;

    public Position(Grid grid, String picName) {
        this.grid = grid;
        this.picName = picName;
        col = (int) (Math.random() * grid.getCols());
        row = (int) (Math.random() * grid.getRows());
        choosePicture();
        show();
    }

     public Position(int col, int row, Grid grid, String picName) {
        this.picName = picName;
        this.grid = grid;
        this.col = col;
        this.row = row;
        choosePicture();
        show();
    }

    public void show() {
        picture.draw();
    }

    public void hide() {
        picture.delete();
    }

    public void choosePicture() {
        int column = grid.colToX(col);
        int rows = grid.rowToY(row);
        picture = new Picture(column, rows, picName);
    }


    /** switch for directions
     *
     * @param direction
     * @param distance
     */
    public void moveInDirection(Direction direction, int distance) {

        int oldCol = getCol();
        int oldRow = getRow();

        switch (direction) {

            case UP:
                moveUp(distance);
                break;

            case DOWN:
                moveDown(distance);
                break;

            case LEFT:
                moveLeft(distance);
                break;

            case RIGHT:
                moveRight(distance);
                break;

        }

        int newCol = getCol();
        int newRow = getRow();
        int difX = grid.colToX(newCol) - grid.colToX(oldCol);
        int difY = grid.rowToY(newRow) - grid.rowToY(oldRow);

        picture.translate(difX, difY);

    }


    /**Moves
     *
     * @param distance
     */
    public void moveUp(int distance) {
        int maxRowsUp = distance < getRow() ? distance : getRow();
        setRow(getRow() - maxRowsUp);
    }

    public void moveDown(int distance) {
        int maxRowsDown = distance > grid.getRows() - (getRow() + 1) ? grid.getRows() - (getRow() + 1) : distance;
        setRow(getRow() + maxRowsDown);
    }

    public void moveLeft(int distance) {
        int maxRowsLeft = distance < getCol() ? distance : getCol();
        setCol(getCol() - maxRowsLeft);
    }

    public void moveRight(int distance) {
        int maxRowsRight = distance > grid.getCols() - (getCol() + 1) ? grid.getCols() - (getCol() + 1) : distance;
        setCol(getCol() + maxRowsRight);
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setNewPosition(){
        col = (int) (Math.random() * grid.getCols());
        row = (int) (Math.random() * grid.getRows());
    }
}
