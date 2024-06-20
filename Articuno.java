import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caterpie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Articuno extends Pokemon {
    Class[] attacks = {WaterGun .class, Tackle.class, RockTomb.class, Gust.class};
    boolean enemy = false;
    static int level;
    static int maxhp = 15;
    static int hp = maxhp;
    static int damage = 3;
    
    public Articuno(int lev, boolean enem) {
        if (enem) {
            setImage("Pookiemon/Enemy/Articuno.png");
        } else {
            setImage("Pookiemon/Player/Articuno.png");
        }
        enemy = enem;
        level = lev;
        maxhp+=level * 2;
        hp = maxhp;
        damage = level;
    }
}