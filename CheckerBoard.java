   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description:
   //A more sophisticated game board
   //with predefiend 8 by 8 size board
   //it can't change and can only be used to play 
   //checker. It has the methods to move the pieces within it 
   //and print itself
   
import java.awt.*;
import java.util.*;
public class CheckerBoard extends GameBoard 
{
   //private data fields
   private CheckerPiece[][] cboard = getBoard(); //so that getBoard is not needed to be called every time to acces a new board                                             
   private boolean turn;                         //it makes everything easily to understand for convenience 
   
   //default constructor
   public CheckerBoard()
   {
      super(8, 8);
      turn = true;
      
      for (int i = 0; i < cboard.length; i+= 2)
      {
         for (int j = 1; j < cboard[0].length; j+= 2)
         {
            if (i == 0 || i == 2)
            {
               cboard[i][j] = new CheckerPiece(j, i, Color.black);
            }
            else if (i == 6)
            {
               cboard[i][j] = new CheckerPiece(j, i, Color.red);
            }
         }
      }
      
      for (int i = 1; i < cboard.length; i+= 2)
      {
         for (int j = 0; j < cboard[0].length; j+= 2)
         {
            if (i == 1)
            {
               cboard[i][j] = new CheckerPiece(j, i, Color.black);
            }
            else if (i == 5 || i == 7)
            {
               cboard[i][j] = new CheckerPiece(j, i, Color.red);
            }
         }
      }
   
   }
   
   //Method: instantiates a checkerpiece within the board at the new location by using the old
   //location to make sure the checker piece itself can move into the next location
   //Preconditions: none
   //Postconditions: if it meets all the requirement, the checker piece will be moved into the new location
   //@param x location of checker piece before it is going to be moved
   //@param y location of checker piece before it is going to be moved
   //@param x location of where the checker piece should be moved to
   //@param y location of where the checker piece should be moved to
   //@return none
   public void move(int oldx, int oldy, int newx, int newy)
   {
      if (cboard[oldy][oldx] != null && Math.abs(oldx-newx) < 3 && Math.abs(oldy-newy) < 3 && cboard[oldy][oldx].movement().equals("forward"))
      {
         Color col = cboard[oldy][oldx].getColor();
         if((turn == true && col == Color.red) || (turn == false && col == Color.black))
         {
            if ((col == Color.red && newy < oldy) || (col == Color.black && newy > oldy))
            {
               if(Math.abs(oldx-newx) != 0 && Math.abs(oldy-newy) != 0)
               {
                  if(Math.abs(oldx-newx) < 2 && Math.abs(oldy-newy) < 2) //1 or no distance
                  {
                     if(cboard[newy][newx] == null)
                     {
                        if((col == Color.red && newy == 0) || (col == Color.black && newy == 7))
                        {
                           cboard[newy][newx] = new KingPiece(newx, newy, col);
                        }
                        else
                        {
                           cboard[newy][newx] = new CheckerPiece(newx, newy, col);
                        }
                        cboard[oldy][oldx] = null;
                     }
                  }
                  else //2 distance
                  {
                     int midx = (oldx+newx)/2;
                     int midy = (oldy+newy)/2;
                     if(cboard[midy][midx] != null && cboard[newy][newx] == null && cboard[midy][midx].getColor() != col)
                     {
                        if((col == Color.red && newy == 0) || (col == Color.black && newy == 7))
                        {
                           cboard[newy][newx] = new KingPiece(newx, newy, col);
                        }
                        else
                        {
                           cboard[newy][newx] = new CheckerPiece(newx, newy, col);
                        }
                        cboard[midy][midx] = null;
                        cboard[oldy][oldx] = null;
                     }
                  }
               }
            }
         }
      }
      else if (cboard[oldy][oldx] != null && Math.abs(oldx-newx) < 3 && Math.abs(oldy-newy) < 3 && cboard[oldy][oldx].movement().equals("all"))
      {  
         Color col = cboard[oldy][oldx].getColor();
         if((turn == true && col == Color.red) || (turn == false && col == Color.black))
         {
            if(Math.abs(oldx-newx) != 0 && Math.abs(oldy-newy) != 0)
            {
               if(Math.abs(oldx-newx) < 2 && Math.abs(oldy-newy) < 2) //1 or no distance
               {
                  if(cboard[newy][newx] == null)
                  {
                     cboard[newy][newx] = new KingPiece(newx, newy, col);
                     cboard[oldy][oldx] = null;
                  }
               }
               else //2 distance
               {
                  int midx = (oldx+newx)/2;
                  int midy = (oldy+newy)/2;
                  if(cboard[midy][midx] != null && cboard[newy][newx] == null && cboard[midy][midx].getColor() != col)
                  {
                     cboard[newy][newx] = new KingPiece(newx, newy, col);
                     cboard[midy][midx] = null;
                     cboard[oldy][oldx] = null;
                  }
               }
            }
         }  
      }
   }
   
   //Method: changes the value of the turn boolean to show a change in 
   //the turn of the player who is suppose to be making a move 
   //Preconditions: none
   //Postconditions: boolean turn is changed or modified 
   //@param none
   //@return none
   public void changeTurn()
   {
      if (turn == true)
      {
         turn = false;
      }
      else
      {
         turn = true;
      }
   }
   
   //Method: accessor method that enable other classes to access the boolean turn, if boolean is 
   //true than its player 1's turn and false if it's player 2's turn 
   //Preconditions: none 
   //Postconditions: none a boolean regarding whose turn it is is returned
   //@param none
   //@return a boolean, true or false based on the current player
   public boolean getTurn()
   {
      return turn;
   }
   
   //Method: checks to see is a color still exists in the 2d array, returns true if the color still exists and false otherwise
   //Preconditions: none
   //Postconditions: none, a boolean is just returned
   //@param color to that the method will be checking for
   //@return a boolean regarding whether a color still exists. True if it still exists within the 2d array
   public boolean colorExist(Color col)
   {
      for (int i = 0; i < cboard.length; i++)
      {
         for (int j = 0; j < cboard[0].length; j++)
         {  
            if(cboard[i][j] != null && cboard[i][j].getColor() == col)
            {
               return true; 
            }
         }
      }
      return false;
   } 
   
   //Method: draws the entire board by going through and seeing what checkerpieces exist and draw those
   //Preconditions: none
   //Postconditions: every piece within the 2d array or the object is drawn
   //@param graphics object to draw with
   //@return none
   public void draw(Graphics myBuffer)
   {
      for (int i = 0; i < cboard.length; i++)
      {
         for (int j = 0; j < cboard[0].length; j++)
         {  
            if(cboard[i][j] != null)
            {
               CheckerPiece piece = cboard[i][j];
               piece.draw(myBuffer);
            }
         }
      }
   }
   
   
}