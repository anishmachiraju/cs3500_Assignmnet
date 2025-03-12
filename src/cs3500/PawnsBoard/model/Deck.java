package cs3500.PawnsBoard.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a deck of cards for a player.
 * The deck is initialized from a configuration file.
 */
public class Deck {
  private List<Card> cards;

  /**
   * Constructs a deck by reading a deck configuration file.
   *
   * @param filepath the file path to the deck configuration (e.g., "docs" + File.separator + "deck.config")
   */
  public Deck(String filepath) {
    try {
      this.cards = DeckReader.readDeck(filepath);
    } catch (FileNotFoundException e) {
      System.err.println("Deck configuration file not found: " + filepath);
      e.printStackTrace();
      this.cards = new ArrayList<>();
    }
  }

  public boolean hasCards() {
    return !cards.isEmpty();
  }

  /**
   * Draws a random card from the deck and removes it.
   *
   * @return the drawn Card or null if the deck is empty
   */
  public Card drawCard() {
    if (hasCards()) {
      int index = (int) (Math.random() * cards.size());
      return cards.remove(index);
    }
    return null;
  }
}
