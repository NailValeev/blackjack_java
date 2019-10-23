package BlackJack.view;

public interface IView
{
  void DisplayWelcomeMessage(boolean flag);
  int GetInput();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
  char PLAY_CODE = 'p';
  char HIT_CODE = 'h';
  char STAND_CODE = 's';
  char QUIT_CODE = 'q';
}