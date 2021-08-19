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
 * @author Ryan Gilchrist 8/16/2021
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

}
