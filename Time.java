   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description:
   //the interface ensures that all time objects can start 
   //running and draw itself
   
import java.awt.*;
   
public interface Time
{
   public abstract void start(Graphics myBuffer);
   public abstract void draw(Graphics myBuffer);
}