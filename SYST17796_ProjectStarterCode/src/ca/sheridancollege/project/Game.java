/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Game
{

   private final String name;//the title of the game
   private ArrayList<Player> players;// the players of the game

   public Game (String name)
   {
      this.name = name;
      players = new ArrayList();
   }

   /**
    * @return the name
    */
   public String getName ()
   {
      return name;
   }

   /**
    * @return the players of this game
    */
   public ArrayList<Player> getPlayers ()
   {
      return players;
   }

   /**
    * @param players the players of this game
    */
   public void setPlayers (ArrayList<Player> players)
   {
      this.players = players;
   }

   // Prints the rules of the game
   public static void callRules ()
   {
      System.out.println("--------------------------------------------------------");
      System.out.println("Goal: Have a higher score than the dealer. \n"
          + "\nHow: Get as close to 21 as possible without going over. "
          + "\nYou can choose to either 'Hit' or 'Stand'. Hitting will add another card to your hand, while"
          + "Standing will end your turn at your current score. \nThe dealer will then take their turn "
          + "and whoever has the higher score at the end will win.");

      System.out.println("\nNotes: \n1. An Ace can be worth either 1 or 11 points. \n2. All other cards "
          + "are worth their respective values. \n3. Jack, Queen, and King are worth 10 points. \n3. A natural is "
          + "when either the player or dealer is dealt 21 (an Ace + a card worth 10points. \nIn this case, the "
          + "winner of the game is determined without any turns being taken.");
   }

   // Checks score to see if player or dealer is DEALT 21 or busts during their turn
   public static void checkScore (int playerTotal, int dealerTotal)
   {
      if (playerTotal > 21 || dealerTotal > 21) { // Checks if bust
         declareWinner(playerTotal, dealerTotal);
      } // need to add when variable exists: else if (playerTotal == 21 && playerCard == 2 || dealerTotal == 21 && dealerCards == 2) { declareWinner(playerTotal, dealerTotal); } <- checks if 21 is initially dealt for instant win
   }

   //Declares winner
   public static void declareWinner (int playerTotal, int dealerTotal)
   {
      System.out.println("Player's card total: " + playerTotal);
      System.out.println("Dealer's card total: " + dealerTotal);

      if (playerTotal > dealerTotal && playerTotal <= 21) {
         System.out.println("YOU WIN!");
      }
      else if (playerTotal < dealerTotal && dealerTotal <= 21) {
         System.out.println("DEALER WINS!");
      }
      else {
         System.out.println("It's a Draw!");
      }
   }

   /**
    * Play the game. This might be one method or many method calls depending on
    * your game.
    */
   public void play ()
   {
      //THIS WAS ORIGINALLY ABSTRACT
   }

   /**
    * When the game is over, use this method to declare and display a winning
    * player.
    */
   public void declare1Winner ()
   {
      //THIS WAS ORIGINALLY ABSTRACT
   }

}//end class
