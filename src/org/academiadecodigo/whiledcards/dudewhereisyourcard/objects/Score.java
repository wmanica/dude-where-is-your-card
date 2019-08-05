package org.academiadecodigo.whiledcards.dudewhereisyourcard.objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Grid;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Position;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.characters.CodeCadet;

public class Score {

    private String msg;
    private Grid grid;
    private int beer = 0;
    private int card = 0;
    private boolean cadetDrunk = false;

    Text scoreText;


    public Score(){


        scoreText = new Text(650, 15, printScore());
        scoreText.setColor(Color.DARK_GRAY);
        scoreText.draw();
        scoreText.grow(40, 15);
        scoreText.setText(printScore());


    }

    public void update(int beer, int card, boolean cadetDrunk){
       setBeer(beer);
       setCadetDrunk(cadetDrunk);
       setCard(card);
       scoreText.setText(printScore());
    }

    public String printScore(){

        return "Cards: " + getCard() + "  ||  " + "Beers: " + getBeer() + "  ||  " + "Drunk Mode: " + getDrunkMode();


    }

    public String getDrunkMode(){

        if(cadetDrunk){
            return " LITROSA!!!";

        } else {

            return " THIRSTY ";
        }


    }

    public void setBeer(int beer) {
        this.beer = beer;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public void setCadetDrunk(boolean cadetDrunk) {
        this.cadetDrunk = cadetDrunk;
    }

    public int getBeer() {
        return beer;
    }

    public int getCard() {
        return card;
    }

    public boolean isCadetDrunk() {
        return cadetDrunk;
    }
}
