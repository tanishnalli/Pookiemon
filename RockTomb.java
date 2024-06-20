import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockTomb extends Moves {
    public void act() {
        super.act();
        if (onMe == 2) {
            setImage("Battle/Buttons/Moves/RockTomb1.png");
        } else {
            setImage("Battle/Buttons/Moves/RockTomb0.png");
        }
    }
}