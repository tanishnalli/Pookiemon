import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bag extends Buttons {
    public void act() {
        super.act();
        if (onMe == 0) {
            setImage("Battle/Buttons/Menu/Bag1.png");
        } else {
            setImage("Battle/Buttons/Menu/Bag0.png");
        }
    }
}