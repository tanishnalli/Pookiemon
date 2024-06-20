import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mart extends World {
    public static final int WIDE = 580;
    public static final int HIGH = 474;
    Player player = new Player(43, 51);
    CollisionRectangle screen = new CollisionRectangle();
    int transparencyChange = 4;
    public static int dialogue = 0;
    public boolean aDown;
    InteractionRectangle interaction = new InteractionRectangle();
    ItemShop item = new ItemShop();
    public boolean openedShop = false;
    InteractionRectangle ballButton = new InteractionRectangle();
    InteractionRectangle ultraBallButton = new InteractionRectangle();
    InteractionRectangle potionButton = new InteractionRectangle();
    InteractionRectangle superPotionButton = new InteractionRectangle();
    InteractionRectangle cancelButton = new InteractionRectangle();
    MartNPC npc = new MartNPC();
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    OverlayText overlayText;
    EnterArrow enterArrow;
    BattleOverlay battleOverlay;
    boolean addedItemText = false;
    
    public Mart() {
        super(WIDE, HIGH, 1);
        setBackground("Mart.png");
        //PewterCity.music.stop();
        //music.play();
        addObject(player, WIDE/2 - 55, HIGH - 82);
        screen.getImage().setTransparency(255);
        screen.getImage().scale(WIDE, HIGH);
        addCollisionRectangle(WIDE/2, HIGH - 32, WIDE, 40);
        addCollisionRectangle(6, HIGH - 62, 40, 40);
        addCollisionRectangle(WIDE - 6, HIGH - 60, 40, 40);
        addCollisionRectangle(0, HIGH/2, 1, HIGH);
        addCollisionRectangle(WIDE, HIGH/2, 1, HIGH);
        addCollisionRectangle(WIDE/2, 50, WIDE, 40);
        addCollisionRectangle(WIDE-20, 88, 40, 40);
        addCollisionRectangle(WIDE-130, 82, 140, 20);
        addCollisionRectangle(WIDE/2 + 132, HIGH/2 + 23, 71, 130);
        addCollisionRectangle(WIDE, HIGH/2 + 23, 71, 130);
        addCollisionRectangle(105, HIGH/2 + 80, 85, 28);
        addCollisionRectangle(93, 120, 215, 215);
        GreenfootImage interactionImage = interaction.getImage();
        interactionImage.scale(10, 90);
        interactionImage.setTransparency(0); 
        addObject(interaction, WIDE/2 - 75, 155);
        npc.getImage().scale(60, 68);
        addObject(npc, 137, 165);
        Door door = new Door();
        door.getImage().scale(30, 1);
        door.getImage().setTransparency(0); 
        addObject(door, WIDE/2 - 53, HIGH - 56);
        addObject(screen, WIDE/2, HIGH/2);
    }
    
    public void act() {
        Actor actorTouchingInteraction = interaction.getIntersectingObject(Player.class);
        if(getObjects(EnterArrow.class).size() == 0 && Greenfoot.isKeyDown("A") && !aDown && actorTouchingInteraction != null && actorTouchingInteraction == player) {
            item.getImage().scale(260, 200);
            addObject(item, WIDE-item.getImage().getWidth()/2, item.getImage().getHeight()/2);
            openedShop = true;
            player.speed = 0;
        }
        if (screen.getImage().getTransparency() > 10) {
            screen.getImage().setTransparency(screen.getImage().getTransparency() - transparencyChange);
        } else {
            this.removeObject(screen);
        }
        if(!Greenfoot.isKeyDown("A")){
            aDown = false;
        }
        if (openedShop && getObjects(ItemShop.class).size() > 0) {
            ballButton.getImage().scale(240, 25);
            ballButton.getImage().setTransparency(0);
            addObject(ballButton, 450, 25);
            
            ultraBallButton.getImage().scale(240, 25);
            ultraBallButton.getImage().setTransparency(0);
            addObject(ultraBallButton, 450 , 60);
            
            potionButton.getImage().scale(240, 25);
            potionButton.getImage().setTransparency(0);
            addObject(potionButton, 450, 97);
            
            superPotionButton.getImage().scale(240, 25);
            superPotionButton.getImage().setTransparency(0);
            addObject(superPotionButton, 450, 132);
            
            cancelButton.getImage().scale(60, 15);
            cancelButton.getImage().setTransparency(0);
            addObject(cancelButton, 370, 177);
            
            checkButtonClicks();
        
            battleOverlay = new BattleOverlay();
            overlayText = new OverlayText();
            enterArrow = new EnterArrow();
            removeObjects(getObjects(BattleOverlay.class));
            removeObjects(getObjects(OverlayText.class));
            removeObjects(getObjects(EnterArrow.class));
            overlayText.getImage().scale(getWidth(), 100);
            addObject(overlayText, getWidth()/2, getHeight() - battleOverlay.getImage().getHeight()/2);
            addObject(enterArrow, getWidth() - 35, getHeight() - battleOverlay.getImage().getHeight()/4);
            showText("PookieBalls: " + Player.howManyItems[0] + "   Potions: " + Player.howManyItems[2] + "\nSuper Potions: " + Player.howManyItems[3] + "   Ultra Balls: " + Player.howManyItems[1], getWidth()/2, getHeight() - 50);
            Player.speed = 0;
        } else {
            removeObjects(getObjects(OverlayText.class));
            removeObjects(getObjects(EnterArrow.class));
            removeObject(ballButton);
            removeObject(ultraBallButton);
            removeObject(potionButton);
            removeObject(superPotionButton);
            removeObject(cancelButton);
            showText(" ", getWidth()/2, getHeight() - 50);
            Player.speed = 3;
        }
    }
    

    public void checkButtonClicks() {
        if (Greenfoot.mouseClicked(null)) {
            Actor clickedActor = Greenfoot.getMouseInfo().getActor();
            if (clickedActor == ballButton) {
                if(player.money >= 100) {
                    player.money -= 100;
                    Player.howManyItems[0]++;
                    Player.playerItems[0] = new PookieBall();
                }
            } else if (clickedActor == ultraBallButton) {
                if(player.money >= 200) {
                    player.money -= 200;
                    Player.howManyItems[1]++;
                    Player.playerItems[1] = new UltraBall();
                }
            } else if (clickedActor == potionButton) {
                if(player.money >= 60) {
                    player.money -= 60;
                    Player.howManyItems[2]++;
                    Player.playerItems[2] = new Potion();
                }
            } else if (clickedActor == superPotionButton) {
                if(player.money >= 100) {
                    player.money -= 100;
                    Player.howManyItems[3]++;
                    Player.playerItems[3] = new SuperPotion();
                }
            } else if (clickedActor == cancelButton) {
                removeObject(ballButton);
                removeObject(ultraBallButton);
                removeObject(superPotionButton);
                removeObject(potionButton);
                removeObject(item);
            }
        }
    }

    public void addCollisionRectangle(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setTransparency(0); 
        addObject(collisionRectangle, x, y);
    }
}