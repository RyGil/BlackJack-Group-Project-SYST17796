/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Ryan Gilchrist
 */
public class Player
{

   private String name; //the unique name for this player

   /**
    * A constructor that allows you to set the player's unique ID
    *
    * @param name the unique ID to assign to this player.
    */
   public Player (String name)
   {
      this.name = name;
   }

   /**
    * @return the player name
    */
   public String getName ()
   {
      return name;
   }

   /**
    * Ensure that the playerID is unique
    *
    * @param name the player name to set
    */
   public void setName (String name)
   {
      this.name = name;
   }

   /**
    * The method to be overridden when you subclass the Player class with your
    * specific type of Player and filled in
    * with logic to play your game.
    */
   public void play ()
   {
      // WAS ORIGINALLY ABRACT b4 CHANGING PLAYER CLASS
   }

   public int checkAce (int playerTotal, GroupOfCards deck)
   {
      for (int i = 0; i < deck.getPlayerHand().size(); i++) {
         if (deck.getPlayerHand().get(i).getValue() == Values.Ace && playerTotal <= 10) {
            playerTotal += 10;
         }
         else if (deck.getPlayerHand().get(i).getValue() == Values.Ace && playerTotal > 10) {
            playerTotal -= 10;
         }
      }
      return playerTotal;
   }

   public String getHand (GroupOfCards deck)
   {
      String hand = "";
      for (int i = 0; i < deck.getPlayerHand().size(); i++) {
         hand += " | " + deck.getPlayerHand().get(i).getValue() + " of " + deck.getPlayerHand().get(i).getSuit() + " | ";
      }
      return hand;
   }



   //Methods that check validity above (can be moved to appropriate classes)
   public static boolean checkName (String name)
   {
      boolean validName = true;
      // Loop to check if there are any characters that are not alphabetic
      for (int i = 0; i < name.length(); i++) {
         if (!(Character.isLetter(name.charAt(i)))) {
            validName = false;
         }
      }
      return validName;
   }

   public boolean checkChoice (String choice)
   {
      boolean isValid = true;
      // If statement to ensure user chooses one of the three options
      if (!choice.equalsIgnoreCase("PLAY") && !choice.equalsIgnoreCase("RULES")
          && !choice.equalsIgnoreCase("EXIT")) {
         System.out.println("Error! Please choose a correct option!");
         System.out.println("Type PLAY to start a new game. \nType RULES for the "
             + "rules of Black Jack. \nType EXIT to terminate the game.");
         isValid = false;
      }
      return isValid;
   }

   // Check Hit or Stand selection
   public boolean checkSelection (String playerSelection)
   {
      boolean isValid = true;
      if (!playerSelection.equalsIgnoreCase(MoveControl.Hit.name())
          && !playerSelection.equalsIgnoreCase(MoveControl.Stand.name())) {
         System.out.println("Error! Please make a valid selection!");
         System.out.println("Please choose to either HIT or STAND: ");
         isValid = false;
      }
      return isValid;
   }

}
