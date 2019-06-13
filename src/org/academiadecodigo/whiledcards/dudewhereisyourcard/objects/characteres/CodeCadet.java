package org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.characteres;

import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Direction;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Grid;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.Beer;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.Catchable;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.GameObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodeCadet extends Person implements Catchable, KeyboardHandler {

    // Game Objects Attributes: position, grid | Methods: getPosition, setGrid
    // Person Attributes: speed,  currentDirection,  picture | Methods: move

    // CodeCadet Attributes

    private boolean drunk;
    private boolean caught;
    private int movementCounter = -1;
    private Direction[] array = {Direction.LEFT, Direction.RIGHT, Direction.UP, Direction.UP};
    private List<Direction> shuffledKeys;

    // Constructor
    public CodeCadet(Grid grid, String picName, int speed) {
        super(grid, picName, speed);
    }

    // Methods
    public void setDrunk() {
        drunk = !drunk;
    }

    public boolean isDrunk() {
        return drunk;
    }

    public int getMovementCounter() {
        return movementCounter;
    }

    /**
     * Used to reset movement counter to become sober again whenever needed
     */
    public void resetMovementCounter() {
        movementCounter = -1;
    }

    @Override
    public void capture() {
    }


    private List<Direction> keyRandomizer() {
        List<Direction> arrayList = Arrays.asList(Direction.values());
        Collections.shuffle(arrayList);
        return arrayList;
    }


    @Override
    public void move() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (movementCounter == 70) {
            setDrunk();
            movementCounter = -1;
        }
        if (isDrunk() == true && movementCounter == -1) {
            shuffledKeys = keyRandomizer();
        }
        if (!isDrunk()) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                super.walk(Direction.LEFT, super.getSpeed());
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                super.walk(Direction.RIGHT, super.getSpeed());

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                super.walk(Direction.UP, super.getSpeed());

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                super.walk(Direction.DOWN, super.getSpeed());

            }
        }
        if (isDrunk() == true) {
            movementCounter++;
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                super.walk(shuffledKeys.get(0), super.getSpeed());
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                super.walk(shuffledKeys.get(1), super.getSpeed());

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                super.walk(shuffledKeys.get(2), super.getSpeed());

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                super.walk(shuffledKeys.get(3), super.getSpeed());
            }

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    // Catchable methods
    @Override
    public boolean isCaught() {
        return caught;
    }

    @Override
    public void setCaught() {
        caught = true;
    }
}
