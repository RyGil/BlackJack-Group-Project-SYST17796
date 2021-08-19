package ca.sheridancollege.project;

/**
 * @author Ryan Gilchrist 8/16/2021
 * @author Marjorie Carambas
 *
 * Enums for card Face values and assigning point values
 */

public enum Values
{
   Ace(1),
   Two(2),
   Three(3),
   Four(4),
   Five(5),
   Six(6),
   Seven(7),
   Eight(8),
   Nine(9),
   Ten(10),
   Jack(10),
   Queen(10),
   King(10);

   private final int valueOfCard;

   private Values (int valueOfCard)
   {
      this.valueOfCard = valueOfCard;
   }

   public int getValue ()
   {
      return valueOfCard;
   }
}
