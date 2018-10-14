   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description:
   //the object counts down to 0 from a set 
   //value when a new turn is started
   
import java.awt.*;
import java.util.*;
   
public class TurnTimer extends ElapsedTimer
{
   //private static data field different from other one since
   //it is staic and specific to turnTimer
   private static double secondsPassed;
   
   //1-argument constructor
   public TurnTimer(double sec)
   {
      secondsPassed = sec;
   }
   
   //Method: decreases the data field by the given value
   //Preconditions: none
   //Postconditions: data field changed by the given value
   //@param a double to decrease by 
   //@return none
   private static void decreaseTime(double x)
   {
      secondsPassed -= x;
   }
   
   //Method: runs the timer object by drawing it and incrementing the timer
   //every time the method is called
   //Preconditions: none
   //Postconditions: 
   //@param graphics object to draw with 
   //@return none
   public void start(Graphics myBuffer)
   {
      draw(myBuffer);
      decreaseTime(.1);
   }
   
   //Method: checks to see if a new turn should be given. If true then 
   //the current player's turn is over
   //Preconditions: none
   //Postconditions: none
   //@param none
   //@return true or false based on the current data field
   public boolean newTurn()
   {
      if (secondsPassed < 0)
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
   
   //Method: resets the timer to a certain time and let it countdown again
   //Preconditions: none
   //Postconditions: data fields of the timer object is changed
   //@param a double seconds to start at again
   //@return none
   public void resetTime(double sec)
   {
      secondsPassed = sec;
   }
   
   //Method: displays the timer object
   //Preconditions: none
   //Postconditions: a timer object is drawn
   //@param a graphics object to draw with
   //@return none
   public void draw(Graphics myBuffer)
   {
      myBuffer.setFont(new Font("Arial", Font.BOLD, 20));
      myBuffer.drawString("Time Left To Move:    " + (int)secondsPassed + " seconds", 50, 820);
   }
   
   
}