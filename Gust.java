import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gust extends Moves {
    public void act() {
        super.act();
        if (onMe == 3) {
            setImage("Battle/Buttons/Moves/Gust1.png");
        } else {
            setImage("Battle/Buttons/Moves/Gust0.png");
        }
    }
}