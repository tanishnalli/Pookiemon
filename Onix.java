import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Articuno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Onix extends Pokemon {
    Class[] attacks = {WaterGun.class, Tackle.class, RockTomb.class, LowSweep.class};
    boolean enemy = false;
    static int level;
    static int maxhp = 15;
    static int hp = maxhp;
    static int damage = 3;
    
    public Onix(int lev, boolean enem) {
        if (enem) {
            setImage("Pookiemon/Enemy/Onix.png");
        } else {
            setImage("Pookiemon/Player/Onix.png");
        }
        enemy = enem;
        level = lev;
        maxhp+=level * 2;
        hp = maxhp;
        damage = level;
    }
}