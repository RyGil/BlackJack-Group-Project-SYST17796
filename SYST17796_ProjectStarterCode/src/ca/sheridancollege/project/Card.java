/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves
 * as a modifier.
 *
 * @author dancye
 */
public class Card
{
   //default modifier for child classes
   private Values value;
   private Suits suit;

   public Card (Values cardValue, Suits cardSuit)
   {
      this.value = cardValue;
      this.suit = cardSuit;
   }

   public Values getValue ()
   {
      return value;
   }

   public void setValue (Values value)
   {
      this.value = value;
   }

   public Suits getSuit ()
   {
      return suit;
   }

   public void setSuit (Suits suit)
   {
      this.suit = suit;
   }


   /**
    * Students should implement this method for their specific children classes
    *
    * @return a String representation of a card. Could be an UNO card, a regular
    * playing card etc.
    */
//    @Override
//    public  String toString() {
//    }

}
