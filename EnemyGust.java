import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyGust extends Attacks {
    static String[] images = {
    "Battle/Attacks/EnemyGust/0.png",
    "Battle/Attacks/EnemyGust/1.png",
    "Battle/Attacks/EnemyGust/2.png",
    "Battle/Attacks/EnemyGust/3.png",
    "Battle/Attacks/EnemyGust/4.png",
    "Battle/Attacks/EnemyGust/5.png",
    "Battle/Attacks/EnemyGust/6.png",
    "Battle/Attacks/EnemyGust/7.png",
    "Battle/Attacks/EnemyGust/8.png",
    "Battle/Attacks/EnemyGust/9.png",
    "Battle/Attacks/EnemyGust/10.png",
    "Battle/Attacks/EnemyGust/11.png",
    "Battle/Attacks/EnemyGust/12.png",
    "Battle/Attacks/EnemyGust/13.png",
    "Battle/Attacks/EnemyGust/14.png",
    "Battle/Attacks/EnemyGust/15.png",
    "Battle/Attacks/EnemyGust/16.png",
    "Battle/Attacks/EnemyGust/17.png",
    "Battle/Attacks/EnemyGust/18.png",
    "Battle/Attacks/EnemyGust/19.png",
    "Battle/Attacks/EnemyGust/20.png",
    "Battle/Attacks/EnemyGust/21.png",
    "Battle/Attacks/EnemyGust/22.png",
    "Battle/Attacks/EnemyGust/23.png",
    "Battle/Attacks/EnemyGust/24.png",
    "Battle/Attacks/EnemyGust/25.png",
    "Battle/Attacks/EnemyGust/26.png",
    "Battle/Attacks/EnemyGust/27.png",
    "Battle/Attacks/EnemyGust/28.png",
    "Battle/Attacks/EnemyGust/29.png",
    "Battle/Attacks/EnemyGust/30.png",
    "Battle/Attacks/EnemyGust/31.png",
    "Battle/Attacks/EnemyGust/32.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 33) {
                getWorld().removeObject(this);
            }
        }
    }
}