/**
 * representation of a deck of cards as an arraylist
 * with capacity to create one from arraylist of any size
 *
 * @author Jackie Horton - edited Aidan Goldman
 */
import java.util.*;
public class Deck2 
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   public final static int CARDS_IN_DECK = 52,
                           ONE = 1,
                           ZERO = 0;

   /** The collection of Cards */
   private ArrayList <Card> deck = new ArrayList<Card>();
   /** Current number of Cards in Deck */
   public int ct;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck2()
   {
      freshDeck();
   }
   /**
   *Constructor
   *creates a shuffled deck and splits it
   *into two hands (arraylists)
   *
   *@param ArrayList of cards
   *@return none
   **/
   public Deck2(ArrayList <Card> hand)
   {
      deck = hand;
   }
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.DIAMONDS;s++)
         {
            deck.add(ct,new Card(s,r));
            ct++;
         }
      }
     
   
   }
   /** 
     * Remove and return the top Card on the Deck
     * @return A reference to a Card that was top on the Deck
     */
   public Card dealCard()
   {
      ct--;
      return deck.get(ct);
   }
   /** 
     * Return current number of Cards in Deck
     * @return number of Cards in Deck
     */
   public int cardsRemaining()
   {  
      return ct;
   }
   public void resetDeckSize()
   {
      ct = deck.size()-ONE;
   }
   /** 
     * Randomize the order of Cards in Deck
     */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck.get(i);
         deck.set(i, deck.get(randNum));
         deck.set(randNum, temp);
      }
   }
   /** 
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
     */
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }
   public boolean isEmpty(ArrayList<Card> d)
   {
      boolean empty;
      for(int i = 0; i<d.size(); i++)
      {
         if(d.get(i)==null)//continue
            empty = true;
         else
         {
            empty = false;
            return false;
         }
      }
      return true;
   }   
   /**
   *Method to return the local deck
   *
   *@param none
   *@return ArrayList of cards
   **/
   public ArrayList<Card> getDeck()
   {
      ArrayList <Card> newDeck = new ArrayList <Card> ();
      for(int i = ZERO; i<CARDS_IN_DECK;i++)
      {
         int suit = deck.get(i).getSuit();
         int rank = deck.get(i).getRank();
         newDeck.set(i, new Card(suit,rank));
      }
      return newDeck;
   }
   /**
   *Method to remove last dealt card
   *
   *@param none
   *@return updated ArrayList of cards
   **/
   public ArrayList <Card> removeCard()
   {
      deck.remove(deck.size()-ONE);
      return deck;
   }
   /**
   *Method to add card to back of deck
   *
   *@param Card to add to deck
   *@return updated ArrayList of cards
   **/
   public ArrayList <Card> addCard(Card newCard)
   {
      deck.add(ZERO, newCard);
      return deck;  
   }
}
