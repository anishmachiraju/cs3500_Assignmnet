package cs3500.PawnsBoard.model;

import cs3500.PawnsBoard.model.Game;
import java.io.File;

/**
 * The main entry point for the Pawns Board game.
 * Sets up the game parameters and starts the game loop.
 */
public class PawnsBoard {
  public static void main(String[] args) {
    // Build an OS-independent file path for the deck configuration file.
    String deckFilePath = "docs" + File.separator + "deck.config";

    // Game parameters: a 3-row by 5-column board and a starting hand size of 5.
    int rows = 3;
    int columns = 5;
    int initialHandSize = 5;

    // Initialize the game.
    // Both players use the same deck configuration file.
    Game game = new Game(rows, columns, deckFilePath, deckFilePath, initialHandSize);

    // Start the game loop.
    // After each action (placing a card or passing), the board state is printed.
    game.start();
  }
}
