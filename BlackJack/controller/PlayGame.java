package BlackJack.controller;

import BlackJack.view.IView;

import java.util.Observable;
import java.util.Observer;

import BlackJack.model.Game;

public class PlayGame implements Observer {
	Game a_game;
	IView a_view;

	public PlayGame(Game g, IView v) {
		a_game = g;
		a_view = v;
		a_game.addObserver(this);
	}

	public boolean Play() {
		
		a_view.DisplayWelcomeMessage();
		
		DisplayScores();


		if (a_game.IsGameOver())
		{
			a_view.DisplayGameOver(a_game.IsDealerWinner());
		}

		int input = a_view.GetInput();

		if (input == IView.PLAY_CODE)
		{
			a_game.NewGame();
		}
		else if (input == IView.HIT_CODE)
		{
			a_game.Hit();
		}
		else if (input == IView.STAND_CODE)
		{
			a_game.Stand();
		}

		return input != IView.QUIT_CODE;
	}

	private void DisplayScores() {
		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg == "redraw"){
			System.out.println("XXXXX");
			DisplayScores();
		}
	}
}