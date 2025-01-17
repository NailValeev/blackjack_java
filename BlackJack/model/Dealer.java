package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

	private Deck m_deck;
	private INewGameStrategy m_newGameRule;
	private IHitStrategy m_hitRule;
	private IWinStrategy m_winRule;

	public Dealer(RulesFactory a_rulesFactory) {

		m_newGameRule = a_rulesFactory.GetNewGameRule();
		m_hitRule = a_rulesFactory.GetHitRule();
		m_winRule = a_rulesFactory.GetWinRule();

		/*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
	}


	public boolean NewGame(Player a_player) {
		if (m_deck == null || IsGameOver()) {
			m_deck = new Deck();
			ClearHand();
			a_player.ClearHand();
			return m_newGameRule.NewGame(this, a_player);   
		}
		return false;
	}

	public boolean Hit(Player a_player) {
		if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {

			GiveCard(a_player, true);

			return true;
		}
		return false;
	}

	public boolean IsDealerWinner(Player a_player) {
		return m_winRule.IsDealerWinner(a_player, CalcScore());
	}

	public boolean IsGameOver() {
		if (m_deck != null && m_hitRule.DoHit(this) != true) {
			return true;
		}
		return false;
	}


	public boolean Stand(Player m_player) {
		if (m_deck != null) {
			ShowHand();
			while (m_hitRule.DoHit(this)) {
				Hit(this);
			}
		}
		return false;
	}
		
	  
	// This approach is a best from low coupling / high cohesion point of view.
	// It doesn't take a card or deck as parameter, because Dealer already has a deck  
	public void GiveCard(Player a_player, boolean isVisible) {
		Card card = m_deck.GetCard();
		card.Show(isVisible);
		a_player.DealCard(card); // This method will notify observers
	}

}