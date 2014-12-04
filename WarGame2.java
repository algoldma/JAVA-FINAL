/**
* WarGame Class
* methods to run the gameand compare cards
* creates two hands
* 
*@author Aidan Goldman
**/
import java.util.*;
public class WarGame2
{
   private static final int CARDS_IN_DECK = 52,
                            TWO = 2,
                            ONE = 1,
                            ZERO = 0,
                            MAX_SIZE = 1500;
   public static ArrayList<Card> hand1 = new ArrayList<Card>();
   public static ArrayList<Card> hand2 = new ArrayList<Card>();
   public static Deck2 playerOne,
                        playerTwo;
   /**
   *Constructor
   *creates a shuffled deck and splits it
   *into two hands (arraylists)
   *
   *@param none
   *@return none
   **/
   public WarGame2()
   {
      Deck2 d = new Deck2(); //create new fresh deck
      d.shuffle(); //randomize order      
      //get hands into list
      for(int i = ZERO; i<(CARDS_IN_DECK/TWO) ;i++)
      {
         hand1.add(i, d.dealCard());
         hand2.add(i, d.dealCard());
      }

   }
   /**
   *method to test who is the winner in the event of
   *a war
   *
   *@param none
   *@return int to determine who won (0 = war, -1 = player1 wins, +1 = player2 wins)
   **/
   public static int war()
   {     
      //deal 2 cards face down and then 2 face up
      Card cardOneDown = playerOne.dealCard(); //face down
      Card cardTwoDown = playerTwo.dealCard(); //face down
      
      Card cardOne = playerOne.dealCard(); //face up
      Card cardTwo = playerTwo.dealCard(); //face up
      
      playerOne.resetDeckSize();
      playerTwo.resetDeckSize();
      
      if(cardOne.getRank()>cardTwo.getRank()) //hand 1 wins
      {
         hand1 = playerOne.addCard(cardOneDown);
         hand1 = playerOne.addCard(cardTwoDown);
         
         hand2.remove(hand2.size()-TWO);//remove second to last card dealt
         hand2.remove(hand2.size()-ONE);//remove last card dealt
         
         playerOne.resetDeckSize();
         playerTwo.resetDeckSize();
         return ONE;

      }
      else if (cardOne.getRank()<cardTwo.getRank()) //hand2 wins
      {
         hand2 = playerTwo.addCard(cardOneDown);
         hand2 = playerTwo.addCard(cardTwoDown);
         
         hand1.remove(hand1.size()-TWO);//remove second to last card dealt
         hand1.remove(hand1.size()-ONE);
         
         playerOne.resetDeckSize();
         playerTwo.resetDeckSize();
         return -ONE;
      }
      else
         return ZERO;
   }
   /**
   *method to test who is the winner of
   *a round
   *
   *@param Card player1's card
   *@param Card player2's card
   *@return int to determine who won (0 = war, -1 = player1 wins, +1 = player2 wins)
   **/
   public static int winner(Card card1, Card card2)
   {
      //get number of cards
      int num1 = card1.getRank();
      int num2 = card2.getRank();
      if (num1 == num2)
         return ZERO;
      if(num1>num2) //hand1 1 wins
      {
         // System.out.println("Player one wins\n"
//                            + card1.toString(card1.getRank(),card1.getSuit())
//                            + " > " + card2.toString(card2.getRank(),card2.getSuit()));

         hand1 = playerOne.addCard(card2); //add card 2 to  0 index of hand1
         //add winning card to front of hand1
         hand1.remove(hand1.size()-ONE);//remove from the last index of hand (where dealt from)
         hand1.add(ZERO, card1);//add to first index of hand
         
         hand2 = playerTwo.removeCard(); //remove last card dealt from hand2
         playerOne.resetDeckSize();
         playerTwo.resetDeckSize();
         return -ONE;
      }
      else //hand2 2 wins
      {
         // System.out.println("Player two wins\n"
//                             + card1.toString(card1.getRank(),card1.getSuit()) + " > "
//                             + card2.toString(card2.getRank(),card2.getSuit()));

         hand2 = playerTwo.addCard(card1); //add hand1 1 card at front of hand1 to hand2 
         //add winning card to front of hand2
         hand2.remove(hand2.size()-ONE);//remove from side dealt from
         hand2.add(ZERO, card2); //add to 0th inde
         
         hand1 = playerOne.removeCard(); //remove hand1 1 card from hand1
         playerOne.resetDeckSize();
         playerTwo.resetDeckSize();
         return ONE;
      }
      
      

   }
   /**
   *method to test who is the winner in the event of
   *misallocation of cards
   *
   *@param none
   *@return int number 3 for setdefaultcloseoperation
   **/
   public static int testBigger()
   {
      if(hand1.size() > hand2.size())
      {
         System.out.println("Player one wins the game");
      }
      else if(hand1.size() < hand2.size())    
      {
         System.out.println("Player two wins the game");
      }
      else if (hand1.size() < hand2.size())
      {
         System.out.println("Tie by default");
         System.exit(1);
      }
      System.exit(0);
      return TWO+ONE;
   }   


}