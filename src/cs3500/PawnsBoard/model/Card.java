package cs3500.PawnsBoard.model;

/**
 * Represents a card used in the Pawns Board game.
 * Each card has a name, cost, value score, and a 5x5 influence grid.
 */
public class Card {
  private String name;
  private int cost;
  private int valueScore;
  // Influence grid: true indicates influence (I or C), false indicates no influence (X)
  private boolean[][] influenceGrid;

  public Card(String name, int cost, int valueScore, boolean[][] influenceGrid) {
    this.name = name;
    this.cost = cost;
    this.valueScore = valueScore;
    this.influenceGrid = influenceGrid;
  }

  public String getName() {
    return name;
  }

  public int getCost() {
    return cost;
  }

  public int getValueScore() {
    return valueScore;
  }

  public boolean[][] getInfluenceGrid() {
    return influenceGrid;
  }
}
