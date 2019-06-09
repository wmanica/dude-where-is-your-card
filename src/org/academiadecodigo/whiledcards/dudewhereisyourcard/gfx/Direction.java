package org.academiadecodigo.whiledcards.dudewhereisyourcard.gfx;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    /*
    * This method detects if two directions are opposite
    * @param dir the direction to compare
    * @return true if directions are opposite
    * */

    public boolean isOpposite(Direction dir){
        return dir.equals(oppositeDirection());
    }

    /*
    * Obtains the opposite direction
    * @return the oppositre direction
    * */

    public Direction oppositeDirection(){
        Direction opposite = null;
        switch (this){
            case UP:
                opposite=Direction.DOWN;
                break;
            case DOWN:
                opposite=Direction.UP;
                break;
            case LEFT:
                opposite=Direction.RIGHT;
                break;
            case RIGHT:
                opposite=Direction.LEFT;
                break;
        }
        return opposite;
    }
}
