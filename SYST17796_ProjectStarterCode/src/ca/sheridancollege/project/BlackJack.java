package ca.sheridancollege.project;
import java.util.Scanner;
/**
 * @author Ryan Gilchrist
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
            // Created object and set its size to 52
            GroupOfCards deck = new GroupOfCards(52);
            // Create deck
            deck.createDeck();
            deck.shuffle();
            deck.deal();



            // THIS IS JUST HOW TO PRINT DECK
//            for (int i = 0; i < deck.getSize(); i++) {
//               System.out.println(deck.getCards().get(i).getValue() + " of " + deck.getCards().get(i).getSuit());
//            }
            //this can be put into method if wanted***
            //Create Deale // Initiate card totals for player and dealer
            int playerTotal = 0;

            int dealerTotal = 0;
            Dealer dealer = new Dealer("Dealer");


            while (playerTotal <= 21) {
               playerTotal = deck.getPlayerHandScore();
               dealerTotal = deck.getDealerHandScore();

               player1.checkAce(playerTotal, deck);
               dealer.checkAce(dealerTotal, deck);
               Game.checkScore(playerTotal, dealerTotal);

               //call deal();
               System.out.println("---------------------------");
               System.out.println("You currently have: " + player1.getHand(deck) + ".\nYour current total is: "
                   + playerTotal + ".\nDealer currently has: | " + deck.getDealerHand().get(0).getValue() + " of "
                   + deck.getDealerHand().get(1).getSuit() + " | showing.");
               System.out.println("Please choose to either HIT or STAND: ");
               String playerSelection = input.nextLine();

               boolean isValidSelection = player1.checkSelection(playerSelection);
               while (!isValidSelection) {
                  playerSelection = input.nextLine();
                  isValidSelection = player1.checkSelection(playerSelection);
               }

               if (playerSelection.equalsIgnoreCase(MoveControl.Hit.name())) {
                  deck.hit();
               }
               else {
                  dealer.dealerTurn(playerTotal, dealerTotal);
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
