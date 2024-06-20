import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RazorLeaf extends Moves {
    public void act() {
        super.act();
        if (onMe == 0) {
            setImage("Battle/Buttons/Moves/RazorLeaf1.png");
        } else {
            setImage("Battle/Buttons/Moves/RazorLeaf0.png");
        }
    }
}