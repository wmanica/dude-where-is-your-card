package org.academiadecodigo.whiledcards.dudewhereisyourcard.objects;

import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Grid;

public class Beer extends GameObject implements Catchable {

    private boolean caught;

    /**
     * constructor
     *
     * @param grid
     */
    public Beer(Grid grid, String picName) {
        super(grid, picName);
    }

    public void revive(){
        setCaught();
        getPosition().show();
    }

    @Override
    public void capture(){
        setCaught();
        getPosition().hide();
        getPosition().setNewPosition();
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
