package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

class Soft17HitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;
    boolean hasAce = false;

    public boolean DoHit(Player a_dealer) {
    	a_dealer.GetHand().forEach(card -> { if (card.GetValue() == Card.Value.Ace) { hasAce = true;}});
    	boolean doHit = (a_dealer.CalcScore() < g_hitLimit) || (a_dealer.CalcScore() == g_hitLimit) && hasAce;
      return doHit;  
    }
}