package org.academiadecodigo.whiledcards.dudewhereisyourcard.objects;

import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.*;

public class Card extends GameObject implements Catchable {

    // Attributes from SuperClass
    private Position position;
    private Grid grid;
    // Card attributes
    private boolean caught;


    /**
     * constructor
     *
     * @param grid
     */
    public Card(Grid grid, String picName) {
        super(grid, picName);
    }



    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    // Methods from Interface


    @Override
    public void capture() {
        setCaught();
        getPosition().hide();
        getPosition().setNewPosition();
        getPosition().choosePicture();
        getPosition().show();
        setCaught();
    }

    @Override
    public boolean isCaught() {
        return caught;
    }

    @Override
    public void setCaught() {
        caught = !caught;
    }


}
