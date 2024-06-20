import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyRockTomb extends Attacks {
    static String[] images = {
    "Battle/Attacks/EnemyRockTomb/0.png",
    "Battle/Attacks/EnemyRockTomb/1.png",
    "Battle/Attacks/EnemyRockTomb/2.png",
    "Battle/Attacks/EnemyRockTomb/3.png",
    "Battle/Attacks/EnemyRockTomb/4.png",
    "Battle/Attacks/EnemyRockTomb/5.png",
    "Battle/Attacks/EnemyRockTomb/6.png",
    "Battle/Attacks/EnemyRockTomb/7.png",
    "Battle/Attacks/EnemyRockTomb/8.png",
    "Battle/Attacks/EnemyRockTomb/9.png",
    "Battle/Attacks/EnemyRockTomb/10.png",
    "Battle/Attacks/EnemyRockTomb/11.png",
    "Battle/Attacks/EnemyRockTomb/12.png",
    "Battle/Attacks/EnemyRockTomb/13.png",
    "Battle/Attacks/EnemyRockTomb/14.png",
    "Battle/Attacks/EnemyRockTomb/15.png",
    "Battle/Attacks/EnemyRockTomb/16.png",
    "Battle/Attacks/EnemyRockTomb/17.png",
    "Battle/Attacks/EnemyRockTomb/18.png",
    "Battle/Attacks/EnemyRockTomb/19.png",
    "Battle/Attacks/EnemyRockTomb/20.png",
    "Battle/Attacks/EnemyRockTomb/21.png",
    "Battle/Attacks/EnemyRockTomb/22.png",
    "Battle/Attacks/EnemyRockTomb/23.png",
    "Battle/Attacks/EnemyRockTomb/24.png",
    "Battle/Attacks/EnemyRockTomb/25.png",
    "Battle/Attacks/EnemyRockTomb/26.png"};
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 27) {
                getWorld().removeObject(this);
            }
        }
    }
}