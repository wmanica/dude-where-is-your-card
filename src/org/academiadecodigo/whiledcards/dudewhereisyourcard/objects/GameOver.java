package org.academiadecodigo.whiledcards.dudewhereisyourcard.objects;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.Main;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.*;


public class GameOver extends GameObject implements KeyboardHandler {

    private Position position;
    private Grid grid;
    private Main game;

    public GameOver(Grid grid, String picName) {
        super(0,0, grid, picName);
    }

    public void restart(Main game) {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventRestart = new KeyboardEvent();
        eventRestart.setKey(KeyboardEvent.KEY_SPACE);
        eventRestart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRestart);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        /*if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            game.start();
        }
        */
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
