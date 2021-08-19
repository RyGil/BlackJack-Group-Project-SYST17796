package ca.sheridancollege.project;
/**
 * @author Ryan Gilchrist 8/16/2021
 */
public class Dealer extends Player
{
   public Dealer (String name)
   {
      super(name);
   }

   // Method to automate dealer's turn
   public void dealerTurn (int playerTotal, int dealerTotal, Dealer dealer, GroupOfCards deck)
   {
      int dealerPoints = deck.getDealerHandScore();
      dealerTotal = dealer.checkAce(dealerPoints, deck);
      while (dealerTotal <= 16) {
         System.out.println("---------------------------");
         System.out.println("Dealer currently has: | " + dealer.getHand(deck) + " | \nDealer's current total is: " + dealerTotal);
         System.out.println("Dealer hits!");
         deck.dealerHit();
         dealerPoints = deck.getDealerHandScore();
         dealerTotal = dealer.checkAce(dealerPoints, deck);
         if (dealerTotal > 21) {
            Game.checkScore(playerTotal, dealerTotal);
            break;
         }
         else if (dealerTotal >= 17 && dealerTotal <= 21) {
            System.out.println("---------------------------");
            System.out.println("Dealer currently has: | " + dealer.getHand(deck) + " | \nDealer's current total is: " + dealerTotal);
            System.out.println("Dealer Stands!");
            Game.declareWinner(playerTotal, dealerTotal);
            break;
         }
      }

   }

   // Method to check if dealer has an ace and assign appropriate value
   @Override
   public int checkAce (int dealerPoints, GroupOfCards deck)
   {
      for (int i = 0; i < deck.getDealerHand().size(); i++) {
         if (deck.getDealerHand().get(i).getValue() == Values.Ace && dealerPoints <= 10) {
            dealerPoints += 10;
         }
      }
      return dealerPoints;
   }

   // Method to get dealer's hand as a string
   @Override
   public String getHand (GroupOfCards deck)
   {
      String hand = "";
      for (int i = 0; i < deck.getDealerHand().size(); i++) {
         hand += " | " + deck.getDealerHand().get(i).getValue() + " of " + deck.getDealerHand().get(i).getSuit() + " | ";
      }
      return hand;
   }

}
