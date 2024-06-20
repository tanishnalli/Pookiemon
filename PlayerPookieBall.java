import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerPookieBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPookieBall extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerPookieBall/0.png",
    "Battle/Attacks/PlayerPookieBall/1.png",
    "Battle/Attacks/PlayerPookieBall/2.png",
    "Battle/Attacks/PlayerPookieBall/3.png",
    "Battle/Attacks/PlayerPookieBall/4.png",
    "Battle/Attacks/PlayerPookieBall/5.png",
    "Battle/Attacks/PlayerPookieBall/6.png",
    "Battle/Attacks/PlayerPookieBall/7.png",
    "Battle/Attacks/PlayerPookieBall/8.png",
    "Battle/Attacks/PlayerPookieBall/9.png",
    "Battle/Attacks/PlayerPookieBall/10.png",
    "Battle/Attacks/PlayerPookieBall/11.png",
    "Battle/Attacks/PlayerPookieBall/12.png",
    "Battle/Attacks/PlayerPookieBall/13.png",
    "Battle/Attacks/PlayerPookieBall/14.png",
    "Battle/Attacks/PlayerPookieBall/15.png",
    "Battle/Attacks/PlayerPookieBall/16.png",
    "Battle/Attacks/PlayerPookieBall/17.png",
    "Battle/Attacks/PlayerPookieBall/18.png",
    "Battle/Attacks/PlayerPookieBall/19.png",
    "Battle/Attacks/PlayerPookieBall/20.png"};
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