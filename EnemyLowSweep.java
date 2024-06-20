import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyLowSweep extends Attacks {
    static String[] images = {
    "Battle/Attacks/EnemyLowSweep/0.png",
    "Battle/Attacks/EnemyLowSweep/1.png",
    "Battle/Attacks/EnemyLowSweep/2.png",
    "Battle/Attacks/EnemyLowSweep/3.png",
    "Battle/Attacks/EnemyLowSweep/4.png",
    "Battle/Attacks/EnemyLowSweep/5.png",
    "Battle/Attacks/EnemyLowSweep/6.png",
    "Battle/Attacks/EnemyLowSweep/7.png",
    "Battle/Attacks/EnemyLowSweep/8.png",
    "Battle/Attacks/EnemyLowSweep/9.png",
    "Battle/Attacks/EnemyLowSweep/10.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 11) {
                getWorld().removeObject(this);
            }
        }
    }
}