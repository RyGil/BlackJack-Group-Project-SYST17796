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
 * @author Ryan Gilchrist 8/16/2021
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

   // Checks if player has an ace and assigns appropriate value (1 or 11)
   public int checkAce (int playerPoints, GroupOfCards deck)
   {
      for (int i = 0; i < deck.getPlayerHand().size(); i++) {
         if (deck.getPlayerHand().get(i).getValue() == Values.Ace && playerPoints <= 10) {
            playerPoints += 10;
         }
      }
      return playerPoints;
   }

   // gets player's hand and converts to string
   public String getHand (GroupOfCards deck)
   {
      String hand = "";
      for (int i = 0; i < deck.getPlayerHand().size(); i++) {
         hand += " | " + deck.getPlayerHand().get(i).getValue() + " of " + deck.getPlayerHand().get(i).getSuit() + " | ";
      }
      return hand;
   }

   //Methods that checks validity of player name
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

   // Method to check validity of player's menu choice
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

   // Method to check validity of player's move selection
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
