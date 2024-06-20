import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerWaterGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerWaterGun extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerWaterGun/0.png",
    "Battle/Attacks/PlayerWaterGun/1.png",
    "Battle/Attacks/PlayerWaterGun/2.png",
    "Battle/Attacks/PlayerWaterGun/3.png",
    "Battle/Attacks/PlayerWaterGun/4.png",
    "Battle/Attacks/PlayerWaterGun/5.png",
    "Battle/Attacks/PlayerWaterGun/6.png",
    "Battle/Attacks/PlayerWaterGun/7.png",
    "Battle/Attacks/PlayerWaterGun/8.png",
    "Battle/Attacks/PlayerWaterGun/9.png",
    "Battle/Attacks/PlayerWaterGun/10.png",
    "Battle/Attacks/PlayerWaterGun/11.png",
    "Battle/Attacks/PlayerWaterGun/12.png",
    "Battle/Attacks/PlayerWaterGun/13.png",
    "Battle/Attacks/PlayerWaterGun/14.png",
    "Battle/Attacks/PlayerWaterGun/15.png",
    "Battle/Attacks/PlayerWaterGun/16.png",
    "Battle/Attacks/PlayerWaterGun/17.png",
    "Battle/Attacks/PlayerWaterGun/18.png",
    "Battle/Attacks/PlayerWaterGun/19.png",
    "Battle/Attacks/PlayerWaterGun/20.png",
    "Battle/Attacks/PlayerWaterGun/21.png",
    "Battle/Attacks/PlayerWaterGun/22.png",
    "Battle/Attacks/PlayerWaterGun/23.png",
    "Battle/Attacks/PlayerWaterGun/24.png",
    "Battle/Attacks/PlayerWaterGun/25.png",
    "Battle/Attacks/PlayerWaterGun/26.png",
    "Battle/Attacks/PlayerWaterGun/27.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 28) {
                getWorld().removeObject(this);
            }
        }
    }
}