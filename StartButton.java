import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor{
    public StartButton(){
        GreenfootImage buttonImage = new GreenfootImage("StartButton.png");
        buttonImage.scale(192,32);
        setImage(buttonImage);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(null)){
            Actor clickedActr = Greenfoot.getMouseInfo().getActor();
            if(clickedActr instanceof StartButton){
                Greenfoot.setWorld(new IntroWorld());
            }
        }
    }
}
