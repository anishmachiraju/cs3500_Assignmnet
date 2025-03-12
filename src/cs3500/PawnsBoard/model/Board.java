package cs3500.PawnsBoard.model;

/**
 * Represents the game board for Pawns Board.
 * The board is a rectangular grid of cells.
 */
public class Board {
  private Cell[][] cells;
  private int rows;
  private int columns;

  /**
   * Constructs a board with the given number of rows and columns.
   * Rows must be > 0, and columns must be odd and > 1.
   *
   * @param rows the number of rows
   * @param columns the number of columns
   */
  public Board(int rows, int columns) {
    if (rows <= 0) {
      throw new IllegalArgumentException("Number of rows must be positive.");
    }
    if (columns <= 1 || columns % 2 == 0) {
      throw new IllegalArgumentException("Number of columns must be odd and greater than 1.");
    }
    this.rows = rows;
    this.columns = columns;
    cells = new Cell[rows][columns];
    initializeCells();
    initializePawns();
  }

  // Create each cell in the grid.
  private void initializeCells() {
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        cells[r][c] = new Cell();
      }
    }
  }

  // Initialize starting pawns:
  // The first column gets Red pawns and the last column gets Blue pawns.
  private void initializePawns() {
    for (int r = 0; r < rows; r++) {
      cells[r][0].setPawn("RED", 1);
      cells[r][columns - 1].setPawn("BLUE", 1);
    }
  }

  /**
   * Returns the cell at the specified row and column.
   *
   * @param row the row index
   * @param col the column index
   * @return the Cell or null if the indices are out of bounds
   */
  public Cell getCell(int row, int col) {
    if (row < 0 || row >= rows || col < 0 || col >= columns) {
      return null;
    }
    return cells[row][col];
  }

  /**
   * Attempts to place a card on the specified cell.
   * Checks whether the cell contains enough pawns of the player's color.
   *
   * @param row the row index
   * @param col the column index
   * @param card the card to place
   * @param playerColor the player's color ("RED" or "BLUE")
   */
  public void placeCard(int row, int col, Card card, String playerColor) {
    Cell cell = getCell(row, col);
    if (cell == null) {
      System.out.println("Invalid cell position.");
      return;
    }
    if (cell.getPawnOwner() == null || !cell.getPawnOwner().equals(playerColor)
            || cell.getPawnCount() < card.getCost()) {
      System.out.println("Cannot place card here.");
      return;
    }
    cell.placeCard(card);
    // TODO: Apply the card's influence grid over the board.
  }
}
