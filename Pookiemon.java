import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pookiemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pookiemon extends Buttons {
    public void act() {
        super.act();
        if (onMe == 2) {
            setImage("Battle/Buttons/Menu/Pookiemon1.png");
        } else {
            setImage("Battle/Buttons/Menu/Pookiemon0.png");
        }
    }
}