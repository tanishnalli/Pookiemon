import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bar extends HP {
    boolean player;
    
    public Bar(boolean play) {
        player = play;
    }
    
    public void act() {
        if (player) {
            if (Player.playerPokemonHP[0] > Player.playerPokemonMaxHP[0]/2) {
                getImage().setColor(new Color(8,228,4));
                getImage().fill();
            } else if (Player.playerPokemonHP[0] > Player.playerPokemonMaxHP[0]/4) {
                getImage().setColor(new Color(255,124,4));
                getImage().fill();
            } else if (Player.playerPokemonHP[0] > 0) {
                getImage().setColor(new Color(255,4,4));
                getImage().fill();
            } else {
                getWorld().removeObject(this);
            }
        } else {
            if (Battle.getEnemyHP() > (15 + Battle.enemyLevel * 2)/2) {
                getImage().setColor(new Color(8,228,4));
                getImage().fill();
            } else if (Battle.getEnemyHP() > (15 + Battle.enemyLevel * 2)/4) {
                getImage().setColor(new Color(255,124,4));
                getImage().fill();
            } else if (Battle.getEnemyHP() > 0) {
                getImage().setColor(new Color(255,4,4));
                getImage().fill();
            } else {
                getWorld().removeObject(this);
            }
        }
    }
}