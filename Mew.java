import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caterpie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mew extends Pokemon {
    Class[] attacks = {WaterGun.class, Tackle.class, Flamethrower.class, LowSweep.class};
    boolean enemy = false;
    static int level;
    static int maxhp = 15;
    static int hp = maxhp;
    static int damage = 3;
    
    public Mew(int lev, boolean enem) {
        if (enem) {
            setImage("Pookiemon/Enemy/Mew.png");
        } else {
            setImage("Pookiemon/Player/Mew.png");
        }
        enemy = enem;
        level = lev;
        maxhp+=level * 2;
        hp = maxhp;
        damage = level;
    }
}