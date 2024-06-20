import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerTackle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTackle extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerTackle/0.png",
    "Battle/Attacks/PlayerTackle/1.png",
    "Battle/Attacks/PlayerTackle/2.png",
    "Battle/Attacks/PlayerTackle/3.png",
    "Battle/Attacks/PlayerTackle/4.png",
    "Battle/Attacks/PlayerTackle/5.png",
    "Battle/Attacks/PlayerTackle/6.png",
    "Battle/Attacks/PlayerTackle/7.png",
    "Battle/Attacks/PlayerTackle/8.png",
    "Battle/Attacks/PlayerTackle/9.png",
    "Battle/Attacks/PlayerTackle/10.png"};
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