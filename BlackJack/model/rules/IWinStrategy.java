package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IWinStrategy {
	boolean IsDealerWinner(Player a_player, int dealerScore);
}
