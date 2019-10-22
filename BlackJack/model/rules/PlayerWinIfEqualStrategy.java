package BlackJack.model.rules;

import BlackJack.model.Player;

public class PlayerWinIfEqualStrategy implements IWinStrategy{
	public boolean IsDealerWinner(Player a_player, int dealerScore) {
		int max = a_player.getMaxScore();
		return (dealerScore > max || ( a_player.CalcScore() >= dealerScore) && (a_player.CalcScore() <= max)) ;
	}
}
