/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 *
 * @author Ryan Gilchrist 8/16/2021
 * @author Marjorie Carambas 8/16/2021
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for
 * reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards
{

   //The group of cards, stored in an ArrayList
   private ArrayList<Card> cards;
   private ArrayList<Card> playerHand;
   private ArrayList<Card> dealerHand;
   private int size;//the size of the grouping

   // Method to create deck
   public void createDeck ()
   {
      cards = new ArrayList<>();
      for (Values cardValue : Values.values()) {
         for (Suits cardSuit : Suits.values()) {
            cards.add(new Card(cardValue, cardSuit));
         }
      }
   }

   // Method to deal 2 cards to each player
   public void deal ()
   {
      playerHand = new ArrayList<>();
      for (int i = 0; i < 2; i++) {
         Card temp = cards.remove(i);
         playerHand.add(temp);
      }
      dealerHand = new ArrayList<>();
      for (int i = 0; i < 2; i++) {
         Card temp = cards.remove(i);
         dealerHand.add(temp);
      }
   }

   // Method to add 1 card to player hand when they hit
   public void playerHit ()
   {
      for (int i = 0; i < 1; i++) {
         Card temp = cards.remove(i);
         playerHand.add(temp);
      }
   }

   // Method to add 1 card to dealer hand when they hit
   public void dealerHit ()
   {
      for (int i = 0; i < 1; i++) {
         Card temp = cards.remove(i);
         dealerHand.add(temp);
      }
   }

   public GroupOfCards (int size)
   {
      this.size = size;
   }

   /**
    * A method that will get the group of cards as an ArrayList
    *
    * @return the group of cards.
    */
   public ArrayList<Card> getCards ()
   {
      return cards;
   }

   public ArrayList<Card> getPlayerHand ()
   {
      return playerHand;
   }

   public int getPlayerHandScore ()
   {
      int values = 0;

      for (Card c : playerHand) {

         values += c.getValue().getValue();
      }
      return values;
   }

   public ArrayList<Card> getDealerHand ()
   {
      return dealerHand;
   }

   public int getDealerHandScore ()
   {
      int values = 0;

      for (Card c : dealerHand) {

         values += c.getValue().getValue();
      }
      return values;
   }



   public void shuffle ()
   {
      Collections.shuffle(cards);
   }

   /**
    * @return the size of the group of cards
    */
   public int getSize ()
   {
      return size;
   }

   /**
    * @param size the max size for the group of cards
    */
   public void setSize (int size)
   {
      this.size = size;
   }


}//end class
