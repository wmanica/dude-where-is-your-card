package org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.characteres;

import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Direction;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.DirectionRandomizable;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Grid;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.Catchable;

public class Friend extends Person implements Catchable, DirectionRandomizable {

    private boolean caught;
    private Direction currentDirection;
    private int directionChangeLevel = 5;


    public Friend(Grid grid, String picName, int speed) {
        super(grid, picName, speed);
        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
    }

    @Override
    public Direction chooseDirection() {

        Direction newDirection = currentDirection;

        // Randomly change directions sometimes
        if (Math.random() > ((double) directionChangeLevel) / 10) {
            newDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        }

        currentDirection = newDirection;

        return newDirection;

    }

    public boolean isHittingWall() {

        switch (currentDirection) {
            case LEFT:
                if (getPosition().getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (getPosition().getCol() == getGrid().getCols() - 1) {
                    return true;
                }
                break;
            case UP:
                if (getPosition().getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (getPosition().getRow() == getGrid().getRows() - 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    @Override
    public void walk(Direction direction, int speed) {

        Direction newDirection = direction;

        if (isHittingWall()) {
            newDirection = direction.oppositeDirection();
        }

        currentDirection = newDirection;

        for (int i = 0; i < speed; i++) {
            getPosition().moveInDirection(currentDirection, 1);
        }
    }

    @Override
    public void capture(){}

    @Override
    public void move() {
        walk(chooseDirection(), getSpeed());
    }

    @Override
    public boolean isCaught() {
        return caught;
    }

    @Override
    public void setCaught() {
        this.caught = !caught;
    }
}
