import greenfoot.*;

public class PlayerHouseLevelTwo extends World {
    Player player = new Player(43, 51);
    CollisionRectangle screen = new CollisionRectangle();
    int transparencyChange = 4;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    public PlayerHouseLevelTwo() {
        super(600, 487, 1);
        //GenderWorld.music.stop();
        //PlayerHouseLevelOne.music.stop();
        //music.play();
        setBackground("PlayerHouseLevelTwo.png");
        if (Player.previousWorld == PlayerHouseLevelOne.class) {
            addObject(player, getWidth() - 82, 140);
        } else {
            addObject(player, (int)(getWidth()/7.6), (int)(getHeight()/1.58));
        }
        addCollisionRectangle(getWidth()/2 - 2, getHeight()/2 , 54, 60);
        addCollisionRectangle(getWidth()/2, 0, getWidth(), 160);
        addCollisionRectangle(100, 90, 315, 25);
        addCollisionRectangle(getWidth(), getHeight()/2, 1, getHeight());
        addCollisionRectangle(0, getHeight()/2, 1, getHeight());
        addCollisionRectangle(getWidth()/2, getHeight(), getWidth(), 1);
        addCollisionRectangle(getWidth()/2 + 90, getHeight()/2 - 115, 1, 100);
        addCollisionRectangle(getWidth()/2 + 140, getHeight()/2 - 60, 100, 1);
        Stair stair = new Stair();
        stair.getImage().scale(1, 100);
        addObject(stair, getWidth() - 120, getHeight()/2 - 115);
        addObject(screen, getWidth()/2, getHeight()/2);
        screen.getImage().setTransparency(255);
        screen.getImage().scale(getWidth(), getHeight());
    }
    
    public void addCollisionRectangle(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setTransparency(0); 
        addObject(collisionRectangle, x, y);
    }
    
    public void act() {
        if (screen.getImage().getTransparency() > 10) {
            screen.getImage().setTransparency(screen.getImage().getTransparency() - transparencyChange);
        } else {
            this.removeObject(screen);
        }
    }
}