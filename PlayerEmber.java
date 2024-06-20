import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerEmber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerEmber extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerEmber/0.png",
    "Battle/Attacks/PlayerEmber/1.png",
    "Battle/Attacks/PlayerEmber/2.png",
    "Battle/Attacks/PlayerEmber/3.png",
    "Battle/Attacks/PlayerEmber/4.png",
    "Battle/Attacks/PlayerEmber/5.png",
    "Battle/Attacks/PlayerEmber/6.png",
    "Battle/Attacks/PlayerEmber/7.png",
    "Battle/Attacks/PlayerEmber/8.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 9) {
                getWorld().removeObject(this);
            }
        }
    }
}