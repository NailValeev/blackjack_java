package BlackJack.model;

public class Card {

  public enum Color {
    Hearts,
    Spades,
    Diamonds,
    Clubs,
    Count,
    Hidden
  }
  
  public enum Value {
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Ten,
    Knight,
    Queen,
    King,
    Ace,
    Count,
    Hidden
  }
  
  private Color m_color;
  private Value m_value;
  private boolean m_isHidden;
  private boolean m_isShown;
  
  public Card(Color a_color, Value a_value) {
    m_value = a_value;
    m_color = a_color;
    m_isHidden = true;
    m_isShown = false;
  }
  
  public Color GetColor() {
      if (m_isHidden)
      {
          return Color.Hidden;
      }
      return m_color;
  }

  public Value GetValue() {
      if (m_isHidden)
      {
          return Value.Hidden;
      }
      return m_value;
  }

	  /**
	 * @return the m_isShown
	 */
	public boolean isM_isShown() {
		return m_isShown;
	}
	
	/**
	 * @param m_isShown the m_isShown to set
	 */
	public void setM_isShown(boolean m_isShown) {
		this.m_isShown = m_isShown;
	}

public void Show(boolean a_show) {
      m_isHidden = !a_show;
  }
}