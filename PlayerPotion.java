import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPotion extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerPotion/0.png",
    "Battle/Attacks/PlayerPotion/1.png",
    "Battle/Attacks/PlayerPotion/2.png",
    "Battle/Attacks/PlayerPotion/3.png",
    "Battle/Attacks/PlayerPotion/4.png",
    "Battle/Attacks/PlayerPotion/5.png",
    "Battle/Attacks/PlayerPotion/6.png",
    "Battle/Attacks/PlayerPotion/7.png",
    "Battle/Attacks/PlayerPotion/8.png",
    "Battle/Attacks/PlayerPotion/9.png",
    "Battle/Attacks/PlayerPotion/10.png",
    "Battle/Attacks/PlayerPotion/11.png",
    "Battle/Attacks/PlayerPotion/12.png",
    "Battle/Attacks/PlayerPotion/13.png",
    "Battle/Attacks/PlayerPotion/14.png",
    "Battle/Attacks/PlayerPotion/15.png",
    "Battle/Attacks/PlayerPotion/16.png",
    "Battle/Attacks/PlayerPotion/17.png",
    "Battle/Attacks/PlayerPotion/18.png",
    "Battle/Attacks/PlayerPotion/19.png",
    "Battle/Attacks/PlayerPotion/20.png",
    "Battle/Attacks/PlayerPotion/21.png",
    "Battle/Attacks/PlayerPotion/22.png",
    "Battle/Attacks/PlayerPotion/23.png",
    "Battle/Attacks/PlayerPotion/24.png",
    "Battle/Attacks/PlayerPotion/25.png",
    "Battle/Attacks/PlayerPotion/26.png",
    "Battle/Attacks/PlayerPotion/27.png",
    "Battle/Attacks/PlayerPotion/28.png",
    "Battle/Attacks/PlayerPotion/29.png",
    "Battle/Attacks/PlayerPotion/30.png",
    "Battle/Attacks/PlayerPotion/31.png",
    "Battle/Attacks/PlayerPotion/32.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 22) {
                getWorld().removeObject(this);
            }
        }
    }
}