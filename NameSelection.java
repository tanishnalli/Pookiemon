import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NameSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameSelection extends World {
    ChooseNamePerson person = new ChooseNamePerson("boy");
    static String name = "";
    boolean keyDown = false;
    Text text = new Text("Enter Name:");
    Text text2 = new Text("Press Enter to Continue");
    Text text3 = new Text("Clear");
    CollisionRectangle screen = new CollisionRectangle();
    int transparencyChange = 4;
    boolean done = false;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    public NameSelection(String gender) {   
        super(600, 400, 1);
        
        name = "";
        addCollisionRectangle(getWidth()/2, getHeight()/2, getWidth(), getHeight(), Color.WHITE);
        if ((gender.toLowerCase()).equals("girl")) {
            person = new ChooseNamePerson("girl");
        }
        addObject(person, 3 * getWidth()/4, getHeight()/2);
        //showText(name, getWidth()/4, getHeight()/4);
        addObject(text, getWidth()/4, getHeight()/5 - 20);
        addObject(text2, getWidth()/4, getHeight()/5 + 110);
        addObject(text3, getWidth()/4, getHeight()/5 + 60);
        
    }
    
    public void act() {
        if (done) {
            //if (screen.getImage().getTransparency() < 245) {
            //    screen.getImage().setTransparency(screen.getImage().getTransparency() + transparencyChange);
            //} else {
            //    this.removeObject(screen);
            //    Greenfoot.setWorld(new PlayerHouseLevelTwo());
            //}
        } else if (Greenfoot.mouseClicked(text3)) {
            name = "";
        } else if (Greenfoot.isKeyDown("BACKSPACE") && name.length() > 0) {
            if(!keyDown){
               name = name.substring(0, name.length() - 1); 
            }
            keyDown = true;
        } else if (Greenfoot.isKeyDown("A") && name.length() <= 6) {
            if(!keyDown){
               name+="A"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("B") && name.length() <= 6) {
            if(!keyDown){
               name+="B"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("C") && name.length() <= 6) {
            if(!keyDown){
               name+="C"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("D") && name.length() <= 6) {
            if(!keyDown){
               name+="D"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("E") && name.length() <= 6  ) {
            if(!keyDown){
               name+="E"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("F") && name.length() <= 6  ) {
            if(!keyDown){
               name+="F"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("G") && name.length() <= 6  ) {
            if(!keyDown){
               name+="G"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("H") && name.length() <= 6  ) {
            if(!keyDown){
               name+="H"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("I") && name.length() <= 6  ) {
            if(!keyDown){
               name+="I"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("J") && name.length() <= 6  ) {
            if(!keyDown){
               name+="J"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("K") && name.length() <= 6  ) {
            if(!keyDown){
               name+="K"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("L") && name.length() <= 6  ) {
            if(!keyDown){
               name+="L"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("M") && name.length() <= 6  ) {
            if(!keyDown){
               name+="M"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("N") && name.length() <= 6  ) {
            if(!keyDown){
               name+="N"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("O") && name.length() <= 6  ) {
            if(!keyDown){
               name+="O"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("P") && name.length() <= 6  ) {
            if(!keyDown){
               name+="P"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("Q") && name.length() <= 6  ) {
            if(!keyDown){
               name+="Q";
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("R") && name.length() <= 6  ) {
            if(!keyDown){
               name+="R"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("S") && name.length() <= 6  ) {
            if(!keyDown){
               name+="S"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("T") && name.length() <= 6  ) {
            if(!keyDown){
               name+="T"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("U") && name.length() <= 6  ) {
            if(!keyDown){
               name+="U"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("V") && name.length() <= 6  ) {
            if(!keyDown){
               name+="V"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("W") && name.length() <= 6  ) {
            if(!keyDown){
               name+="W"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("X") && name.length() <= 6  ) {
            if(!keyDown){
               name+="X"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("Y") && name.length() <= 6  ) {
            if(!keyDown){
               name+="Y"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("Z") && name.length() <= 6  ) {
            if(!keyDown){
               name+="Z"; 
            }

            keyDown = true;
        } else if (Greenfoot.isKeyDown("enter") && name.length() >= 1) {
            name = name.toUpperCase().charAt(0) + name.toLowerCase().substring(1, name.length());
            Greenfoot.setWorld(new PlayerHouseLevelTwo());
            //done = true;
            //screen.getImage().setTransparency(0);
            //screen.getImage().scale(getWidth(), getHeight());
            //addObject(screen, getWidth()/2, getHeight()/2);
        } else {
            keyDown = false;
        }
        if (!done) {
            showText(name, getWidth()/4, getHeight()/4);
        }
    }
    
    public void addCollisionRectangle(int x, int y, int width, int height, Color color) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setColor(color);
        collisionRectangle.getImage().fill();
        addObject(collisionRectangle, x, y);
    }
}
