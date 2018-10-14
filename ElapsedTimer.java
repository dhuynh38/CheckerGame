   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description:
   //the object records how long the game has been running
   //and resets every new game
   
import java.awt.*;
import java.util.*;
   
public class ElapsedTimer implements Time
{
   //private static data fields 
   private static double secondsPassed;
   private static double minutesPassed;
   private static double hoursPassed;
   
   //default constructor 
   public ElapsedTimer()
   {
      secondsPassed = 0;
      minutesPassed = 0;
      hoursPassed = 0;
   }
   
   //Method: resets the time to zero
   //Preconditions: none
   //Postconditions: all of the data fields are changed to zero
   //@param none
   //@return none
   public void resetTime()
   {
      secondsPassed = 0;
      minutesPassed = 0;
      hoursPassed = 0;
   }
   
   //Method: increments the seconds data field by a given value
   //Preconditions: none
   //Postconditions: data fields are changed according to given value
   //@param a double to increment by 
   //@return none
   private static void increaseTime(double x)
   {
      secondsPassed += x;
      if (secondsPassed == 60)
      {
         secondsPassed = 0;
         minutesPassed++;
      }
      else if (minutesPassed == 60)
      {
         minutesPassed = 0;
         hoursPassed++;
      }
   }
   
   //Method: draws the timer object visually
   //Preconditions: none
   //Postconditions: image of the timer is drawn by the graphics
   //@param graphics object to draw with
   //@return none
   public void draw(Graphics myBuffer)
   {
      myBuffer.setFont(new Font("Arial", Font.BOLD, 20));
      myBuffer.drawString("Elasped Time:    " + (int)hoursPassed + ":" + (int)minutesPassed + ":" + (int)secondsPassed, 500, 820);
   }
   
   //Method: starts the timer so that it increases with time and prints the object every time it is called
   //Preconditions: none
   //Postconditions: the private data fields are changed and the object is printed
   //@param graphics object to draw with
   //@return none
   public void start(Graphics myBuffer)
   {
      draw(myBuffer);
      increaseTime(.1);
   }
   
}
   
