/**
* GUI Class
* displays images of cards, who won round,
* and current score
*
* @author Aidan Goldman
**/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private JButton button;
   private JLabel pic1,pic2, whoWon, score;
   private ImageIcon front1,back1,front2,back2;
   
   private static final int MAX_HAND_SIZE = 50,
                            ZER0 = 0,
                            ONE = 1;
   public static WarGame2 wg;

   private static int counter1 = ZER0,
                      counter2 = ZER0;
   private static String suit, rank;
   
   /**
   *Constructor to create all the necesssary
   *components and add them to the frame
   /**
   *@param String of the title of the frame
   *@return
   **/
   public WarGUI(String s)
   {
      super(s);
      
      setLayout(new BorderLayout(5, 5));
      button = new JButton("flip");
      button.addActionListener(new ButtonListener());
      add(button, BorderLayout.CENTER);
            
      wg = new WarGame2();
      front1 = new ImageIcon(getCard1());
      back1 = new ImageIcon("back.jpg");
      pic1 = new JLabel(back1);     
      add(pic1, BorderLayout.WEST);
      
      front2 = new ImageIcon(getCard2());
      back2 = new ImageIcon("back copy.jpg");
      pic2 = new JLabel(back2);     
      add(pic2, BorderLayout.EAST);
            
      whoWon = new JLabel("    Who Won    ");
      whoWon.setForeground(Color.lightGray);
      add(whoWon, BorderLayout.SOUTH);

      score = new JLabel("        Score       ");
      score.setForeground(Color.lightGray);
      add(score, BorderLayout.NORTH);
   
   }
   
   /**
   *Method to get the filename for image 
   *of a card from player one's hand
   *
   *@param none
   *@return String of filename of card image
   **/
   public static String getCard1()
   {
      counter1 = wg.hand1.size();
      if(counter1 >= MAX_HAND_SIZE)
         wg.testBigger();
         
      Card card1 = wg.hand1.get(--counter1);
      int s = card1.suit;
      int r = card1.rank;
      switch(s)
      {
         case 1:
            suit = "s";
            break;
         case 2:
            suit = "c";
            break;
         case 3:
            suit = "h";
            break;
         case 4:
            suit = "d";
            break;
      }
      getRank(wg.hand1, counter1);
      return rank+suit+".jpg";
   }
   /**
   *Method to get the filename for image 
   *of a card from player two's hand
   *
   *@param none
   *@return String of filename of card image
   **/
   public static String getCard2()
   {
      counter2 = wg.hand2.size();
      if(counter2 >= MAX_HAND_SIZE)
         wg.testBigger();
      Card card2 = wg.hand2.get(--counter2);
      int s = card2.suit;
      switch(s)
      {
         case 1:
            suit = "s copy";
            break;
         case 2:
            suit = "c copy";
            break;
         case 3:
            suit = "h copy";
            break;
         case 4:
            suit = "d copy";
            break;
      }
      getRank(wg.hand2, counter2);
      return rank+suit+".jpg";
   }
   /**
   *Method to get the number value of any card in a
   *pile
   *
   *@param <Card> ArrayList called hand to 
   *@return String of filename of card image
   **/
   public static void getRank(ArrayList <Card> hand, int counter)
   {
      //counter = hand.size();
      Card card = hand.get(counter-ONE);
      int r = card.rank;
      switch(r)
      {
         case 1:
            rank = "ace";
            break;
         case 2:
            rank = "2";
            break;
         case 3:
            rank = "3";
            break;
         case 4:
            rank = "4";
            break;
         case 5:
            rank = "5";
            break;
         case 6:
            rank = "6";
            break;
         case 7:
            rank = "7";
            break;
         case 8:
            rank = "8";
            break;
         case 9:
            rank = "9";
            break;
         case 10:
            rank = "10";
            break;
         case 11:
            rank = "jack";
            break;
         case 12:
            rank = "queen";
            break;
         case 13:
            rank = "king";
            break;
      }

   }
   /**
   *Class to handle button press action
   *
   *@param none
   *@return String of filename of card image
   **/
   class ButtonListener implements ActionListener
   {
      /**
      *method to handle action of button press
      *sets the front image using getCard methods
      *determines winner or war
      *ends game if index out of bounds error OR if
      *one player has more than 52 cards
      *
      *@param none
      *@return String of filename of card image
      **/
      public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException
      {
         try
         {
            front1 = new ImageIcon(getCard1());
            front2 = new ImageIcon(getCard2());
            pic1.setIcon(front1);
            pic2.setIcon(front2);
            
            wg.playerOne = new Deck2(wg.hand1);
            wg.playerTwo = new Deck2(wg.hand2);
            wg.playerOne.resetDeckSize();
            wg.playerTwo.resetDeckSize();
            int current1 = ZER0+wg.playerOne.ct;
            int current2 = ZER0+wg.playerTwo.ct;
            
            if((wg.playerOne.ct+wg.playerTwo.ct)>MAX_HAND_SIZE)
               throw new IndexOutOfBoundsException();
            if(wg.playerOne.ct>=MAX_HAND_SIZE)
            {
                whoWon = new JLabel("PLAYER 1 WINS GAME");
                add(whoWon, BorderLayout.CENTER);
            }
            else if(wg.playerTwo.ct>=MAX_HAND_SIZE)
            {
                whoWon = new JLabel("PLAYER 2 WINS GAME");
                add(whoWon, BorderLayout.CENTER);
            }
   
            
            if(pic1.getIcon()==back1)
            {
               whoWon.setVisible(false);
               whoWon = new JLabel("WAR");
               whoWon.setVisible(true);
               add(whoWon, BorderLayout.PAGE_START);
               
               pic1.setIcon(front1);
               pic2.setIcon(front2);
               front1 = new ImageIcon(getCard1());
               front2 = new ImageIcon(getCard2());
            }
            int win = wg.winner(wg.hand1.get(current1),wg.hand2.get(current2));
            
            //PLAYER1 WINS
            if (win == -ONE)
            {
               score.setVisible(false);
               wg.playerOne.resetDeckSize();
               wg.playerTwo.resetDeckSize();
               score = new JLabel("player 1: " + wg.playerOne.ct + "\nplayer 2: " + wg.playerTwo.ct);
               score.setVisible(true);
                  
               whoWon.setVisible(false);
               whoWon = new JLabel("Player 1 wins");
               whoWon.setVisible(true);
      
               add(score, BorderLayout.PAGE_END);
               add(whoWon, BorderLayout.PAGE_START);
            }
            //PLAYER2 WINS
            else if (win == ONE)
            {
               score.setVisible(false);
               wg.playerOne.resetDeckSize();
               wg.playerTwo.resetDeckSize();
               score = new JLabel("player 1: " + wg.playerOne.ct + "\nplayer 2: " + wg.playerTwo.ct);
               score.setVisible(true);
                  
               whoWon.setVisible(false);
               whoWon = new JLabel("Player 2 wins");
               whoWon.setVisible(true);
                                             
               add(score, BorderLayout.PAGE_END);
               add(whoWon, BorderLayout.PAGE_START);
            }
            //WAR//   
            else
            {
               whoWon.setVisible(false);
               whoWon = new JLabel("WAR");
               whoWon.setVisible(true);
              
               score.setVisible(false);
               wg.playerOne.resetDeckSize();
               wg.playerTwo.resetDeckSize();
               score = new JLabel("player 1: " + wg.playerOne.ct + "\nplayer 2: " + wg.playerTwo.ct);
               score.setVisible(true);
               
               add(score, BorderLayout.PAGE_END);
               add(whoWon, BorderLayout.PAGE_START);
               win = wg.war();
               if (win == -ONE) //player1 wins
               {
                  score.setVisible(false);
                  wg.playerOne.resetDeckSize();
                  wg.playerTwo.resetDeckSize();
                  score = new JLabel("player 1: " + wg.playerOne.ct + "\nplayer 2: " + wg.playerTwo.ct);
                  score.setVisible(true);
                  
                  whoWon.setVisible(false);
                  whoWon = new JLabel("Player 1 wins");
                  whoWon.setVisible(true);
               
                  add(score, BorderLayout.PAGE_END);
                  add(whoWon, BorderLayout.PAGE_START);
                  pic1.setIcon(back1);
                  pic2.setIcon(back2);
               }
               else if (win == ONE) //player2 wins
               {
                  score.setVisible(false);
                  wg.playerOne.resetDeckSize();
                  wg.playerTwo.resetDeckSize();               
                  score = new JLabel("player 1: " + wg.playerOne.ct + "\nplayer 2: " + wg.playerTwo.ct);
                  score.setVisible(true);
                  
                  whoWon.setVisible(false);
                  whoWon = new JLabel("Player 2 wins");
                  whoWon.setVisible(true);
                          
                  add(score, BorderLayout.PAGE_END);
                  add(whoWon, BorderLayout.PAGE_START);
                  pic1.setIcon(back1);
                  pic2.setIcon(back2);
               }   
   
               
            }
                       
         }  
         catch(IndexOutOfBoundsException outtaBounds)
         {
            wg.testBigger();
         }

      }


   }
   
   /**
   *Main Method
   *
   *
   *@param array of strings
   *@return void
   **/
   public static void main(String [] args)
   {
      JFrame frame = new WarGUI("-- WAR GAME --");
      frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}