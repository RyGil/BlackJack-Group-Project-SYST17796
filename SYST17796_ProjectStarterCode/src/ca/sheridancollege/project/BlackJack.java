package ca.sheridancollege.project;
import java.util.Scanner;
/**
 * @author Ryan Gilchrist
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
      boolean isValidName = Player.checkName(name);
      while (!isValidName) {
         System.out.println("Error! Your name should only contain alphabetic characters.");
         System.out.println("Please enter your name: ");
         name = input.nextLine();
         isValidName = Player.checkName(name);
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
         boolean isValidChoice = Player.checkChoice(choice);
         while (!isValidChoice) {
            choice = input.nextLine();
            isValidChoice = Player.checkChoice(choice);
         }

         // If statement for when user makes valid choice
         if (choice.equalsIgnoreCase("PLAY")) {
            //this can be put into method if wanted***
            //Create Dealer
            Dealer dealer = new Dealer("Dealer");
            // Initiate card totals for player and dealer
            int playerTotal = 15;
            int dealerTotal = 20;
            while (playerTotal <= 21) {
               //call deal();
               System.out.println("---------------------------");
               System.out.println("You currently have: " + /* CARD1
                    * + " and " + CARD2 */ ".\nYour current total is: "
                   + playerTotal + ".\nDealer currently has: " + /* CARD3
                    * + */ " showing.");
               System.out.println("Please choose to either HIT or STAND: ");
               String playerSelection = input.nextLine();

               boolean isValidSelection = Player.checkSelection(playerSelection);
               while (!isValidSelection) {
                  playerSelection = input.nextLine();
                  isValidSelection = Player.checkSelection(playerSelection);
               }

               if (playerSelection.equalsIgnoreCase(MoveControl.Stand.name())) {
                  Game.dealerTurn(playerTotal, dealerTotal);
               }

               Game.checkScore(playerTotal, dealerTotal);
               Game.declareWinner(playerTotal, dealerTotal);
            }
         }
         else if (choice.equalsIgnoreCase("RULES")) {
            Game.callRules();
         }
         else {
            System.out.println("Thanks for playing! Goodbye! :)");
            gameOver = true; // Ends game
         }
      }
   }
}
