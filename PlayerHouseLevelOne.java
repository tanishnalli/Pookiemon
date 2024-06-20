import greenfoot.*;

public class PlayerHouseLevelOne extends World
{
    Player player = new Player(43, 51);
    CollisionRectangle screen = new CollisionRectangle();
    int transparencyChange = 4;
    public boolean aDown;
    Door door;
    Mom mom = new Mom();
    InteractionRectangle interaction1 = new InteractionRectangle();
    InteractionRectangle interaction2 = new InteractionRectangle();
    InteractionRectangle interaction3 = new InteractionRectangle();
    public int momDialogue = 0;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    public PlayerHouseLevelOne() { 
        super(573, 441, 1);
        //PalletTown.music.stop();
        //PlayerHouseLevelTwo.music.stop();
        //music.play();
        setBackground("PlayerHouseLevelOne.png");
        if (Player.previousWorld == PalletTown.class) {
            addObject(player, getWidth()/2 - 118, getHeight() - 75);
        } else if (Player.previousWorld == PlayerHouseLevelTwo.class) {
            addObject(player, getWidth() - 118, 120);
        }
        
        addCollisionRectangle(getWidth()/2 + 2, getHeight()/2 + 4, 72, 60);
        addCollisionRectangle(getWidth()/2, 0, getWidth(), 120);
        addCollisionRectangle(90, 70, 180, 24);
        addCollisionRectangle(getWidth(), getHeight()/2, 1, getHeight());
        addCollisionRectangle(0, getHeight()/2, 1, getHeight());
        addCollisionRectangle(getWidth()/2, getHeight(), getWidth(), 1);
        addCollisionRectangle(getWidth()/2 - 23, getHeight()/5 - 16, 28, 25);
        addCollisionRectangle(25, getHeight()/2 + 110, 40, 50);
        addCollisionRectangle(getWidth() - 20, getHeight()/2 + 110, 40, 50);
        addCollisionRectangle(getWidth() - 45, getHeight()/2 - 70, 90, 1);
        addCollisionRectangle(60, getHeight() - 6, 115, 12);
        addCollisionRectangle(getWidth() - 175, getHeight() - 6, 350, 12);
        
        mom.getImage().scale(40, 40);
        addObject(mom, getWidth()/2 + 76, getHeight()/2 - 12);
        addCollisionRectangle(getWidth()/2 + 76, getHeight()/2 - 11, 28, 30);
        
        Stair stair = new Stair();
        stair.getImage().scale(1, 80);
        addObject(stair, getWidth() - 81, getHeight()/2 - 125);
        
        screen.getImage().setTransparency(255);
        screen.getImage().scale(getWidth(), getHeight());
        addObject(screen, getWidth()/2, getHeight()/2);
        door = new Door();
        door.getImage().scale(30, 1);
        door.getImage().setTransparency(0); 
        addObject(door, getWidth()/4 + 25, getHeight() - 5);
        interaction1.getImage().scale(10, 10);
        interaction1.getImage().setTransparency(0); 
        interaction2.getImage().scale(10, 10);
        interaction2.getImage().setTransparency(0); 
        interaction3.getImage().scale(10, 10);
        interaction3.getImage().setTransparency(0); 
        addObject(interaction1, getWidth()/2 + 76, getHeight()/2 - 37);
        addObject(interaction2, getWidth()/2 + 98, getHeight()/2 - 12);
        addObject(interaction3, getWidth()/2 + 76, getHeight()/2 + 6);
    }
    
    public void addCollisionRectangle(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setTransparency(0);
        addObject(collisionRectangle, x, y);
    }
    
    public void act() {
        Actor actorTouchingInteraction1 = interaction1.getIntersectingObject(Player.class);
        Actor actorTouchingInteraction2 = interaction2.getIntersectingObject(Player.class);
        Actor actorTouchingInteraction3 = interaction3.getIntersectingObject(Player.class);
        if (Greenfoot.isKeyDown("A") && !aDown && (actorTouchingInteraction1 != null && actorTouchingInteraction1 == player || 
            actorTouchingInteraction2 != null && actorTouchingInteraction2 == player || actorTouchingInteraction3 != null && actorTouchingInteraction3 == player)
            && PalletTown.firstTime == true) {
            aDown = true;
            player.speed = 0;
            momDialogue++;
            SpeechBubble speechBubble = new SpeechBubble();
            addObject(speechBubble, getWidth()/2, 350);
            addObject(new Text("Professor Oak is waiting for you"), getWidth()/2 - 15, 335);
        }
        if (Greenfoot.isKeyDown("A") && !aDown && (actorTouchingInteraction1 != null && actorTouchingInteraction1 == player || 
            actorTouchingInteraction2 != null && actorTouchingInteraction2 == player || actorTouchingInteraction3 != null && actorTouchingInteraction3 == player)
            && PalletTown.firstTime == false) {
            aDown = true;
            player.speed = 0;
            momDialogue++;
            SpeechBubble speechBubble = new SpeechBubble();
            addObject(speechBubble, getWidth()/2, 350);
            addObject(new Text("Good Luck on your adventure pookie!"), getWidth()/2 - 25, 335);
        }
        if(!Greenfoot.isKeyDown("A")){
            aDown = false;
        }
        if(momDialogue > 1) {
            removeObjects(getObjects(SpeechBubble.class));
            removeObjects(getObjects(Text.class));
            player.speed = 3;
            momDialogue = 0;
        }
    
        if(screen.getWorld() != null && screen.getImage().getTransparency() > 10) {
            screen.getImage().setTransparency(screen.getImage().getTransparency() - transparencyChange);
        } else {
            removeObject(screen);
        }
    }

}