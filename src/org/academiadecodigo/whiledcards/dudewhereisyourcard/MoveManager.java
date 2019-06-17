package org.academiadecodigo.whiledcards.dudewhereisyourcard;

import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.Beer;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.Card;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.GameObject;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx.Position;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.characters.CodeCadet;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.characters.Friend;
import org.academiadecodigo.whiledcards.dudewhereisyourcard.objects.characters.Guard;

public class MoveManager {
    private GameObject[] gameObjects;
    private Position cadetPosition;
    private int cadetMoves;
    private Position friendPosition;
    private Guard managerGuard;
    private Friend managerFriend;
    private CodeCadet managerCadet;

    public MoveManager(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void manage() {

        for (GameObject o : gameObjects) {

            if (o instanceof CodeCadet) {
                managerCadet = ((CodeCadet) o);
                cadetPosition = o.getPosition();
                if(!managerCadet.isDrunk()){
                    cadetMoves=cadetMoves + ((CodeCadet) o).sendmove();
                }

                checkCadet(o);

            } else if (o instanceof Guard) {
                managerGuard = ((Guard) o);
                if(managerFriend.isCaught()){
                    managerGuard.setTarget(cadetPosition);
                }else{
                    managerGuard.setTarget(friendPosition);
                }
                checkGuard(o);
            }else if(o instanceof Beer){
                if(cadetMoves==30 && !managerCadet.isDrunk()){
                    ((Beer) o).refill();
                    ((Beer) o).setCaught(false);

                }
            }else if(o instanceof Friend){
                friendPosition = o.getPosition();
                managerFriend = ((Friend) o);
            }
        }


    }


    /**
     * Checks for collisions with specific gameObject
     * Requires iterating the array once
     *
     * @param
     */

    private void checkGuard(GameObject guard) {
        for (GameObject ig : gameObjects) {

            if (ig instanceof Friend) {
                System.out.println("friend");
                if (ig.getPosition().getRow() == guard.getPosition().getRow() &&
                        ig.getPosition().getCol() == guard.getPosition().getCol()) {
                    ((Guard) guard).setTarget(cadetPosition);
                    managerFriend.capture();
                    System.out.println("caught friend");
                }
            }
        }
    }

    private void checkCadet(GameObject gameObject) {
        for (GameObject ig : gameObjects) {
            // No point in checking collisions with self and friend
            if (ig instanceof Friend || ig instanceof CodeCadet) {
                continue;
            }


            //Checks beer
            if (ig instanceof Beer) {
                Beer beer = (Beer) ig;
                if (ig.getPosition().getRow() == gameObject.getPosition().getRow() &&
                        ig.getPosition().getCol() == gameObject.getPosition().getCol() && !beer.isCaught()) {
                    System.out.println("DRUNK");
                    cadetMoves=0;
                    beer.capture();
                    if(managerFriend.isCaught()) {
                        managerFriend.setCaught();
                        managerFriend.show();
                    }
                    ((CodeCadet) gameObject).setDrunk(); //Cast to CodeCadet
                }
            }

            //Checks card
            if (ig instanceof Card) {
                Card card = (Card) ig;
                if (ig.getPosition().getRow() == gameObject.getPosition().getRow() &&
                        ig.getPosition().getCol() == gameObject.getPosition().getCol() && !card.isCaught()) {
                    System.out.println("CARD");
                    card.capture();
                    /**
                     *  NEED TO ADD SCORE LOGIC
                     */

                }
            }

            //Checks guard
            if (ig instanceof Guard) {
                if (ig.getPosition().getRow() == gameObject.getPosition().getRow() &&
                        ig.getPosition().getCol() == gameObject.getPosition().getCol()) {
                    System.out.println("GUARD");
                    // Set caught cadet - important to check if game ends
                    ((Guard) ig).setCaughtCadet(true);
                    // hide all objects from the array of objects
                    for (GameObject go : gameObjects) {
                        go.getPosition().hide();
                    }
                }
            }

        }

    }

}
