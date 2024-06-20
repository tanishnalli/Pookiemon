import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerEmber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyEmber extends Attacks {
    static String[] images = {
    "Battle/Attacks/EnemyEmber/0.png",
    "Battle/Attacks/EnemyEmber/1.png",
    "Battle/Attacks/EnemyEmber/2.png",
    "Battle/Attacks/EnemyEmber/3.png",
    "Battle/Attacks/EnemyEmber/4.png",
    "Battle/Attacks/EnemyEmber/5.png",
    "Battle/Attacks/EnemyEmber/6.png",
    "Battle/Attacks/EnemyEmber/7.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 8) {
                getWorld().removeObject(this);
            }
        }
    }
}