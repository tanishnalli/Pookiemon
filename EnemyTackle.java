import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyTackle extends Attacks {
    static String[] images = {
    "Battle/Attacks/EnemyTackle/0.png",
    "Battle/Attacks/EnemyTackle/1.png",
    "Battle/Attacks/EnemyTackle/2.png",
    "Battle/Attacks/EnemyTackle/3.png",
    "Battle/Attacks/EnemyTackle/4.png",
    "Battle/Attacks/EnemyTackle/5.png",
    "Battle/Attacks/EnemyTackle/6.png",
    "Battle/Attacks/EnemyTackle/7.png",
    "Battle/Attacks/EnemyTackle/8.png",
    "Battle/Attacks/EnemyTackle/9.png",
    "Battle/Attacks/EnemyTackle/10.png"};
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