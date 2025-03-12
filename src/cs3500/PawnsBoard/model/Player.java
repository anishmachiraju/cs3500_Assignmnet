package cs3500.PawnsBoard.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the Pawns Board game.
 * Each player has a color, a deck, and a hand of cards.
 */
public class Player {
  public enum Color {
    RED, BLUE
  }

  private Color color;
  private Deck deck;
  private List<Card> hand;
  private int handSizeLimit;

  /**
   * Constructs a Player with the specified color, deck, and initial hand size.
   *
   * @param color the player's color (RED or BLUE)
   * @param deck the player's deck
   * @param initialHandSize the number of cards to draw for the starting hand
   */
  public Player(Color color, Deck deck, int initialHandSize) {
    this.color = color;
    this.deck = deck;
    this.hand = new ArrayList<>();
    this.handSizeLimit = initialHandSize;
    drawInitialHand();
  }

  // Draws cards to form the initial hand.
  private void drawInitialHand() {
    for (int i = 0; i < handSizeLimit; i++) {
      drawCard();
    }
  }

  /**
   * Draws one card from the deck into the player's hand.
   */
  public void drawCard() {
    if (deck.hasCards()) {
      Card drawn = deck.drawCard();
      if (drawn != null) {
        hand.add(drawn);
      }
    }
  }

  public List<Card> getHand() {
    return hand;
  }

  public Color getColor() {
    return color;
  }

  /**
   * Simulates a turn for the player.
   * For now, it simply prints the current hand.
   *
   * @param board the game board
   */
  public void takeTurn(Board board) {
    System.out.println(color + " player's hand: ");
    for (Card card : hand) {
      System.out.println("- " + card.getName() + " (Cost: " + card.getCost() + ", Value: " + card.getValueScore() + ")");
    }
    // TODO: Add logic for choosing to pass or place a card.
  }
}
