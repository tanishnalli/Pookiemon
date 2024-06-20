import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyWaterGun extends Attacks {
    static String[] images = {
    "Battle/Attacks/EnemyWaterGun/0.png",
    "Battle/Attacks/EnemyWaterGun/1.png",
    "Battle/Attacks/EnemyWaterGun/2.png",
    "Battle/Attacks/EnemyWaterGun/3.png",
    "Battle/Attacks/EnemyWaterGun/4.png",
    "Battle/Attacks/EnemyWaterGun/5.png",
    "Battle/Attacks/EnemyWaterGun/6.png",
    "Battle/Attacks/EnemyWaterGun/7.png",
    "Battle/Attacks/EnemyWaterGun/8.png",
    "Battle/Attacks/EnemyWaterGun/9.png",
    "Battle/Attacks/EnemyWaterGun/10.png",
    "Battle/Attacks/EnemyWaterGun/11.png",
    "Battle/Attacks/EnemyWaterGun/12.png",
    "Battle/Attacks/EnemyWaterGun/13.png",
    "Battle/Attacks/EnemyWaterGun/14.png",
    "Battle/Attacks/EnemyWaterGun/15.png",
    "Battle/Attacks/EnemyWaterGun/16.png",
    "Battle/Attacks/EnemyWaterGun/17.png",
    "Battle/Attacks/EnemyWaterGun/18.png",
    "Battle/Attacks/EnemyWaterGun/19.png",
    "Battle/Attacks/EnemyWaterGun/20.png",
    "Battle/Attacks/EnemyWaterGun/21.png",
    "Battle/Attacks/EnemyWaterGun/22.png",
    "Battle/Attacks/EnemyWaterGun/23.png",
    "Battle/Attacks/EnemyWaterGun/24.png",
    "Battle/Attacks/EnemyWaterGun/25.png",
    "Battle/Attacks/EnemyWaterGun/26.png",
    "Battle/Attacks/EnemyWaterGun/27.png"};
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