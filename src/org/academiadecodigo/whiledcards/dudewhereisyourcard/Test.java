package org.academiadecodigo.whiledcards.dudewhereisyourcard;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Grid;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Position;

public class Test {
    public static void main(String[] args) {

        Grid grid = new Grid(35,35);
        grid.init();

        Position pos = new Position(grid);
        pos.choosePicture("beer1.png");
        pos.show();
    }
}
