package org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    /**
     * properties
     */
    private Rectangle rectangle;
    private int cols;
    private int rows;
    private int cellSize = 40;
    private static final int PADDING = 40;

    /**
     * constructor
     */
    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * instantiate rectangle
     * and the properties
     */
    public void init() {
        rectangle = new Rectangle(10, PADDING, cols * cellSize, rows * cellSize);
        rectangle.draw();
        //Picture picture = new Picture(10,10, "background700x700.png");
        //picture.draw();
    }


    /*
    /**
     * return random position

    public Position makeGridPosition() {
        return new Position(this);
    }

    /**
     * return position

    public Position makeGridPosition(int cols, int rows) {
        return new Position(cols, rows, this);
    }
*/
    /**
     * convert rows into pixels
     *
     * @param rows
     * @return
     */
    public int rowToY(int rows) {
        return cellSize * rows + PADDING;
    }

    /**
     * convert cols into pixels
     *
     * @param cols
     * @return
     */
    public int colToX(int cols) {
        return cellSize * cols + 10;
    }

    public int getWidth() {
        return rectangle.getWidth();
    }

    public int getHeight() {
        return rectangle.getHeight();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public int getCellSize() {
        return cellSize;
    }
}
