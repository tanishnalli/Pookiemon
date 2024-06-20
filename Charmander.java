import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caterpie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charmander extends Pokemon {
    static Class[] attacks = {Ember.class, Tackle.class, Null3.class, Null4.class};
    
    public Charmander() {
        setImage("Pookiemon/Player/Charmander.png");
    }
    
    public void act() {
        updateMoves();
    }
    
    public void updateMoves() {
        attacks[0] = Ember.class;
        attacks[1] = Tackle.class;
        if (Player.playerPokemonLevels[0] > 11) {
            attacks[2] = Flamethrower.class;
        } else {
            attacks[2] = Null3.class;
        }
        if (Player.playerPokemonLevels[0] > 17) {
            attacks[3] = Gust.class;
        } else {
            attacks[3] = Null4.class;
        }
    }
}