package BlackJack.model.rules;

import BlackJack.model.Player;

public class DealerWinIfEqualStrategy implements IWinStrategy{
	public boolean IsDealerWinner(Player a_player, int dealerScore) {
		int max = a_player.getMaxScore();
		return (a_player.CalcScore() > max || ( dealerScore >= a_player.CalcScore()) && (dealerScore <= max)) ;
	}
}
