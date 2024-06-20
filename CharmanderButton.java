import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharmanderButton extends Pookiemons {
    public CharmanderButton(boolean righ) {
        right = righ;
    }
    
    public void act() {
        super.act();
        if (right) {
            target = 0;
        } else {
            target = 1;
        }
        if (onMe == target) {
            setImage("Battle/Buttons/Pookiemon/Charmander1.png");
        } else {
            setImage("Battle/Buttons/Pookiemon/Charmander0.png");
        }
    }
}