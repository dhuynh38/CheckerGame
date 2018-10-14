   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description:
   //Panel class where everything is drawn 
   //and run to produce the checker game
	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
   
public class CheckerPanel extends JPanel
{
   //private objects are declared
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Timer timer;
   private CheckerBoard game;
   private ElapsedTimer timer2;
   private TurnTimer timer3;
   private int oldx, oldy, newx, newy;
   
   //panel to instantiate everything
   public CheckerPanel()
   {
      //set up the buffered image system and graphics
      myImage =  new BufferedImage(800, 900, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      
      //instantiate the need objects 
      game = new CheckerBoard();
      timer2 = new ElapsedTimer();
      timer3 = new TurnTimer(60);
      timer = new Timer(100, new Listener());
      timer.start();   
      
      //mouse interaction is added
      addMouseListener(new Mouse());
         
      //button to reset the game is created and added
      JButton reset = new JButton("New Game");
      setLayout(null);
      reset.setBounds(20, 820, 100, 30);
      reset.addActionListener(new Action());
      add(reset);
      
      //button to end a player's turn is created and added
      JButton endturn = new JButton("End Turn");
      setLayout(null);
      endturn.setBounds(150, 820, 100, 30);
      endturn.addActionListener(new Action2());
      add(endturn);
   }
      
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   
   //listener class that repaints everything at a certain amount of time    
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //black background is created
         myBuffer.setColor(Color.black);
         myBuffer.fillRect(0, 0, 900, 900);
         
         //red column at the bottom is created
         myBuffer.setColor(Color.red);
         myBuffer.fillRect(0, 800, 800, 100);
         
         //printing the board outlines and all the squares in brown
         myBuffer.setColor(new Color(219, 122, 18));
         for(int i = 0; i < 800; i+=200)
         {
            for(int j = 0; j < 800; j+=200)
            {
               myBuffer.fillRect(i, j,100,100); 
            }
         }
            
         for(int i = 100; i < 800; i+=200)
         {
            for(int j = 100; j < 800; j+=200)
            {
               myBuffer.fillRect(i, j,100,100); 
            }
         }
         
         //print the timer and start it running
         myBuffer.setColor(Color.black);
         timer2.start(myBuffer);
         timer3.start(myBuffer);
         
         //prints a text displaying whose turn it is based on the turn value
         myBuffer.setColor(Color.green);
         if (game.getTurn() == true)
         {
            myBuffer.setFont(new Font("Arial", Font.BOLD, 30));
            myBuffer.drawString("Player 1's Turn", 325, 870);
            game.move(oldx, oldy, newx, newy);
         }
         else if (game.getTurn() == false)
         {
            myBuffer.setFont(new Font("Arial", Font.BOLD, 30));
            myBuffer.drawString("Player 2's Turn", 325, 870);
            game.move(oldx, oldy, newx, newy);
         }
            
         //prints all the pieces into the screen
         game.draw(myBuffer);
         
         //conditions that checked to see if a player has won and prints the wining player
         if((game.colorExist(Color.red) == false) || (timer3.newTurn() == true && game.getTurn() == true))
         {
            myBuffer.setColor(Color.green);
            myBuffer.setFont(new Font("Arial", Font.BOLD, 75));
            myBuffer.drawString("Player 2 Wins", 100, 400);
         }
         else if((game.colorExist(Color.black) == false) || (timer3.newTurn() == true && game.getTurn() == false))
         {
            myBuffer.setColor(Color.green);
            myBuffer.setFont(new Font("Arial", Font.BOLD, 75));
            myBuffer.drawString("Player 1 Wins", 100, 400);
         }
         
         //repaints the game
         repaint();
      }
   }
   
   //class containing what will happen if button 1 is clicked  
   private class Action implements ActionListener
   {
      //these actions will be performed
      public void actionPerformed(ActionEvent e)
      {
         game = new CheckerBoard();
         timer3.resetTime(60);
         timer2.resetTime();
      }
   }
      
   //class containing what will happen if button 2 is clicked
   private class Action2 implements ActionListener
   {  
      //these actions will be performed
      public void actionPerformed(ActionEvent e)
      {
         game.changeTurn();
         timer3.resetTime(60);
      }
   }
   
   //class containing the mouse interaction and what it picks up
   private class Mouse extends MouseAdapter
   {
      //what happens when the mouse is pressed
      public void mousePressed(MouseEvent e)
      {
         oldx = (int)(e.getX()/100);
         oldy = (int)(e.getY()/100);
      }  
      
      //what happens when the mouse is released
      public void mouseReleased(MouseEvent e)
      {
         newx = (int)(e.getX()/100);
         newy = (int)(e.getY()/100);
      }   
         
   }
       
       
       
       
      
} 
