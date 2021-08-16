package ca.sheridancollege.project;
import java.util.Scanner;
/**
 * @Ryan Gilchrist - You miss all the shots you don't take ~ Wayne Gretzky
 */
public class BlackJack
{
   protected void play ()
   {

      Scanner input = new Scanner(System.in);

      System.out.println("Lets play some Black Jack! \n"
          + "This game is brought to you by the wonderful people at Java_Jack!");
      System.out.println("Lets start off by getting your name... \nPlease enter your name: ");

      String name = input.nextLine();

      boolean isValidName = checkName(name);

      while (!isValidName) {
         System.out.println("Error! Your name should only contain alphabetic characters.");
         System.out.println("Please enter your name: ");
         name = input.nextLine();

         isValidName = checkName(name);
      }

      Player player1 = new Player(name);

      boolean gameOver = false;

      while (!gameOver) {
         System.out.println("----------------------------------------------------------");
         System.out.println("Welcome, " + name + "! \nPlease choose one of the following: "
             + "\nType PLAY to start a new game. \nType RULES for the rules of Black Jack. "
             + "\nType EXIT to terminate the game.");
         System.out.println("----------------------------------------------------------");

         String choice = input.nextLine();

         boolean isValidChoice = checkChoice(choice);

         while (!isValidChoice) {
            System.out.println("Error! Please choose a correct option!");
            System.out.println("Type PLAY to start a new game. \nType RULES for the rules of Black Jack. "
                + "\nType EXIT to terminate the game.");
            choice = input.nextLine();

            isValidChoice = checkChoice(choice);
         }

         if (choice.equalsIgnoreCase("PLAY")) {
            //call method to play the game
         }
         else if (choice.equalsIgnoreCase("RULES")) {
            System.out.println("Goal: Have a higher score than the dealer. \n"
                + "\nHow: Get as close to 21 as possible without going over. "
                + "\nYou can choose to either 'Hit' or 'Stand'. Hitting will all another card to your hand, while"
                + "Standing will end your turn at your current score. \nThe dealer will then take their turn "
                + "and whoever has the higher score at the end will win.");

            System.out.println("\nNotes: \n1. An Ace can be worth either 1 or 11 points. \n2. A natural is "
                + "when either the player or dealer is dealt 21 (an Ace + a card worth 10points. \nIn this case, the "
                + "winner of the game is determined without any turns being taken.");
         }
         else {
            System.out.println("Thanks for playing! Goodbye! :)");
            gameOver = true;
         }
      }
   }

   //Methods that can be moved to appropriate classes
   public static boolean checkName (String name)
   {

      boolean validName = true;
      // Loop to check if there are any upper case letters in the inputted password
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

      if (!choice.equalsIgnoreCase("PLAY") && !choice.equalsIgnoreCase("RULES")
          && !choice.equalsIgnoreCase("EXIT")) {
         isValid = false;
      }
      return isValid;
   }
}
