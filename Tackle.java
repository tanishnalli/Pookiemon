import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tackle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tackle extends Moves {
    public void act() {
        super.act();
        if (onMe == 1) {
            setImage("Battle/Buttons/Moves/Tackle1.png");
        } else {
            setImage("Battle/Buttons/Moves/Tackle0.png");
        }
    }
}