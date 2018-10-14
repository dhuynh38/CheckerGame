   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description: 
   //A king piece object that 
   //acts the same way as the normal checker piece
   //object except that it can move differently and
   //is printed differently
   
import java.awt.*;
public class KingPiece extends CheckerPiece
{
   
   //3-argument constructor
   public KingPiece(int x, int y, Color col)
   {
      super(x, y, col);
   }
   
   //Method: returns a string stating how the king piece can move
   //Preconditions: none
   //Postconditions: none, a string about how the object can move is just returned
   //@param none
   //@return a string about how the object can move
   public String movement()
   {
      return "all";
   }   
   
   //Method: draws the king piece object itself
   //Preconditions: none
   //Postconditions: the king piece is drawn on the screen
   //@param graphics object to draw with
   //@return none
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(this.getColor());
      myBuffer.fillOval(this.getX()*100+15,this.getY()*100+15,70,70);
      if(this.getColor() == Color.BLACK)
      {
         myBuffer.setColor(Color.WHITE);
      }
      else
      {
         myBuffer.setColor(Color.BLACK);
      }
      myBuffer.drawOval(this.getX()*100+15,this.getY()*100+15,70,70);
      myBuffer.fillPolygon(new int[] {this.getX()*100+50,this.getX()*100+25,this.getX()*100+75}, new int[] {this.getY()*100+20, this.getY()*100+66, this.getY()*100+66}, 3);
      myBuffer.fillPolygon(new int[] {this.getX()*100+20,this.getX()*100+25,this.getX()*100+75}, new int[] {this.getY()*100+40, this.getY()*100+66, this.getY()*100+66}, 3);
      myBuffer.fillPolygon(new int[] {this.getX()*100+80,this.getX()*100+25,this.getX()*100+75}, new int[] {this.getY()*100+40, this.getY()*100+66, this.getY()*100+66}, 3);
   }
}