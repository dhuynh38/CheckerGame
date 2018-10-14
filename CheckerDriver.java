   //Duy Huynh & Matthew Ki
   //AP Computer Science Project
   //May 19, 2016
   //Checker Game
   //Description:
   //A driver class that runs the panel
   //and sets up the frame and everything 
   //other aspects to make the game visible

import javax.swing.JFrame;
   
public class CheckerDriver
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Checker Game");
      frame.setSize(800, 900);
      frame.setLocation(250, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new CheckerPanel());
      frame.setVisible(true);
   }
}