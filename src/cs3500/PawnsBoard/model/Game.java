package cs3500.PawnsBoard.model;

/**
 * Represents the overall game of Pawns Board.
 * Manages the board, players, and the game loop.
 */
public class Game {
  private Board board;
  private Player redPlayer;
  private Player bluePlayer;
  private Player currentPlayer;
  // Tracks consecutive passes to determine when the game is over.
  private int consecutivePasses;

  /**
   * Constructs the game with the specified board dimensions, deck files, and starting hand size.
   *
   * @param rows number of board rows
   * @param columns number of board columns
   * @param redDeckFile file path for the Red player's deck configuration
   * @param blueDeckFile file path for the Blue player's deck configuration
   * @param initialHandSize starting hand size for both players
   */
  public Game(int rows, int columns, String redDeckFile, String blueDeckFile, int initialHandSize) {
    board = new Board(rows, columns);
    Deck redDeck = new Deck(redDeckFile);
    Deck blueDeck = new Deck(blueDeckFile);
    redPlayer = new Player(Player.Color.RED, redDeck, initialHandSize);
    bluePlayer = new Player(Player.Color.BLUE, blueDeck, initialHandSize);
    // Red always starts.
    currentPlayer = redPlayer;
    consecutivePasses = 0;
  }

  /**
   * Starts the game loop.
   * After each player's action (placing a card or passing), the board state is printed.
   */
  public void start() {
    while (!isGameOver()) {
      System.out.println("\nCurrent Board State:");
      // TODO: Add code to print the board state.
      System.out.println(currentPlayer.getColor() + "'s turn.");
      currentPlayer.takeTurn(board);

      // For now, simulate a pass.
      System.out.println(currentPlayer.getColor() + " passes.");
      consecutivePasses++;

      // Switch to the other player.
      switchPlayer();
    }
    System.out.println("Game over!");
    // TODO: Compute and display the final scores.
  }

  // Ends the game when both players have passed consecutively.
  private boolean isGameOver() {
    return consecutivePasses >= 2;
  }

  private void switchPlayer() {
    currentPlayer = (currentPlayer == redPlayer) ? bluePlayer : redPlayer;
  }
}
