/**
 * representation of a card
 * has a rank, suit, and a string representation
 * of it's value
 *
 * @author Jackie Horton - edited Aidan Goldman
**/
import java.util.Scanner;
public class Card
{
   public static final int SPADES = 1;
   public static final int CLUBS = 2;
   public static final int HEARTS = 3;
   public static final int DIAMONDS = 4;
   public static final int ACE = 1;
   public static final int JACK = 11;
   public static final int QUEEN = 12;
   public static final int KING = 13;
   public int rank;
   public int suit;
   public String rankANDsuitString;
   /**
   *Constructor
   *creates a shuffled deck and splits it
   *into two hands (arraylists)
   *
   *@param none
   *@return none
   **/
   public Card()
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Pick a suit 1-4: ");
      suit = keyboard.nextInt();
      
      System.out.print("Pick a rank 0-13: ");
      suit = keyboard.nextInt();
   }
   /**
   *Constructor
   *creates a shuffled deck and splits it
   *into two hands (arraylists)
   *
   *@param int for suit
   *@param int for rank
   *@return none
   **/
   public Card(int s, int r)
   {
      //if (suit == 1)
      //   suit = SPADES;
      switch(s)
      {
         case 1:
            suit = SPADES;
            break;
         case 2:
            suit = CLUBS;
            break;
         case 3:
            suit = HEARTS;
            break;
         case 4:
            suit = DIAMONDS;
            break;
         default:
            System.out.println("Invalid suit. Must be between 1-4");
            break;
      }
      switch(r)
      {
         case 1:
            rank = ACE;
            break;
         case 2:
            rank = 2;
            break;
         case 3:
            rank = 3;
            break;
         case 4:
            rank = 4;
            break;
         case 5:
            rank = 5;
            break;
         case 6:
            rank = 6;
            break;
         case 7:
            rank = 7;
            break;
         case 8:
            rank = 8;
            break;
         case 9:
            rank = 9;
            break;
         case 10:
            rank = 10;
            break;
         case 11:
            rank = JACK;
            break;
         case 12:
            rank = QUEEN;
            break;
         case 13:
            rank = KING;
            break;
         default:
            break;
      }
   }
   /**
   *Method to return suit of card
   *
   *@param none
   *@return int of suit
   **/
   public int getSuit()
   {
      return suit;
   }
   /**
   *Method to return rank of card
   *
   *@param none
   *@return int of rank
   **/
   public int getRank()
   {
      return rank;
   }
   /**
   *Method to return string representation of card
   *
   *@param none
   *@return int of suit
   **/
   public String toString(int suit, int rank)
   {
      String suitString;
      String rankString;
      String rankANDsuitString;
      
      //change INT suit to STRING suit
      if(suit==1)
         suitString = "Spades";
      else if(suit==2)
         suitString = "Clubs";
      else if(suit==3)
         suitString = "Hearts";
      else if(suit==4)
         suitString = "Diamonds";
      else
         suitString = "Invalid suit";
      
      //change INT rank to STRING rank
      if(rank==1)
         rankString = "Ace";
      else if(rank==2)
         rankString = "2";
      else if(rank==3)
         rankString = "3";
      else if(rank==4)
         rankString = "4";
      else if(rank==5)
         rankString = "5";
      else if(rank==6)
         rankString = "6";
      else if(rank==7)
         rankString = "7";
      else if(rank==8)
         rankString = "8";
      else if(rank==9)
         rankString = "9";
      else if(rank==10)
         rankString = "10";
      else if(rank==11)
         rankString = "Jack";
      else if(rank==12)
         rankString = "Queen";
      else if(rank==13)
         rankString = "King";
      else
         rankString = "Invalid rank";
      
      rankANDsuitString = rankString +" of "+ suitString;
      return rankANDsuitString;
   }
   public boolean equals(Card otherCard)
   {
      int rank = getRank(),
          rank1 = otherCard.getRank();
                
      if (rank == rank1)
         return true;
      else
         return false;
      
   }
   
}