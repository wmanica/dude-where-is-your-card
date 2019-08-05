package org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.characters;

import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Direction;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.DirectionRandomizable;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Grid;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Position;

public class Guard extends Person implements DirectionRandomizable {

    private Position target;
    private Direction currentDirection;
    private boolean caughtCadet = false;

    public void setTarget(Position target) {
        this.target = target;
    }

    public Guard(Grid grid, String picName, int speed) {
        super(grid, picName, speed);
    }

    public void setCaughtCadet(boolean value) {
        caughtCadet = value;
    }

    public boolean isCaughtCadet() {
        return caughtCadet;
    }

    private Direction decideDirection() {
        if (target.getCol() == getPosition().getCol()) {
            if (getPosition().getRow() > target.getRow()) {
                currentDirection = Direction.UP;
                return currentDirection;
            } else {
                currentDirection = Direction.DOWN;
                return currentDirection;
            }
        }

        if (target.getRow() == getPosition().getRow()) {
            if (getPosition().getCol() > target.getCol()) {
                currentDirection = Direction.LEFT;
                return currentDirection;
            } else {
                currentDirection = Direction.RIGHT;
                return currentDirection;
            }
        }


        if (Math.abs(target.getCol() - getPosition().getCol()) > Math.abs(target.getRow() - getPosition().getRow())) {


            if (getPosition().getRow() > target.getRow()) {
                currentDirection = Direction.UP;
                return currentDirection;
            } else {
                currentDirection = Direction.DOWN;
                return currentDirection;
            }
        } else {
            if (getPosition().getCol() > target.getCol()) {
                currentDirection = Direction.LEFT;
                return currentDirection;
            } else {
                currentDirection = Direction.RIGHT;
                return currentDirection;
            }
        }
    }

    @Override
    public void move() {
        walk(decideDirection(), getSpeed());
    }

    @Override
    public Direction chooseDirection() {
        return null;
    }

    /**
     * Used to increase speed one by one for the Guard
     */
    public void increaseSpeed() {
        setSpeed(getSpeed() + 1);
    }
}
