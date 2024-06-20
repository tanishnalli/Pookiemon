import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LowSweep extends Moves {
    public void act() {
        super.act();
        if (onMe == 3) {
            setImage("Battle/Buttons/Moves/LowSweep1.png");
        } else {
            setImage("Battle/Buttons/Moves/LowSweep0.png");
        }
    }
}