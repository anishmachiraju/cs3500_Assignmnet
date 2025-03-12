package cs3500.PawnsBoard.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A utility class for reading deck configuration files.
 *
 * The expected file format is:
 *
 * CARD_NAME COST VALUE
 * ROW_0
 * ROW_1
 * ROW_2
 * ROW_3
 * ROW_4
 *
 * Valid characters in the grid are:
 *   - 'X' : No influence on that cell.
 *   - 'I' : The card influences that cell.
 *   - 'C' : The card's position. This must only exist in the center (row 2, column 2).
 */
public class DeckReader {

  /**
   * Reads a deck configuration file and returns a list of Card objects.
   *
   * @param filepath the file path (e.g., "docs" + File.separator + "deck.config")
   * @return a list of cards read from the file
   * @throws FileNotFoundException if the file cannot be found
   */
  public static List<Card> readDeck(String filepath) throws FileNotFoundException {
    List<Card> cards = new ArrayList<>();
    File file = new File(filepath);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      // Read the header line for a card: CARD_NAME COST VALUE
      String headerLine = scanner.nextLine().trim();
      if (headerLine.isEmpty()) {
        continue; // Skip empty lines.
      }
      String[] headerParts = headerLine.split("\\s+");
      if (headerParts.length < 3) {
        throw new IllegalArgumentException("Invalid card header: " + headerLine);
      }
      String cardName = headerParts[0];
      int cost = Integer.parseInt(headerParts[1]);
      int value = Integer.parseInt(headerParts[2]);

      // Read the next 5 lines representing the influence grid.
      boolean[][] influenceGrid = new boolean[5][5];
      for (int i = 0; i < 5; i++) {
        if (!scanner.hasNextLine()) {
          throw new IllegalArgumentException("Not enough lines for card " + cardName);
        }
        String gridLine = scanner.nextLine().trim();
        if (gridLine.length() != 5) {
          throw new IllegalArgumentException("Grid line must have exactly 5 characters for card " + cardName);
        }
        for (int j = 0; j < 5; j++) {
          char ch = gridLine.charAt(j);
          if (ch == 'X') {
            influenceGrid[i][j] = false;
          } else if (ch == 'I' || ch == 'C') {
            influenceGrid[i][j] = true;
          } else {
            throw new IllegalArgumentException("Invalid character in grid for card "
                    + cardName + ": " + ch);
          }
        }
      }
      // (Optional) Validate that 'C' appears only at the center (row 2, col 2).
      cards.add(new Card(cardName, cost, value, influenceGrid));
    }
    scanner.close();
    return cards;
  }
}
