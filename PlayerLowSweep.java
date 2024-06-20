import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerLowSweep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerLowSweep extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerLowSweep/0.png",
    "Battle/Attacks/PlayerLowSweep/1.png",
    "Battle/Attacks/PlayerLowSweep/2.png",
    "Battle/Attacks/PlayerLowSweep/3.png",
    "Battle/Attacks/PlayerLowSweep/4.png",
    "Battle/Attacks/PlayerLowSweep/5.png",
    "Battle/Attacks/PlayerLowSweep/6.png",
    "Battle/Attacks/PlayerLowSweep/7.png",
    "Battle/Attacks/PlayerLowSweep/8.png",
    "Battle/Attacks/PlayerLowSweep/9.png",
    "Battle/Attacks/PlayerLowSweep/10.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 11) {
                getWorld().removeObject(this);
            }
        }
    }
}