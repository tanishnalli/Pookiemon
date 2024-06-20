import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Null2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Null2 extends Null {
    public void act() {
        super.act();
        if (onMe == 1) {
            setImage("Battle/Buttons/Moves/null1.png");
        } else {
            setImage("Battle/Buttons/Moves/null0.png");
        }
    }
}