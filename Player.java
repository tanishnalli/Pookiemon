import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Player extends Actor {
    GreenfootImage[] playerSprites = new GreenfootImage[8];
    public static int direction = 0;
    public static int speed = 3;
    private int frameCount = 0;
    public static String gender = "boy";
    CollisionRectangle screen = new CollisionRectangle();
    int transparencyChange = 4;
    static Class previousWorld = PlayerHouseLevelTwo.class;
    int playerWidth;
    int playerHeight;
    boolean isMoving;
    boolean added = false;
    static List<String> playerPokemonBox = new ArrayList();
    static String[] playerPokemonNames = {"", "", ""};
    static int[] playerPokemonLevels = {10, 0, 0};
    static int[] playerPokemonMaxHP = {15 + Player.playerPokemonLevels[0] * 2, 15 + Player.playerPokemonLevels[1] * 2, 15 + Player.playerPokemonLevels[1] * 2};
    static int[] playerPokemonHP = {15 + Player.playerPokemonLevels[0] * 2, 15 + Player.playerPokemonLevels[1] * 2, 15 + Player.playerPokemonLevels[1] * 2};
    static int[] playerPokemonDamage = {playerPokemonLevels[0], playerPokemonLevels[1], playerPokemonLevels[2]};
    public static Items[] playerItems = new Items[4];
    public static int[] howManyItems = new int[4];
    static String enemyPokemonName;
    static int interactTimer;
    public static int beforeX;
    public static int beforeY;
    OverlayText overlayText;
    EnterArrow enterArrow;
    BattleOverlay battleOverlay;
    static int money = 1000;
    static int whichDoor;
    boolean addedBlockedText = false;
    int aDownCounter = 0;
    boolean addedCenterText = false;
    static boolean beatBrock = false;
    boolean talkedToBrock = false;
    
    public void act() {
        updateStats();
        if (getWorld().getClass() == Gym.class && isTouching(InteractionRectangle.class) && Greenfoot.isKeyDown("A")) {
            battleOverlay = new BattleOverlay();
            overlayText = new OverlayText();
            enterArrow = new EnterArrow();
            getWorld().removeObjects(getWorld().getObjects(BattleOverlay.class));
            getWorld().removeObjects(getWorld().getObjects(OverlayText.class));
            getWorld().removeObjects(getWorld().getObjects(EnterArrow.class));
            overlayText.getImage().scale(Gym.WIDE, 100);
            getWorld().addObject(overlayText, Gym.WIDE/2, getWorld().getHeight() - battleOverlay.getImage().getHeight()/2);
            getWorld().addObject(enterArrow, getWorld().getWidth() - 35, getWorld().getHeight() - battleOverlay.getImage().getHeight()/4);
            getWorld().showText("Lets Begin!", Gym.WIDE/2, getWorld().getHeight() - 50);
            speed = 0;
            talkedToBrock = true;
        }
        if (talkedToBrock && Greenfoot.isKeyDown("A")) {
            previousWorld = getWorld().getClass();
            if (Player.playerPokemonNames[0] == "Bulbasaur") {
                Greenfoot.setWorld(new Battle(1, 5, 0));
            } else if (Player.playerPokemonNames[0] == "Squirtle") {
                Greenfoot.setWorld(new Battle(1, 5, 1));
            } else if (Player.playerPokemonNames[0] == "Charmander") {
                Greenfoot.setWorld(new Battle(1, 5, 2));
            } else if (Player.playerPokemonNames[0] == "Articuno") {
                Greenfoot.setWorld(new Battle(1, 5, 3));
            } else if (Player.playerPokemonNames[0] == "Mew") {
                Greenfoot.setWorld(new Battle(1, 5, 4));
            } else if (Player.playerPokemonNames[0] == "Mewtwo") {
                Greenfoot.setWorld(new Battle(1, 5, 5));
            } else if (Player.playerPokemonNames[0] == "Moltres") {
                Greenfoot.setWorld(new Battle(1, 5, 6));
            } else if (Player.playerPokemonNames[0] == "Zapdos") {
                Greenfoot.setWorld(new Battle(1, 5, 7));
            }
        }
        Actor blocked = getOneIntersectingObject(BlockedEntry.class);
        if (blocked != null && !addedBlockedText) {
            battleOverlay = new BattleOverlay();
            overlayText = new OverlayText();
            enterArrow = new EnterArrow();
            getWorld().removeObjects(getWorld().getObjects(BattleOverlay.class));
            getWorld().removeObjects(getWorld().getObjects(OverlayText.class));
            getWorld().removeObjects(getWorld().getObjects(EnterArrow.class));
            overlayText.getImage().scale(PewterCity.WIDE, 100);
            getWorld().addObject(overlayText, PewterCity.WIDE/2, getWorld().getHeight() - battleOverlay.getImage().getHeight()/2);
            getWorld().addObject(enterArrow, getWorld().getWidth() - 35, getWorld().getHeight() - battleOverlay.getImage().getHeight()/4);
            getWorld().showText("You cant go here yet!", PewterCity.WIDE/2, getWorld().getHeight() - 50);
            speed = 0;
            addedBlockedText = true;
        }
        if (addedBlockedText && Greenfoot.isKeyDown("A")) {
            getWorld().removeObjects(getWorld().getObjects(OverlayText.class));
            getWorld().removeObjects(getWorld().getObjects(EnterArrow.class));
            getWorld().showText(" ", PewterCity.WIDE/2, getWorld().getHeight() - 50);
            speed = 3;
            addedBlockedText = false;
            Greenfoot.setWorld(new PewterCity());
        }
        playerPokemonMaxHP[0] = 15 + Player.playerPokemonLevels[0] * 2;
        playerPokemonMaxHP[1] = 15 + Player.playerPokemonLevels[1] * 2;
        playerPokemonMaxHP[2] = 15 + Player.playerPokemonLevels[2] * 2;
        Actor stair = getOneIntersectingObject(Stair.class);
        Actor interactionTouchingPlayer = getOneIntersectingObject(InteractionRectangle.class);
        if (stair != null) {
            levelTransition();
        } else {
            playerMove();
        }
        if (getWorld().getClass() == PlayerHouseLevelOne.class || getWorld().getClass() == PlayerHouseLevelTwo.class || getWorld().getClass() == House.class || getWorld().getClass() == Lab.class || getWorld().getClass() == Gym.class || getWorld().getClass() == PookiemonCenter.class || getWorld().getClass() == Mart.class) {
            if(Greenfoot.isKeyDown("up") || direction == 1) {
                playerWidth = 39;
            } else {
                playerWidth = 43;
            }
        } else {
            if(Greenfoot.isKeyDown("up") || direction == 1) {
                playerWidth = 28;
            } else {
                playerWidth = 31;
            }
        }
        GreenfootImage image = getImage();
        getImage().scale(playerWidth, playerHeight);
        setImage(image);
        Actor door = getOneIntersectingObject(Door.class);
        if (door != null) {
            if (getWorld().getClass() == PlayerHouseLevelOne.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new PalletTown());
            } else if (getWorld().getClass() == PalletTown.class) {
                previousWorld = getWorld().getClass();
                if ((Door)(getOneIntersectingObject(Door.class)) == PalletTown.myDoor) {
                    Greenfoot.setWorld(new PlayerHouseLevelOne());
                } else if ((Door)(getOneIntersectingObject(Door.class)) == PalletTown.rivalDoor) {
                    Greenfoot.setWorld(new House());
                } else if ((Door)(getOneIntersectingObject(Door.class)) == PalletTown.labDoor) {
                    Greenfoot.setWorld(new Lab());
                }
                getWorld().removeObject(PalletTown.rivalDoor);
            } else if (getWorld().getClass() == House.class) {
                Class w = previousWorld;
                previousWorld = getWorld().getClass();
                if (w == PalletTown.class) {
                    Greenfoot.setWorld(new PalletTown());
                } else if (w == PewterCity.class) {
                    Greenfoot.setWorld(new PewterCity());
                }
            } else if (getWorld().getClass() == Lab.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new PalletTown());
            } else if (getWorld().getClass() == PewterCity.class) {
                previousWorld = getWorld().getClass();
                if ((Door)(getOneIntersectingObject(Door.class)) == PewterCity.house1) {
                    Greenfoot.setWorld(new House());
                    whichDoor = 1;
                } else if ((Door)(getOneIntersectingObject(Door.class)) == PewterCity.house2) {
                    Greenfoot.setWorld(new House());
                    whichDoor = 2;
                } else if ((Door)(getOneIntersectingObject(Door.class)) == PewterCity.pookiemonCenter) {
                    Greenfoot.setWorld(new PookiemonCenter(false));
                } else if ((Door)(getOneIntersectingObject(Door.class)) == PewterCity.pookiemonMart) {
                    Greenfoot.setWorld(new Mart());
                } else if ((Door)(getOneIntersectingObject(Door.class)) == PewterCity.gym) {
                    Greenfoot.setWorld(new Gym());
                }
            } else if (getWorld().getClass() == PookiemonCenter.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new PewterCity());
            } else if (getWorld().getClass() == Mart.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new PewterCity());
            } else if (getWorld().getClass() == Gym.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new PewterCity());
            }
            getWorld().removeObject(door);
        }
        Actor entrance1 = getOneIntersectingObject(PalletTownToRoute1.class);
        Actor entrance2 = getOneIntersectingObject(Route1ToPewterCity.class);
        if (entrance1 != null) {
            if (getWorld().getClass() == Route1.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new PalletTown());
            } else if (getWorld().getClass() == PalletTown.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new Route1(Route1.MAX_WIDE/2 + 25, Route1.MAX_HIGH - 40));
            }
            getWorld().removeObject(entrance1);
        } else if (entrance2 != null){
            if (getWorld().getClass() == PewterCity.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new Route1(Route1.MAX_WIDE/2 + 10, 40));
            } else if (getWorld().getClass() == Route1.class) {
                previousWorld = getWorld().getClass();
                Greenfoot.setWorld(new PewterCity());
            }
            getWorld().removeObject(entrance2);
        }
        if (isTouching(TallGrass.class) && Math.random() < 0.005) {
            beforeX = getX();
            previousWorld = getWorld().getClass();
            if (Player.playerPokemonNames[0] == "Bulbasaur") {
                Greenfoot.setWorld(new Battle(0, Greenfoot.getRandomNumber(5), 0));
            } else if (Player.playerPokemonNames[0] == "Squirtle") {
                Greenfoot.setWorld(new Battle(0, Greenfoot.getRandomNumber(5), 1));
            } else if (Player.playerPokemonNames[0] == "Charmander") {
                Greenfoot.setWorld(new Battle(0, Greenfoot.getRandomNumber(5), 2));
            } else if (Player.playerPokemonNames[0] == "Articuno") {
                Greenfoot.setWorld(new Battle(0, Greenfoot.getRandomNumber(5), 3));
            } else if (Player.playerPokemonNames[0] == "Mew") {
                Greenfoot.setWorld(new Battle(0, Greenfoot.getRandomNumber(5), 4));
            } else if (Player.playerPokemonNames[0] == "Mewtwo") {
                Greenfoot.setWorld(new Battle(0, Greenfoot.getRandomNumber(5), 5));
            } else if (Player.playerPokemonNames[0] == "Moltres") {
                Greenfoot.setWorld(new Battle(0, Greenfoot.getRandomNumber(5), 6));
            } else if (Player.playerPokemonNames[0] == "Zapdos") {
                Greenfoot.setWorld(new Battle(0, Greenfoot.getRandomNumber(5), 7));
            }
        }
    }
    
    public void updateStats() {
        playerPokemonMaxHP[0] = 15 + Player.playerPokemonLevels[0] * 2;
        playerPokemonMaxHP[1] = 15 + Player.playerPokemonLevels[1] * 2;
        playerPokemonMaxHP[2] = 15 + Player.playerPokemonLevels[1] * 2;
        playerPokemonDamage[0] = playerPokemonLevels[0];
        playerPokemonDamage[1] = playerPokemonLevels[1];
        playerPokemonDamage[2] = playerPokemonLevels[2];
    }
    
    public Player(int width, int height) {
        updateImages(gender);
        setImage(playerSprites[direction]);
        screen.getImage().setTransparency(0);
        playerWidth = width;
        playerHeight = height;
    }

    public void updateImages(String gender) {
        playerSprites[0] = new GreenfootImage("Player/" + Player.gender + "Down.png");
        playerSprites[1] = new GreenfootImage("Player/" + Player.gender + "Up.png");
        playerSprites[2] = new GreenfootImage("Player/" + Player.gender + "Left.png");
        playerSprites[3] = new GreenfootImage("Player/" + Player.gender + "Right.png");
        playerSprites[4] = new GreenfootImage("Player/" + Player.gender + "DownRun.png");
        playerSprites[5] = new GreenfootImage("Player/" + Player.gender + "UpRun.png");
        playerSprites[6] = new GreenfootImage("Player/" + Player.gender + "LeftRun.png");
        playerSprites[7] = new GreenfootImage("Player/" + Player.gender + "RightRun.png");
    }

    public void playerMove() {
        int deltaX = 0;
        int deltaY = 0;
        
        if (Greenfoot.isKeyDown("right")) {
            direction = 3;
            deltaX = speed;
        } else if (Greenfoot.isKeyDown("left")) {
            direction = 2;
            deltaX = -speed;
        } else if (Greenfoot.isKeyDown("up")) {
            direction = 1;
            deltaY = -speed;
        } else if (Greenfoot.isKeyDown("down")) {
            direction = 0;
            deltaY = speed;
        }
    
        int newX = getX() + deltaX;
        int newY = getY() + deltaY;
        setLocation(newX, newY);
    
        if (isTouching(CollisionRectangle.class)) {
            setLocation(getX() - deltaX, getY() - deltaY);
        }
        
        if (deltaX != 0 || deltaY != 0) {
            frameCount++;
            if (frameCount % 30 < 15) {
                setImage(playerSprites[direction]);
            } else {
                setImage(playerSprites[direction + 4]);
            }
        } else {
            frameCount = 0;
            setImage(playerSprites[direction]);
        }
    }
    
    public boolean isTouching(Actor actor) {
        return this.intersects(actor);
    }
    
    public void levelTransition() {
        screen.getImage().scale(getWorld().getWidth(), getWorld().getHeight());
        if (!added) {
            getWorld().addObject(screen, getWorld().getWidth()/2, getWorld().getHeight()/2);
            added = true;
        }
        screen.getImage().setTransparency(screen.getImage().getTransparency() + transparencyChange);
        if (screen.getImage().getTransparency() >= 245) {
            transparencyChange = -transparencyChange;
            if (getWorld().getClass() == PlayerHouseLevelOne.class) {
                previousWorld = getWorld().getClass();
                PlayerHouseLevelTwo world = new PlayerHouseLevelTwo();
                Greenfoot.setWorld(world);
            } else if (getWorld().getClass() == PlayerHouseLevelTwo.class) {
                previousWorld = getWorld().getClass();
                PlayerHouseLevelOne world = new PlayerHouseLevelOne();
                Greenfoot.setWorld(world);
            }
        } else if (screen.getImage().getTransparency() <= 1) {
            transparencyChange = 0;
            getWorld().removeObject(screen);
        }
    }
    
    public static boolean canInteract() {
        return interactTimer < 0;
    }
    
    public static boolean interactInput() {
        return Greenfoot.isKeyDown("enter");
    }
}