import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UltraBall extends Items {
    public void act() {
        super.act();
        if (onMe == 3) {
            setImage("Battle/Buttons/Items/UltraBall1.png");
        } else {
            setImage("Battle/Buttons/Items/UltraBall0.png");
        }
    }
}