import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerGust extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerGust/0.png",
    "Battle/Attacks/PlayerGust/1.png",
    "Battle/Attacks/PlayerGust/2.png",
    "Battle/Attacks/PlayerGust/3.png",
    "Battle/Attacks/PlayerGust/4.png",
    "Battle/Attacks/PlayerGust/5.png",
    "Battle/Attacks/PlayerGust/6.png",
    "Battle/Attacks/PlayerGust/7.png",
    "Battle/Attacks/PlayerGust/8.png",
    "Battle/Attacks/PlayerGust/9.png",
    "Battle/Attacks/PlayerGust/10.png",
    "Battle/Attacks/PlayerGust/11.png",
    "Battle/Attacks/PlayerGust/12.png",
    "Battle/Attacks/PlayerGust/13.png",
    "Battle/Attacks/PlayerGust/14.png",
    "Battle/Attacks/PlayerGust/15.png",
    "Battle/Attacks/PlayerGust/16.png",
    "Battle/Attacks/PlayerGust/17.png",
    "Battle/Attacks/PlayerGust/18.png",
    "Battle/Attacks/PlayerGust/19.png",
    "Battle/Attacks/PlayerGust/20.png",
    "Battle/Attacks/PlayerGust/21.png",
    "Battle/Attacks/PlayerGust/22.png",
    "Battle/Attacks/PlayerGust/23.png",
    "Battle/Attacks/PlayerGust/24.png",
    "Battle/Attacks/PlayerGust/25.png",
    "Battle/Attacks/PlayerGust/26.png",
    "Battle/Attacks/PlayerGust/27.png",
    "Battle/Attacks/PlayerGust/28.png",
    "Battle/Attacks/PlayerGust/29.png",
    "Battle/Attacks/PlayerGust/30.png",
    "Battle/Attacks/PlayerGust/31.png",
    "Battle/Attacks/PlayerGust/32.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 31) {
                getWorld().removeObject(this);
            }
        }
    }
}