import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    public int dialogue = 0;
    public boolean aDown;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
        
    /**
     * Constructor for objects of class IntroWorld.
     * 
     */
    public IntroWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //music.play();
        makeImage();
        StartScreen.music.stop();
        ProfessorSpeechBubble professorSpeechBubble = new ProfessorSpeechBubble();
        addObject(professorSpeechBubble, getWidth()/2, 350);
    }
    
    public void act(){
        
        if(Greenfoot.isKeyDown("A") && !aDown){
            dialogue++;
            aDown = true;
        } else if(!Greenfoot.isKeyDown("A")){
            aDown = false;
        }
        
        if(dialogue == 11){
            music.stop();
            Greenfoot.setWorld(new GenderWorld());
        }
        
        makeImage();
    }
    
    public void makeImage(){
        removeObjects(getObjects(Text.class));
        
        if(dialogue == 0){
            GreenfootImage introImage = new GreenfootImage("Oak1.png");
            introImage.scale(getWidth(), getHeight()); 
            setBackground(introImage);
        } else if(dialogue == 1){
            GreenfootImage introImage = new GreenfootImage("Oak1.png");
            introImage.scale(getWidth(), getHeight()); 
            setBackground(introImage);
            
            addObject(new Text("Hello, there!"), getWidth()/2 -106, 335);
            addObject(new Text("Glad to meet you!"), getWidth()/2 - 83, 360);
        }else if (dialogue == 2){
            GreenfootImage introImage = new GreenfootImage("Oak1.png");
            introImage.scale(getWidth(), getHeight()); 
            setBackground(introImage);
            
            
            addObject(new Text("Welcome to the world of Pookiémon!"), getWidth()/2 - 5 , 335);
            
        } else if (dialogue == 3){
            GreenfootImage introImage = new GreenfootImage("Oak1.png");
            introImage.scale(getWidth(), getHeight()); 
            setBackground(introImage);
            
            addObject(new Text("My name is OAK."), getWidth()/2 - 85, 335);
        } else if (dialogue == 4){
            GreenfootImage introImage = new GreenfootImage("Oak1.png");
            introImage.scale(getWidth(), getHeight()); 
            setBackground(introImage);
            
            addObject(new Text("People affectionately refer to me"), getWidth()/2 - 23, 335);
            addObject(new Text("as the Pookiémon PROFESSOR."), getWidth()/2 - 30, 360);
        } else if (dialogue == 5){
            GreenfootImage introImage2 = new GreenfootImage("Oak2.png");
            introImage2.scale(getWidth(), getHeight()); 
            setBackground(introImage2);
            
            addObject(new Text("This world..."), getWidth()/2 - 105, 335);
        } else if (dialogue == 6){
            GreenfootImage introImage3 = new GreenfootImage("Oak3.png");
            introImage3.scale(getWidth(), getHeight()); 
            setBackground(introImage3);
            
            addObject(new Text("...is inhabited far and wide by"), getWidth()/2 - 30, 335);
            addObject(new Text("creatures called Pookiémon."), getWidth()/2 - 38, 360);
            
        } else if (dialogue == 7){
            GreenfootImage introImage3 = new GreenfootImage("Oak3.png");
            introImage3.scale(getWidth(), getHeight()); 
            setBackground(introImage3);
            
            addObject(new Text("For some people, Pookiémon are pets."), getWidth()/2, 335);
            addObject(new Text("Others use them for battling."), getWidth()/2 - 35, 360);
        } else if (dialogue == 8){
            GreenfootImage introImage3 = new GreenfootImage("Oak3.png");
            introImage3.scale(getWidth(), getHeight()); 
            setBackground(introImage3);
        
            addObject(new Text("As for myself... "), getWidth()/2 - 90, 335);
        } else if (dialogue == 9){
            GreenfootImage introImage2 = new GreenfootImage("Oak2.png");
            introImage2.scale(getWidth(), getHeight()); 
            setBackground(introImage2);
            
            addObject(new Text("I study Pookiémon as a profession."), getWidth()/2 - 12, 335);
        } else if (dialogue == 10){
            GreenfootImage introImage = new GreenfootImage("Oak1.png");
            introImage.scale(getWidth(), getHeight()); 
            setBackground(introImage);
            
            addObject(new Text("But first, tell me a little about"), getWidth()/2 - 38, 335);
            addObject(new Text("yourself."), getWidth()/2 - 121, 360);
        } 
        
        
    }
}
