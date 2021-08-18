package ca.sheridancollege.project;
/**
 * @author Ryan Gilchrist
 */
public class Dealer extends Player
{
   public Dealer (String name)
   {
      super(name);
   }

   //Automates dealer's turn
   public void dealerTurn (int playerTotal, int dealerTotal)
   {
      while (dealerTotal <= 16) {
         System.out.println("---------------------------");
         System.out.println("Dealer currently has: " + /* print
              * hand */ ".\nDealer's current total is: " + dealerTotal);
         System.out.println("Dealer hits!");
         Game.checkScore(playerTotal, dealerTotal);
      }
      if (dealerTotal >= 17) {
         System.out.println("Dealer Stands!");
         Game.declareWinner(playerTotal, dealerTotal);
      }
   }

   @Override
   public int checkAce (int dealerTotal, GroupOfCards deck)
   {
      for (int i = 0; i < deck.getDealerHand().size(); i++) {
         if (deck.getDealerHand().get(i).getValue() == Values.Ace && dealerTotal <= 10) {
            dealerTotal += 10;
         }
         else if (deck.getDealerHand().get(i).getValue() == Values.Ace && dealerTotal > 10) {
            dealerTotal -= 10;
         }
      }
      return dealerTotal;
   }

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
