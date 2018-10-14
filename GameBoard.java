   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description: 
   //A game board that has no pre-set 
   //values to it so the checker game can be 
   //easily modify by just changing the game board
   
   
import java.awt.*;
import java.util.*;
public class GameBoard 
{
   
   //private data fields
   private int row;
   private int col;
   private CheckerPiece[][] board;
   
   //2-argument constructor
   public GameBoard(int row, int col)
   {
      this.row = row;
      this.col = col;
      board = new CheckerPiece[this.row][this.col];
   }
   
   //Method: accessor method that enables other classes to access the 2d array of checker pieces
   //Preconditions: none
   //Postconditions: none, a 2d array of checker pieces is just returned
   //@param none
   //@return a 2d array of checker pieces that a gameboard contains
   public CheckerPiece[][] getBoard()
   {
      return board;
   }
   
   
   
}