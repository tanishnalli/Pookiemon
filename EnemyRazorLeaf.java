import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyRazorLeaf extends Attacks {
    static String[] images = {
    "Battle/Attacks/EnemyRazorLeaf/0.png",
    "Battle/Attacks/EnemyRazorLeaf/1.png",
    "Battle/Attacks/EnemyRazorLeaf/2.png",
    "Battle/Attacks/EnemyRazorLeaf/3.png",
    "Battle/Attacks/EnemyRazorLeaf/4.png",
    "Battle/Attacks/EnemyRazorLeaf/5.png",
    "Battle/Attacks/EnemyRazorLeaf/6.png",
    "Battle/Attacks/EnemyRazorLeaf/7.png",
    "Battle/Attacks/EnemyRazorLeaf/8.png",
    "Battle/Attacks/EnemyRazorLeaf/9.png",
    "Battle/Attacks/EnemyRazorLeaf/10.png",
    "Battle/Attacks/EnemyRazorLeaf/11.png",
    "Battle/Attacks/EnemyRazorLeaf/12.png",
    "Battle/Attacks/EnemyRazorLeaf/13.png",
    "Battle/Attacks/EnemyRazorLeaf/14.png",
    "Battle/Attacks/EnemyRazorLeaf/15.png",
    "Battle/Attacks/EnemyRazorLeaf/16.png",
    "Battle/Attacks/EnemyRazorLeaf/17.png",
    "Battle/Attacks/EnemyRazorLeaf/18.png",
    "Battle/Attacks/EnemyRazorLeaf/19.png",
    "Battle/Attacks/EnemyRazorLeaf/20.png",
    "Battle/Attacks/EnemyRazorLeaf/21.png",
    "Battle/Attacks/EnemyRazorLeaf/22.png",
    "Battle/Attacks/EnemyRazorLeaf/23.png"};
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