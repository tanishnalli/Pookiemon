import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControllButton extends Actor
{
    public ControllButton(){
        GreenfootImage buttonImage = new GreenfootImage("controlButton.png");
        buttonImage.scale(128,16);
        setImage(buttonImage);
    }
    public void act(){
        if(Greenfoot.mouseClicked(null)){
            Actor clickedActr = Greenfoot.getMouseInfo().getActor();
            if(clickedActr instanceof ControllButton){
                Greenfoot.setWorld(new ControlWorld());
            }
        }
    }
    
    
}
