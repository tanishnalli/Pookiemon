import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerSuperPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerSuperPotion extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerSuperPotion/0.png",
    "Battle/Attacks/PlayerSuperPotion/1.png",
    "Battle/Attacks/PlayerSuperPotion/2.png",
    "Battle/Attacks/PlayerSuperPotion/3.png",
    "Battle/Attacks/PlayerSuperPotion/4.png",
    "Battle/Attacks/PlayerSuperPotion/5.png",
    "Battle/Attacks/PlayerSuperPotion/6.png",
    "Battle/Attacks/PlayerSuperPotion/7.png",
    "Battle/Attacks/PlayerSuperPotion/8.png",
    "Battle/Attacks/PlayerSuperPotion/9.png",
    "Battle/Attacks/PlayerSuperPotion/10.png",
    "Battle/Attacks/PlayerSuperPotion/11.png",
    "Battle/Attacks/PlayerSuperPotion/12.png",
    "Battle/Attacks/PlayerSuperPotion/13.png",
    "Battle/Attacks/PlayerSuperPotion/14.png",
    "Battle/Attacks/PlayerSuperPotion/15.png",
    "Battle/Attacks/PlayerSuperPotion/16.png",
    "Battle/Attacks/PlayerSuperPotion/17.png",
    "Battle/Attacks/PlayerSuperPotion/18.png",
    "Battle/Attacks/PlayerSuperPotion/19.png",
    "Battle/Attacks/PlayerSuperPotion/20.png",
    "Battle/Attacks/PlayerSuperPotion/21.png"};
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