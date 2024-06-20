import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Run here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Run extends Buttons {
    public void act() {
        super.act();
        if (onMe == 3) {
            setImage("Battle/Buttons/Menu/Run1.png");
        } else {
            setImage("Battle/Buttons/Menu/Run0.png");
        }
    }
}