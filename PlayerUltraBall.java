import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerUltraBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerUltraBall extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerUltraBall/0.png",
    "Battle/Attacks/PlayerUltraBall/1.png",
    "Battle/Attacks/PlayerUltraBall/2.png",
    "Battle/Attacks/PlayerUltraBall/3.png",
    "Battle/Attacks/PlayerUltraBall/4.png",
    "Battle/Attacks/PlayerUltraBall/5.png",
    "Battle/Attacks/PlayerUltraBall/6.png",
    "Battle/Attacks/PlayerUltraBall/7.png",
    "Battle/Attacks/PlayerUltraBall/8.png",
    "Battle/Attacks/PlayerUltraBall/9.png",
    "Battle/Attacks/PlayerUltraBall/10.png",
    "Battle/Attacks/PlayerUltraBall/11.png",
    "Battle/Attacks/PlayerUltraBall/12.png",
    "Battle/Attacks/PlayerUltraBall/13.png",
    "Battle/Attacks/PlayerUltraBall/14.png",
    "Battle/Attacks/PlayerUltraBall/15.png",
    "Battle/Attacks/PlayerUltraBall/16.png",
    "Battle/Attacks/PlayerUltraBall/17.png",
    "Battle/Attacks/PlayerUltraBall/18.png",
    "Battle/Attacks/PlayerUltraBall/19.png",
    "Battle/Attacks/PlayerUltraBall/20.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 21) {
                getWorld().removeObject(this);
            }
        }
    }
}