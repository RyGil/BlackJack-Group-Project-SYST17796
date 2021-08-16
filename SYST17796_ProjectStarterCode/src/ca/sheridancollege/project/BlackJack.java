package ca.sheridancollege.project;
import java.util.Scanner;
/**
 * @Ryan Gilchrist
 */
public class BlackJack
{
   protected void play ()
   {

      Scanner input = new Scanner(System.in);

      // Introduction to game
      System.out.println("Lets play some Black Jack! \n"
          + "This game is brought to you by the wonderful people at Java_Jack! \n");

      // Have user choose their name for the game
      System.out.println("Lets start off by getting your name... \nPlease enter your name: ");
      String name = input.nextLine();

      // Checking if name is valid (only alphabetic characters
      boolean isValidName = checkName(name);
      while (!isValidName) {
         System.out.println("Error! Your name should only contain alphabetic characters.");
         System.out.println("Please enter your name: ");
         name = input.nextLine();

         isValidName = checkName(name);
      }

      // Creating Player
      Player player1 = new Player(name);

      // Keep game running until user chooses "Exit"
      boolean gameOver = false;
      while (!gameOver) {

         // Provide user with options (Play, learn rules, exit game)
         System.out.println("----------------------------------------------------------");
         System.out.println("Welcome, " + player1.getName() + "! \nPlease choose one of the following: "
             + "\nType PLAY to start a new game. \nType RULES for the rules of Black Jack. "
             + "\nType EXIT to terminate the game.");
         System.out.println("----------------------------------------------------------");
         String choice = input.nextLine();

         // Checking validity of user's choice
         boolean isValidChoice = checkChoice(choice);
         while (!isValidChoice) {
            System.out.println("Error! Please choose a correct option!");
            System.out.println("Type PLAY to start a new game. \nType RULES for the "
                + "rules of Black Jack. \nType EXIT to terminate the game.");
            choice = input.nextLine();

            isValidChoice = checkChoice(choice);
         }

         // If statement for when user makes valid choice
         if (choice.equalsIgnoreCase("PLAY")) {
            //call method to play the game

            //Create Dealer
            Dealer dealer = new Dealer("Dealer");

            // Initiate card totals for player and dealer
            int playerTotal = 0;
            int dealerTotal = 0;
            checkScore(playerTotal, dealerTotal);
            declareWinner(playerTotal, dealerTotal);
         }
         else if (choice.equalsIgnoreCase("RULES")) {
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
         else {
            System.out.println("Thanks for playing! Goodbye! :)");
            gameOver = true; // Ends game
         }
      }
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

   public static boolean checkChoice (String choice)
   {

      boolean isValid = true;

      // If statement to ensure user chooses one of the three options
      if (!choice.equalsIgnoreCase("PLAY") && !choice.equalsIgnoreCase("RULES")
          && !choice.equalsIgnoreCase("EXIT")) {
         isValid = false;
      }
      return isValid;
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
}
