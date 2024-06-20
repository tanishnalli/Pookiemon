import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperPotion extends Items {
    public void act() {
        super.act();
        if (onMe == 2) {
            setImage("Battle/Buttons/Items/SuperPotion1.png");
        } else {
            setImage("Battle/Buttons/Items/SuperPotion0.png");
        }
    }
}