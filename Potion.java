import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends Items {
    public void act() {
        super.act();
        if (onMe == 1) {
            setImage("Battle/Buttons/Items/Potion1.png");
        } else {
            setImage("Battle/Buttons/Items/Potion0.png");
        }
    }
}