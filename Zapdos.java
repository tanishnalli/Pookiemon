import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caterpie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zapdos extends Pokemon {
    Class[] attacks = {RazorLeaf.class, Tackle.class, RockTomb.class, Gust.class};
    boolean enemy = false;
    static int level;
    static int maxhp = 15;
    static int hp = maxhp;
    static int damage = 3;
    
    public Zapdos(int lev, boolean enem) {
        if (enem) {
            setImage("Pookiemon/Enemy/Zapdos.png");
        } else {
            setImage("Pookiemon/Player/Zapdos.png");
        }
        enemy = enem;
        level = lev;
        maxhp+=level * 2;
        hp = maxhp;
        damage = level;
    }
}