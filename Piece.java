   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description:
   //A piece interface that ensures that
   //all piece objects have the ability to 
   //do all of the things it needs to do 

import java.awt.*;
public interface Piece
{
   public abstract String movement();
   public abstract void draw(Graphics myBuffer);
   public abstract int getX();
   public abstract int getY();
   public abstract Color getColor();
   public abstract void setColor(Color col);
}