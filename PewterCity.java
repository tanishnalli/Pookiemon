import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PewterCity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PewterCity extends World {
    Scroller scroller = null;
    public static final int WIDE = 600;
    public static final int HIGH = 400;
    public static final int MAX_WIDE = 1708;
    public static final int MAX_HIGH = 1426;
    Player player = new Player(31, 36);
    static Door house1 = new Door();
    static Door house2 = new Door();
    static Door pookiemonCenter = new Door();
    static Door pookiemonMart = new Door();
    static Door gym = new Door();
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    static GreenfootImage bg = new GreenfootImage("PewterCity.png");
    
    public PewterCity() {
        super(WIDE, HIGH, 1, false);
        //Route1.music.stop();
        //House.music.stop();
        //Gym.music.stop();
        //Mart.music.stop();
        //PookiemonCenter.music.stop();
        //music.play();
        scroller = new Scroller(this, bg, MAX_WIDE, MAX_HIGH);
        if (Player.previousWorld == Gym.class) {
            addObject(player, (MAX_WIDE/3) - 17, (MAX_HIGH/3) + 145);
        } else if (Player.previousWorld == Mart.class) {
            addObject(player, MAX_WIDE/2 + 162, MAX_HIGH/2 - 15);
        } else if (Player.previousWorld == PookiemonCenter.class) {
            addObject(player, (MAX_WIDE/3) + 55, (MAX_HIGH/2) + 235);
        } else if (Player.previousWorld == House.class) {
            if (Player.whichDoor == 1) {
                addObject(player, MAX_WIDE/2 + 340, MAX_HIGH/2 - 270);
            } else if (Player.whichDoor == 2) {
                addObject(player, (MAX_WIDE/3) - 230, MAX_HIGH/2 + 410);
            }
        } else {
            addObject(player, MAX_WIDE/2 - 50, MAX_HIGH - 40);
        }
        addObject(player, MAX_WIDE/2 - 50, MAX_HIGH - 40);
        Route1ToPewterCity entrance = new Route1ToPewterCity();
        entrance.getImage().scale(140, 5);
        entrance.getImage().setTransparency(0);
        addObject(entrance, MAX_WIDE/2 - 70, MAX_HIGH - 5);
        //Trees
        addCollisionRectangle(MAX_WIDE/5, MAX_HIGH - 85, MAX_WIDE/3 + 170, 170);
        addCollisionRectangle(3 * MAX_WIDE/4, MAX_HIGH - 85, MAX_WIDE/2, 170);
        addCollisionRectangle(MAX_WIDE/25, MAX_HIGH/2, 150, MAX_HIGH);
        addCollisionRectangle(MAX_WIDE/15, 2 * MAX_HIGH/3 - 150, 200, 2 * MAX_HIGH/3);
        addCollisionRectangle(MAX_WIDE/2, 30, MAX_WIDE, 50);
        addCollisionRectangle(12 * MAX_WIDE/13, MAX_HIGH/4 - 20, 300, MAX_HIGH/2);
        addCollisionRectangle(12 * MAX_WIDE/13, 3 * MAX_HIGH/4 + 20, 300, MAX_HIGH/2 - 180);
        addCollisionRectangle(4 * MAX_WIDE/5 + 29, MAX_HIGH/11 - 20, 75, MAX_HIGH/8);
        addCollisionRectangle(1 * MAX_WIDE/5 + 10, MAX_HIGH/3 + 33, 75, MAX_HIGH/9);
        addCollisionRectangle(2 * MAX_WIDE/5 + 68, MAX_HIGH/3 + 33, 75, MAX_HIGH/9);
        addCollisionRectangle(2 * MAX_WIDE/5 + 68, MAX_HIGH/2 + 120, 75, MAX_HIGH/9);
        addCollisionRectangle(1 * MAX_WIDE/5 + 160, MAX_HIGH/2 + 120, 75, MAX_HIGH/9);
        addCollisionRectangle(3 * MAX_WIDE/5 + 80, MAX_HIGH/2 + 120, 355, MAX_HIGH/16);
        addCollisionRectangle(3 * MAX_WIDE/5 + 83, MAX_HIGH/3 + 140, 72, MAX_HIGH/16);
        //Wood Fences
        addCollisionRectangle(1 * MAX_WIDE/9 + 5, MAX_HIGH/7 + 20, 100, 10);
        addCollisionRectangle(5 * MAX_WIDE/9 + 70, MAX_HIGH/7 + 20, 250, 10);
        addCollisionRectangle(6 * MAX_WIDE/9 - 60, MAX_HIGH/10 + 10, 116, 10);
        addCollisionRectangle(6 * MAX_WIDE/9 - 113, MAX_HIGH/13, 10, 67);
        addCollisionRectangle(4 * MAX_WIDE/9 + 16, MAX_HIGH/2 - 45, 10, 120);
        addCollisionRectangle(3 * MAX_WIDE/9 - 90, MAX_HIGH/2 + 9, 570, 10);
        addCollisionRectangle(2 * MAX_WIDE/9 + 30, MAX_HIGH/3 + 33, 30, 10);
        addCollisionRectangle(3 * MAX_WIDE/9 + 125, MAX_HIGH/3 + 33, 30, 10);
        addCollisionRectangle(5 * MAX_WIDE/9 - 2, 2 * MAX_HIGH/3 + 132, 30, 10);
        addCollisionRectangle(7 * MAX_WIDE/9 - 25, 2 * MAX_HIGH/3 + 132, 30, 10);
        addCollisionRectangle(7 * MAX_WIDE/9 - 18, 2 * MAX_HIGH/3 + 35, 10, 185);
        addCollisionRectangle(5 * MAX_WIDE/9 - 12, 2 * MAX_HIGH/3 + 35, 10, 185);
        addCollisionRectangle(6 * MAX_WIDE/9 - 12, 2 * MAX_HIGH/3 - 48, 350, 10);
        //Bushes
        addCollisionRectangle(2 * MAX_WIDE/9 + 117, MAX_HIGH/7 + 20, 133, 10);
        addCollisionRectangle(4 * MAX_WIDE/9 - 10, MAX_HIGH/7 + 20, 133, 10);
        //Cliffs
        addCollisionRectangle(2 * MAX_WIDE/9 + 65, MAX_HIGH/6 + 35, 245, 10);
        addCollisionRectangle(5 * MAX_WIDE/9 + 65, MAX_HIGH/6 + 35, 600, 10);
        addCollisionRectangle(1 * MAX_WIDE/9 + 10, MAX_HIGH/6 + 35, 100, 10);
        addCollisionRectangle(5 * MAX_WIDE/9 + 84, 2 * MAX_HIGH/3 + 140, 140, 10);
        addCollisionRectangle(6 * MAX_WIDE/9 + 76, 2 * MAX_HIGH/3 + 140, 140, 10);
        //Signs
        addCollisionRectangle(8 * MAX_WIDE/9 - 110, MAX_HIGH/2 - 30, 40, 10);
        addCollisionRectangle(4 * MAX_WIDE/9 - 30, 3 * MAX_HIGH/4 + 10, 35, 10);
        addCollisionRectangle(4 * MAX_WIDE/9 - 65, MAX_HIGH/4 - 100, 35, 10);
        addCollisionRectangle(2 * MAX_WIDE/9 + 30, MAX_HIGH/2 - 140, 35, 10);
        //Blocked Areas
        addBlockedEntry(3 * MAX_WIDE/9 + 55, MAX_HIGH/7 + 50, 140, 15);
        addBlockedEntry(5 * MAX_WIDE/9 - 35, MAX_HIGH/13 + 50, 80, 10);
        addBlockedEntry(8 * MAX_WIDE/9 - 35, MAX_HIGH/2 + 50, 10, 200);
        //Real Estate
        addCollisionRectangle(3 * MAX_WIDE/9 + 55, MAX_HIGH/11, 393, 150);
        addCollisionRectangle(5 * MAX_WIDE/9 - 40, MAX_HIGH/13, 180, 100);
        addCollisionRectangle(6 * MAX_WIDE/9 + 93, MAX_HIGH/4, 175, 100);
        addCollisionRectangle(2 * MAX_WIDE/9 + 175, MAX_HIGH/3 + 25, 240, 140);
        addCollisionRectangle(5 * MAX_WIDE/9 + 55, MAX_HIGH/3 + 125, 150, 120);
        addCollisionRectangle(3 * MAX_WIDE/9 + 55, MAX_HIGH/2 + 125, 180, 130);
        addCollisionRectangle(1 * MAX_WIDE/9 + 185, 2 * MAX_HIGH/3 + 85, 175, 100);
        //Doors    
        pookiemonMart.getImage().scale(32, 6);
        pookiemonMart.getImage().setTransparency(0);
        addObject(pookiemonMart, MAX_WIDE/2 + 162, MAX_HIGH/2 - 50);

        gym.getImage().scale(32, 6);
        gym.getImage().setTransparency(0);
        addObject(gym, (MAX_WIDE/3) - 17, (MAX_HIGH/3) + 110);
        
        house1.getImage().scale(32,6);
        house1.getImage().setTransparency(0);
        addObject(house1, MAX_WIDE/2 + 340, MAX_HIGH/2 - 305);
        
        house2.getImage().scale(32,6);
        house2.getImage().setTransparency(0);
        addObject(house2, (MAX_WIDE/3) - 230, MAX_HIGH/2 + 375);

        pookiemonCenter.getImage().scale(32, 6);
        pookiemonCenter.getImage().setTransparency(0);
        addObject(pookiemonCenter, (MAX_WIDE/3) + 55, (MAX_HIGH/2) + 200);
    }
    
    public void act() {
        if (player != null) {
            scroll();
        }
    }
    
    public void scroll() {
        scroller.scroll(player.getX() - WIDE / 2, player.getY() - HIGH / 2);
    }
    
    public void addCollisionRectangle(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setTransparency(0);
        addObject(collisionRectangle, x, y);
    }
    
    public void addBlockedEntry(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width - width/2, height - height/2);
        collisionRectangle.getImage().setTransparency(0);
        addObject(collisionRectangle, x, y);
        BlockedEntry blockedEntry = new BlockedEntry();
        blockedEntry.getImage().scale(width, height);
        blockedEntry.getImage().setTransparency(0);
        addObject(blockedEntry, x, y);
    }
}