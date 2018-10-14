   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description:
   //A normal checkerpiece that 
   //has its own color and coordinates
   //and it is moved around the board to 
   //play checkers
   
import java.awt.*;
public class CheckerPiece implements Piece
{
   //private data fields
   private int x;
   private int y;
   private Color color;
   
   //3-argument constructor
   public CheckerPiece(int x, int y, Color col)
   {
      this.x = x;
      this.y = y;
      this.color = col;
   }
   
   //Method: returns a string about how the piece can move
   //Preconditions: none
   //Postconditions: none, a string is just returned
   //@param none
   //@return string about how the pieces can move
   public String movement()
   {
      return "forward";
   }   
   
   //Method: accesor method that returns the x value of the checker piece
   //Preconditions: none
   //Postconditions: none, a x value is just returned
   //@param none
   //@return x value of the checker piece
   public int getX()
   {
      return x;
   }
   
   //Method: accessor method that returns the y value of the checker piece
   //Preconditions: none 
   //Postconditions: none, a y value is just returned
   //@param none
   //@return y value of the checker piece
   public int getY()
   {
      return y;
   }
   
   //Method: accessor method that returns the color of the checker piece
   //Preconditions: none
   //Postconditions: none, a color is just returned
   //@param none
   //@return color of the checker piece is returned
   public Color getColor()
   {
      return this.color;
   }
   
   //Method: sets a new color to a piece object
   //Preconditions: none
   //Postconditions: the data field of the checker piece is changed to match the input value
   //@param new color to change the data field to
   //@return none
   public void setColor(Color col)
   {
      this.color = col;
   }
   
   //Method: draws the checker piece itself on the screen
   //Preconditions: none
   //Postconditions: a checkerpiece is drawn on the screen
   //@param graphics object to draw with
   //@return none
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(this.color);
      myBuffer.fillOval(this.x*100+15,this.y*100+15,70,70);
      if(color == Color.BLACK)
      {
         myBuffer.setColor(Color.WHITE);
      }
      else
      {
         myBuffer.setColor(Color.BLACK);
      }
      myBuffer.drawOval(this.x*100+15,this.y*100+15,70,70);
   }
}