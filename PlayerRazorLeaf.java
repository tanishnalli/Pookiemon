import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerRazorLeaf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerRazorLeaf extends Attacks {
    static String[] images = {
    "Battle/Attacks/PlayerRazorLeaf/0.png",
    "Battle/Attacks/PlayerRazorLeaf/1.png",
    "Battle/Attacks/PlayerRazorLeaf/2.png",
    "Battle/Attacks/PlayerRazorLeaf/3.png",
    "Battle/Attacks/PlayerRazorLeaf/4.png",
    "Battle/Attacks/PlayerRazorLeaf/5.png",
    "Battle/Attacks/PlayerRazorLeaf/6.png",
    "Battle/Attacks/PlayerRazorLeaf/7.png",
    "Battle/Attacks/PlayerRazorLeaf/8.png",
    "Battle/Attacks/PlayerRazorLeaf/9.png",
    "Battle/Attacks/PlayerRazorLeaf/10.png",
    "Battle/Attacks/PlayerRazorLeaf/11.png",
    "Battle/Attacks/PlayerRazorLeaf/12.png",
    "Battle/Attacks/PlayerRazorLeaf/13.png",
    "Battle/Attacks/PlayerRazorLeaf/14.png",
    "Battle/Attacks/PlayerRazorLeaf/15.png",
    "Battle/Attacks/PlayerRazorLeaf/16.png",
    "Battle/Attacks/PlayerRazorLeaf/17.png",
    "Battle/Attacks/PlayerRazorLeaf/18.png",
    "Battle/Attacks/PlayerRazorLeaf/19.png",
    "Battle/Attacks/PlayerRazorLeaf/20.png",
    "Battle/Attacks/PlayerRazorLeaf/21.png",
    "Battle/Attacks/PlayerRazorLeaf/22.png",
    "Battle/Attacks/PlayerRazorLeaf/23.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 24) {
                getWorld().removeObject(this);
            }
        }
    }
}