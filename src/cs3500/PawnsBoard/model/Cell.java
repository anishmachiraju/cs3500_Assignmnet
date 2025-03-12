package cs3500.PawnsBoard.model;

/**
 * Represents a single cell on the game board.
 * A cell can contain pawns or a placed card.
 */
public class Cell {
  // Number of pawns currently on the cell.
  private int pawnCount;
  // Pawn owner is null if no pawns, otherwise "RED" or "BLUE".
  private String pawnOwner;
  // A placed card is fixed; a cell with a card cannot be changed.
  private Card placedCard;

  public Cell() {
    this.pawnCount = 0;
    this.pawnOwner = null;
    this.placedCard = null;
  }

  public boolean isEmpty() {
    return pawnCount == 0 && placedCard == null;
  }

  public boolean hasCard() {
    return placedCard != null;
  }

  /**
   * Sets the cell with pawns for the specified owner.
   *
   * @param owner the pawn owner ("RED" or "BLUE")
   * @param count the number of pawns to set
   */
  public void setPawn(String owner, int count) {
    this.pawnOwner = owner;
    this.pawnCount = count;
  }

  public int getPawnCount() {
    return pawnCount;
  }

  public String getPawnOwner() {
    return pawnOwner;
  }

  /**
   * Places a card on the cell. This removes any pawns previously present.
   *
   * @param card the card to place
   */
  public void placeCard(Card card) {
    this.placedCard = card;
    // Remove any pawns when a card is placed.
    this.pawnCount = 0;
    this.pawnOwner = null;
  }

  public Card getPlacedCard() {
    return placedCard;
  }
}
