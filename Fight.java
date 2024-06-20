import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fight extends Buttons {
    public void act() {
        super.act();
        if (onMe == 1) {
            setImage("Battle/Buttons/Menu/Fight1.png");
        } else {
            setImage("Battle/Buttons/Menu/Fight0.png");
        }
    }
}