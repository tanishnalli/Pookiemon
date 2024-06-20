import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZapdosButton extends Pookiemons {
    public ZapdosButton(boolean righ) {
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
            setImage("Battle/Buttons/Pookiemon/Zapdos1.png");
        } else {
            setImage("Battle/Buttons/Pookiemon/Zapdos0.png");
        }
    }
}