package BlackJack.view;

public class SimpleView implements IView 
{

	public void DisplayWelcomeMessage(boolean isReady)
	{
		for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
		System.out.println("Hello Black Jack World");
		String message = isReady ? 
				("Type '" + PLAY_CODE + "' to Play, '" + HIT_CODE + "' to Hit, '" + STAND_CODE + "' to Stand or '" + QUIT_CODE + "' to Quit\n") 
				: 
				"Wait a moment, dealing cards...";
		System.out.println(message);
	}

	public int GetInput()
	{
		try {
			int c = System.in.read();
			while (c == '\r' || c =='\n') {
				c = System.in.read();
			}
			return c;
		} catch (java.io.IOException e) {
			System.out.println("" + e);
			return 0;
		}
	}

	public void DisplayCard(BlackJack.model.Card a_card)
	{
		String text =  a_card.GetValue() + " of " + a_card.GetColor();
		
		int delay = a_card.isM_isShown()? 0 : 70;
		String divider = a_card.isM_isShown()? "" : "_";
		
		a_card.setM_isShown(true);
		
		for (int index = 0; index < text.length(); index ++) {
			try {
				 Thread.sleep(delay);
				 System.out.print(text.charAt(index) + divider);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.print("\n");
	}

	public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
	{
		DisplayHand("Player", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
	{
		DisplayHand("Dealer", a_hand, a_score);
	}

	private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
	{
		System.out.println(a_name + " Has: ");
		for(BlackJack.model.Card c : a_hand)
		{
			DisplayCard(c);
		}
		System.out.println("Score: " + a_score);
		System.out.println("");
	}

	public void DisplayGameOver(boolean a_dealerIsWinner)
	{
		System.out.println("GameOver: ");
		if (a_dealerIsWinner)
		{
			System.out.println("Dealer Won!");
		}
		else
		{
			System.out.println("You Won!");
		}

	}
}
