import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Null4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Null4 extends Null {
    public void act() {
        super.act();
        if (onMe == 3) {
            setImage("Battle/Buttons/Moves/null1.png");
        } else {
            setImage("Battle/Buttons/Moves/null0.png");
        }
    }
}