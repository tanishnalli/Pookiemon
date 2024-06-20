import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerRockTomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerRockTomb extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerRockTomb/0.png",
    "Battle/Attacks/PlayerRockTomb/1.png",
    "Battle/Attacks/PlayerRockTomb/2.png",
    "Battle/Attacks/PlayerRockTomb/3.png",
    "Battle/Attacks/PlayerRockTomb/4.png",
    "Battle/Attacks/PlayerRockTomb/5.png",
    "Battle/Attacks/PlayerRockTomb/6.png",
    "Battle/Attacks/PlayerRockTomb/7.png",
    "Battle/Attacks/PlayerRockTomb/8.png",
    "Battle/Attacks/PlayerRockTomb/9.png",
    "Battle/Attacks/PlayerRockTomb/10.png",
    "Battle/Attacks/PlayerRockTomb/11.png",
    "Battle/Attacks/PlayerRockTomb/12.png",
    "Battle/Attacks/PlayerRockTomb/13.png",
    "Battle/Attacks/PlayerRockTomb/14.png",
    "Battle/Attacks/PlayerRockTomb/15.png",
    "Battle/Attacks/PlayerRockTomb/16.png",
    "Battle/Attacks/PlayerRockTomb/17.png",
    "Battle/Attacks/PlayerRockTomb/18.png",
    "Battle/Attacks/PlayerRockTomb/19.png",
    "Battle/Attacks/PlayerRockTomb/20.png",
    "Battle/Attacks/PlayerRockTomb/21.png",
    "Battle/Attacks/PlayerRockTomb/22.png",
    "Battle/Attacks/PlayerRockTomb/23.png",
    "Battle/Attacks/PlayerRockTomb/24.png",
    "Battle/Attacks/PlayerRockTomb/25.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 26) {
                getWorld().removeObject(this);
            }
        }
    }
}