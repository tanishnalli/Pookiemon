import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerFlamethrower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerFlamethrower extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerFlamethrower/0.png",
    "Battle/Attacks/PlayerFlamethrower/1.png",
    "Battle/Attacks/PlayerFlamethrower/2.png",
    "Battle/Attacks/PlayerFlamethrower/3.png",
    "Battle/Attacks/PlayerFlamethrower/4.png",
    "Battle/Attacks/PlayerFlamethrower/5.png",
    "Battle/Attacks/PlayerFlamethrower/6.png",
    "Battle/Attacks/PlayerFlamethrower/7.png",
    "Battle/Attacks/PlayerFlamethrower/8.png",
    "Battle/Attacks/PlayerFlamethrower/9.png",
    "Battle/Attacks/PlayerFlamethrower/10.png",
    "Battle/Attacks/PlayerFlamethrower/11.png",
    "Battle/Attacks/PlayerFlamethrower/12.png",
    "Battle/Attacks/PlayerFlamethrower/13.png",
    "Battle/Attacks/PlayerFlamethrower/14.png",
    "Battle/Attacks/PlayerFlamethrower/15.png",
    "Battle/Attacks/PlayerFlamethrower/16.png",
    "Battle/Attacks/PlayerFlamethrower/17.png",
    "Battle/Attacks/PlayerFlamethrower/18.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 19) {
                getWorld().removeObject(this);
            }
        }
    }
}