package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy(); // new Soft17HitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy(); // new AmericanNewGameStrategy()
  }
  
  public IWinStrategy GetWinRule() {
	  return new DealerWinIfEqualStrategy(); //new PlayerWinIfEqualStrategy();
  }
}