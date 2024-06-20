import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends BattleObjects {
    public static int onMe = 1;
    
    public void act() {
        if (onMe == 0) {
            if (Greenfoot.isKeyDown("right")) {
                onMe = 0;
            } else if (Greenfoot.isKeyDown("left")) {
                onMe = 1;
            } else if (Greenfoot.isKeyDown("up")) {
                onMe = 0;
            } else if (Greenfoot.isKeyDown("down")) {
                onMe = 3;
            }
        } else if (onMe == 1) {
            if (Greenfoot.isKeyDown("right")) {
                onMe = 0;
            } else if (Greenfoot.isKeyDown("left")) {
                onMe = 1;
            } else if (Greenfoot.isKeyDown("up")) {
                onMe = 1;
            } else if (Greenfoot.isKeyDown("down")) {
                onMe = 2;
            }
        } else if (onMe == 2) {
            if (Greenfoot.isKeyDown("right")) {
                onMe = 3;
            } else if (Greenfoot.isKeyDown("left")) {
                onMe = 2;
            } else if (Greenfoot.isKeyDown("up")) {
                onMe = 1;
            } else if (Greenfoot.isKeyDown("down")) {
                onMe = 2;
            }
        } else if (onMe == 3) {
            if (Greenfoot.isKeyDown("right")) {
                onMe = 3;
            } else if (Greenfoot.isKeyDown("left")) {
                onMe = 2;
            } else if (Greenfoot.isKeyDown("up")) {
                onMe = 0;
            } else if (Greenfoot.isKeyDown("down")) {
                onMe = 3;
            }
        }
    }
}