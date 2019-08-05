package org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.characters;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Direction;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Grid;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.GameObject;

public abstract class Person extends GameObject {

    private int speed;
    private Direction currentDirection;

    /** constructor
     *
     * @param grid
     */


    public Person(Grid grid, String picName, int speed) {
        super(grid, picName);
        this.speed = speed;
    }

    public abstract void move();


    public void walk(Direction direction, int speed) {
        for (int i = 0; i < speed; i++) {
            getPosition().moveInDirection(direction, 1);
        }
    }


    public int getSpeed() {
        return speed;
    }

    /**
     * Used to set Guard speed after getting N cards
     * Especially to return to the original value
     * @param speed
     * @return
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }



}
