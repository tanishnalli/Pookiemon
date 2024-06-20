import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyFlamethrower extends Attacks {
    static String[] images = {
    "Battle/Attacks/EnemyFlamethrower/0.png",
    "Battle/Attacks/EnemyFlamethrower/1.png",
    "Battle/Attacks/EnemyFlamethrower/2.png",
    "Battle/Attacks/EnemyFlamethrower/3.png",
    "Battle/Attacks/EnemyFlamethrower/4.png",
    "Battle/Attacks/EnemyFlamethrower/5.png",
    "Battle/Attacks/EnemyFlamethrower/6.png",
    "Battle/Attacks/EnemyFlamethrower/7.png",
    "Battle/Attacks/EnemyFlamethrower/8.png",
    "Battle/Attacks/EnemyFlamethrower/9.png",
    "Battle/Attacks/EnemyFlamethrower/10.png",
    "Battle/Attacks/EnemyFlamethrower/11.png",
    "Battle/Attacks/EnemyFlamethrower/12.png",
    "Battle/Attacks/EnemyFlamethrower/13.png",
    "Battle/Attacks/EnemyFlamethrower/14.png",
    "Battle/Attacks/EnemyFlamethrower/15.png",
    "Battle/Attacks/EnemyFlamethrower/16.png",
    "Battle/Attacks/EnemyFlamethrower/17.png",
    "Battle/Attacks/EnemyFlamethrower/18.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 17) {
                getWorld().removeObject(this);
            }
        }
    }
}