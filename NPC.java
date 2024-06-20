import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPC extends Actor{
    Player player;
    int playerX;
    int playerY;
    
    GreenfootImage[] sprites = new GreenfootImage[8];
    
    boolean changeText;
    boolean selfAffects;
    
    String[] texts1;
    String[] texts2;
    
    String item;
    String type;
    boolean itemWasGiven;
    
    int number;
    
    int turnTime;
    int itemTime;
    
    int index;
    
    int randomTime;
    
    int center = 15;
    
    int direction;  
    public NPC(String name, String[] texts1, String[] texts2, boolean changeText, boolean selfAffects, String type, String item, int number, int direction, int index){
        sprites[0] = new GreenfootImage("NPC/" + name + "/Down.png");
        sprites[1] = new GreenfootImage("NPC/" + name + "/Up.png");
        sprites[2] = new GreenfootImage("NPC/" + name + "/Left.png");
        sprites[3] = new GreenfootImage("NPC/" + name + "/Right.png");
        if(!type.equals("still") && !type.equals("turn"))
        {
            sprites[4] = new GreenfootImage("NPC/" + name + "/DownRun.png");
            sprites[5] = new GreenfootImage("NPC/" + name + "/UpRun.png");
            sprites[6] = new GreenfootImage("/NPC/" + name + "/LeftRun.png");
            sprites[7] = new GreenfootImage("/NPC/" + name + "/RightRun.png");
        }
        
        for(int i = 0; i < 8; i++){
            if(sprites[i] != null){
                sprites[i].scale(48,48);
            }
        }
        
        setImage(sprites[direction]);
        
        this.texts1 = texts1;
        this.texts2 = texts2;
        this.changeText = changeText;
        this.selfAffects = selfAffects;
        this.type = type;
        this.item = item;
        this.number = number;
        this.index = index;
        itemWasGiven = changeText;
        randomTime = Greenfoot.getRandomNumber(50);
    }
    
    @Override
    protected void addedToWorld(World world) {
        player = (Player) world.getObjects(Player.class).get(0);
        playerX = getPlayerX();
        playerY = getPlayerY();
    }
    
    public void act(){
        
    }
    
    
        public int getPlayerX() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        return player.getX();
    }
    
    public int getPlayerY() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        return player.getY();
    }
    
    public void facePlayer()
    {
        if(playerY - getY() > 10)
            setImage(sprites[0]);
        else if(playerY - getY() < -30)
            setImage(sprites[1]);
        else if(playerX - getX() < -10)
            setImage(sprites[2]);
        else if(playerX - getX() > 10)
            setImage(sprites[3]);
    }
    
    

    public boolean isInRange() {
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        
        double imageHalfWidth = getImage().getWidth() / 2;
        double imageHalfHeight = getImage().getHeight() / 2;
        double playerImageHalfWidth = player.getImage().getWidth() / 2;
        double playerImageHalfHeight = player.getImage().getHeight() / 2;
    
        boolean isXInRange = Math.abs(playerX - getX()) < imageHalfWidth + playerImageHalfWidth + 5;
        boolean isYInRange = Math.abs(playerY - getY()) < imageHalfHeight + playerImageHalfHeight + 3;
    
        if (isXInRange && isYInRange) {
            if (playerY - getY() <  + 2 && playerY > getY()) {
                return true;
            } else if (getY() > imageHalfHeight + playerY + playerImageHalfHeight - 2) {
                return true; 
            } else if (playerX < getX()) {
                return true; 
            } else if (playerX > getX()) {
                return true;
            }
        }
        return false;
    }
    
    public void turn(){
        if(randomTime < 0){
            turnTime--;
            if(turnTime == -1){
                setImage(sprites[Greenfoot.getRandomNumber(4)]);
                turnTime = 74;
            }
        }
        
        if(turnTime % 75 == 0 && Player.interactInput() && Player.canInteract()){
            turnTime--;
        } else if(turnTime % 75 == 0 && turnTime != 0) {
            turnTime++;
        }
    }

    private void handleItemInteraction() {
        if(itemTime == 1 && Player.interactInput()) {
            //addObjectAndHandleInteractTimer(new OverlayText(new String[] {"You received " + number + " " + item + "(s)."}, 75));
            //DataInventory.addItem(item, number);
        } else if(itemTime == 1) {
            itemTime++;
        }
        
        if(itemTime % 75 == 0 && Player.interactInput()) {
            itemTime--;
        } else if(itemTime % 75 == 0) {
            itemTime++;
        }
    }
    
    
    private void addObjectAndHandleInteractTimer(OverlayText overlayText) {
        //getWorld().addObject(overlayText, textX, textY);
        Player.interactTimer = 10;
        itemWasGiven = true;
    } 
    
    
    
    private void interact() {
        if(isInRange() && Player.interactInput() && Player.canInteract()) {
            if(!changeText) {
                //addObjectAndHandleInteractTimer(new OverlayText());
                if(type.equals("turn")) {
                    turnTime = texts1.length * 75 + 75;
                }
            } else if(item != null && itemWasGiven) {
                //addObjectAndHandleInteractTimer(new OverlayText(texts2, 75));
                if(type.equals("turn")) {
                    turnTime = texts2.length * 75 + 75;
                }
            } else if(item == null) {
                
                if(type.equals("turn")) {
                    turnTime = texts2.length * 75 + 75;
                }
            }
            
            if(item != null && !changeText) {
                itemTime = texts1.length * 75;
            }
            
            if(texts2 != null && selfAffects) {
                changeText = true;
                
                String worldClassName = getWorld().getClass().getName();
                if(worldClassName.equals("WorldRoute113")) {
                    Route1.npcDone[index] = true;
                } else if(worldClassName.equals("WorldTownTrash")) {
                    PalletTown.npcDone[index] = true;
                } else if(worldClassName.equals("WorldCenterTownTrash")) {
                    PalletTown.npcDone[index] = true;
                }
            }
             if (isInRange() && Player.interactInput() && Player.canInteract()) {
                String[] texts = changeText ? texts2 : texts1;
                displayDialogue(texts);
                Player.interactTimer = 10;
                changeText = !changeText;

            }
            
            facePlayer();
            Player.speed = 0;
            Player.interactTimer = 5;
        }
    }
    
    private void displayDialogue(String[] texts) {
        World world = getWorld();
        for (int i = 0; i < texts.length; i++) {
            world.showText(texts[i], world.getWidth() / 2, world.getHeight() - 50);
            
        }
        world.showText("", world.getWidth() / 2, world.getHeight() - 50);
    }
}
