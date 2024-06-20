import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pookiemons extends Buttons {
    boolean right;
    int target;
    public static int onMe = 0;
    
    public void act() {
        if (Greenfoot.isKeyDown("right")) {
            onMe = 0;
        } else if (Greenfoot.isKeyDown("left")) {
            onMe = 1;
        }
    }
}