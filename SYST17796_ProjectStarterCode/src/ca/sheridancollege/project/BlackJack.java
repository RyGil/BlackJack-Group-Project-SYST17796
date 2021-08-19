package ca.sheridancollege.project;
import java.util.Scanner;
/**
 * @author Ryan Gilchrist 8/16/2021
 * @author Marjorie Carambas 8/16/2021
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
         boolean isValidChoice = player1.checkChoice(choice);
         while (!isValidChoice) {
            choice = input.nextLine();
            isValidChoice = player1.checkChoice(choice);
         }

         // If statement for when user makes valid choice
         if (choice.equalsIgnoreCase("PLAY")) {
            // Created deck object and set it to 52
            GroupOfCards deck = new GroupOfCards(52);
            // Create, shuffle, and deal dck
            deck.createDeck();
            deck.shuffle();
            deck.deal();

            // Initiate card totals for player and dealer
            int playerTotal = 0;
            int dealerTotal = 0;
            //create dealer
            Dealer dealer = new Dealer("Dealer");

            // Loop to keep game running
            while (playerTotal <= 21) {
               // Getting dealt scores and assigning appropriate value to Ace (1 or 11)
               int playerPoints = deck.getPlayerHandScore();
               int dealerPoints = deck.getDealerHandScore();
               playerTotal = player1.checkAce(playerPoints, deck);
               dealerTotal = dealer.checkAce(dealerPoints, deck);

               Game.checkScore(playerTotal, dealerTotal);
               if (playerTotal > 21) {
                  break;
               }

               // Printing Hand of player, player points, and 1 of the two dealer cards
               System.out.println("---------------------------");
               System.out.println("You currently have: " + player1.getHand(deck) + ".\nYour current total is: "
                   + playerTotal + ".\nDealer currently has: | " + deck.getDealerHand().get(0).getValue() + " of "
                   + deck.getDealerHand().get(1).getSuit() + " | showing.");
               System.out.println("Please choose to either HIT or STAND: ");
               String playerSelection = input.nextLine();

               // Checking if user made a valid selection
               boolean isValidSelection = player1.checkSelection(playerSelection);
               while (!isValidSelection) {
                  playerSelection = input.nextLine();
                  isValidSelection = player1.checkSelection(playerSelection);
               }

               // If statement to determine game play based on user's move choice
               if (playerSelection.equalsIgnoreCase(MoveControl.Hit.name())) {
                  deck.playerHit();
               }
               else {
                  dealer.dealerTurn(playerTotal, dealerTotal, dealer, deck);
                  break;
               }
            }
         }
         else if (choice.equalsIgnoreCase("RULES")) {
            Game.callRules();
         }
         else {
            System.out.println("Thanks for playing! Goodbye! :)");
            gameOver = true; // terminates program
         }
      }
   }
}
