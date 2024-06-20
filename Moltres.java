import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caterpie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moltres extends Pokemon {
    Class[] attacks = {Ember.class, Tackle.class, Flamethrower.class, Gust.class};
    boolean enemy = false;
    static int level;
    static int maxhp = 15;
    static int hp = maxhp;
    static int damage = 3;
    
    public Moltres(int lev, boolean enem) {
        if (enem) {
            setImage("Pookiemon/Enemy/Moltres.png");
        } else {
            setImage("Pookiemon/Player/Moltres.png");
        }
        enemy = enem;
        level = lev;
        maxhp+=level * 2;
        hp = maxhp;
        damage = level;
    }
}