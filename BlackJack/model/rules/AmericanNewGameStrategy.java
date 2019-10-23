package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

	  a_player.TakeCard(a_deck.GetCard(), true);
	  
	  a_dealer.TakeCard(a_deck.GetCard(), true);
	  
	  a_player.TakeCard(a_deck.GetCard(), true);
	  
	  a_dealer.TakeCard(a_deck.GetCard(), false);
	  
	  return true;
  }
}