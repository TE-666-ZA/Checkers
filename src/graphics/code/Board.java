package graphics.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logics.KingLogics;
import logics.Player;
import logics.PlayerLogics;

public class Board extends JPanel {

  public static final int BOARD_SIZE = 8;
  public static final int CELL_SIZE = 100;
  public static final Color DARK_COLOR = new Color(2, 1, 1);
  public static final Color LIGHT_COLOR = new Color(194, 158, 120);

  private PlayerLogics movementLogics;
  private BufferedImage whitePieceImage;
  private BufferedImage blackPieceImage;
  private BufferedImage whiteKingPieceImage;
  private BufferedImage blackKingPieceImage;
  private static int selectedRow;
  private static int selectedCol;
  private Player activePlayer;
  private static Player player1;
  private static Player player2;
  private static boolean isPlayALone;
  private static int countWhiteChecker;
  private static int countBlackChecker;
  private static ColoredPrinter printer;

  static boolean canDoNextMove;
  private static int[][] board = {
      {0, 1, 0, 1, 0, 1, 0, 1},
      {1, 0, 1, 0, 1, 0, 1, 0},
      {0, 1, 0, 1, 0, 1, 0, 1},
      {0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0},
      {2, 0, 2, 0, 2, 0, 2, 0},
      {0, 2, 0, 2, 0, 2, 0, 2},
      {2, 0, 2, 0, 2, 0, 2, 0}
  };

  public Board() {
    printer = new ColoredPrinter();
    movementLogics = new PlayerLogics();
    isPlayALone = true;
    canDoNextMove = false;
    try {
      whitePieceImage = ImageIO.read(new File("src/graphics/sprites/whiteSprite.png"));
      blackPieceImage = ImageIO.read(new File("src/graphics/sprites/blackSprite.png"));
      whiteKingPieceImage = ImageIO.read(new File("src/graphics/sprites/whiteKingSprite.png"));
      blackKingPieceImage = ImageIO.read(new File("src/graphics/sprites/blackKingSprite.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    selectedRow = -1;
    selectedCol = -1;
    countWhiteChecker = 12;
    countBlackChecker = 12;

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = e.getY() / Board.CELL_SIZE;
        int col = e.getX() / Board.CELL_SIZE;

        if (!isPlayALone) {
          if (movementLogics.getCheckerMove() == player1.getSelectedCheckerColor()) {
            activePlayer = player1;
          } else if (movementLogics.getCheckerMove() == player2.getSelectedCheckerColor()) {
            activePlayer = player2;
          }
        } else {
          activePlayer = player1;
          player1.changeColor();
        }

        if (selectedRow == -1) {
          if (board[row][col] != 0 && board[row][col] == activePlayer.getCheckerMove()
              || board[row][col] == activePlayer.getCheckerMove() + 2) {
            selectedRow = row;
            selectedCol = col;
          }

        } else if (board[row][col] != 0 && board[row][col] == activePlayer.getCheckerMove()
            || board[row][col] == activePlayer.getCheckerMove() + 2) {
          selectedRow = row;
          selectedCol = col;
        }
        if (selectedRow != -1 && activePlayer.isMoveValid(board, row, col, selectedRow,
            selectedCol)) {
            board[row][col] = board[selectedRow][selectedCol];
            board[selectedRow][selectedCol] = 0;
          movementLogics.isKing(row, col);
            selectedRow = -1;
            selectedCol = -1;
          if (!canDoNextMove) {
            activePlayer.changeMoveColor();
            }
          }

        repaint();
      }
    });
  }

  /**
   * Draws the game board in the window
   *
   * @param g the <code>Graphics</code> object to protect - context for drawing in the component
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int panelWidth = getWidth();
    int panelHeight = getHeight();
    int cellSize = Math.min(panelWidth / BOARD_SIZE, panelHeight / BOARD_SIZE);

    // zapolnyaem fon chernim
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, panelWidth, panelHeight);
    g.setColor(Color.BLACK);
    g.setFont(new Font("Arial", Font.BOLD, 18));
    g.setColor(Color.yellow);
    g.drawString("Player 1: " + player1.getName(), 10, getHeight() - 30);
    g.setColor(Color.green);
    g.drawString("Player 2: " + player2.getName(), 10, getHeight() - 10);

    g.setColor(Color.GREEN);
    g.drawRect(0, 0, BOARD_SIZE * BOARD_SIZE + 1, BOARD_SIZE * BOARD_SIZE + 1);

    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        int x = col * CELL_SIZE;
        int y = row * CELL_SIZE;

        if ((row + col) % 2 == 0) {
          g.setColor(LIGHT_COLOR);
        } else {
          g.setColor(DARK_COLOR);
        }

        g.fillRect(x, y, CELL_SIZE, CELL_SIZE);

        int piece = board[row][col];
        if (piece == PlayerLogics.getWhiteChecker()) {
          g.drawImage(whitePieceImage, x, y, null);
        } else if (piece == PlayerLogics.getBlackChecker()) {
          g.drawImage(blackPieceImage, x, y, null);
        } else if (piece == KingLogics.getKING_WHITE_CHECKER()) {
          g.drawImage(whiteKingPieceImage, x, y, null);
        } else if (piece == KingLogics.getKING_BLACK_CHECKER()) {
          g.drawImage(blackKingPieceImage, x, y, null);
        }
      }
    }

    if (selectedRow != -1 && selectedCol != -1) {
      g.setColor(Color.BLUE);
      g.drawRect(selectedCol * CELL_SIZE, selectedRow * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
    if (canDoNextMove) {
      g.setColor(Color.RED);
      g.drawRect(activePlayer.getLastColPosition() * CELL_SIZE,
          activePlayer.getLastRowPosition() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
  }

  public static void setKing(int row, int col) {
    if (board[row][col] == PlayerLogics.getWhiteChecker()) {
      board[row][col] = KingLogics.getKING_WHITE_CHECKER();
    } else if (board[row][col] == PlayerLogics.getBlackChecker()) {
      board[row][col] = KingLogics.getKING_BLACK_CHECKER();
    }
  }

  /**
   * Makes the cage from where the checker is walking, empty
   *
   * @param selectedRow the position of the line from where the checker moves, which the player
   *                    moves
   * @param selectedCol the position of the column from where the checker moves, which the player
   *                    moves
   */
  public static void killChecker(int selectedRow, int selectedCol) {
    board[selectedRow][selectedCol] = 0;
  }

  /**
   * Sets an object of the Player type to the player1 variable
   *
   * @param player Player type object
   */
  public static void setPlayer1(Player player) {
    player1 = player;
  }

  /**
   * Sets an object of the Player type to the player2 variable
   *
   * @param player Player type object
   */
  public static void setPlayer2(Player player) {
    player2 = player;
  }

  /**
   * Determines whether the player is playing alone
   *
   * @param playALone boolean value of playALone
   */
  public static void setPlayALone(boolean playALone) {
    isPlayALone = playALone;
  }

  /**
   * Checking that there are no white checkers left on the field
   *
   * @return true if there are no white checkers left on the playing field
   */
  public static boolean isWhiteCheckerResetToZero() {
    return countWhiteChecker == 0;
  }

  /**
   * Checking that there are no black checkers left on the field
   *
   * @return true if there are no black checkers left on the playing field
   */
  public static boolean isBlackCheckerResetToZero() {
    return countBlackChecker == 0;
  }

  /**
   * Decrement of the number of white checkers
   */
  public static void minusOneWhiteChecker() {
    countWhiteChecker--;
  }

  /**
   * Decrement of the number of black checkers
   */
  public static void minusOneBlackChecker() {
    countBlackChecker--;
  }

  /**
   * Checking the victory of white checkers
   */
  public static void checkWhiteVictory() {
    minusOneBlackChecker();
    if (isBlackCheckerResetToZero()) {
      gameOverWithWhiteVictory();
    }
  }

  /**
   * Checking the victory of black checkers
   */
  public static void checkBlackVictory() {
    minusOneWhiteChecker();
    if (isWhiteCheckerResetToZero()) {
      gameOverWithBlackVictory();
    }
  }

  /**
   * The end of the game with the victory of the white checkers and exit the game
   */
  public static void gameOverWithWhiteVictory() {
    if(player1.getSelectedCheckerColor() == PlayerLogics.WHITE_CHECKER){
      player1.setAmountOfVictories(player1.getAmountOfVictories() + 1);
      player2.setAmountOfDefeats(player2.getAmountOfDefeats() + 1);
      printer.printInMiddleYellow("WHITE IS WINNER ! " + player1.getName() + "WIN!");
    }else {
      player2.setAmountOfVictories(player2.getAmountOfVictories() + 1);
      player1.setAmountOfDefeats(player1.getAmountOfDefeats() + 1);
      printer.printInMiddleYellow("WHITE IS WINNER ! " + player2.getName() + "WIN!");
    }

    System.exit(1);
  }

  /**
   * The end of the game with the victory of the black checkers and exit the game
   */
  public static void gameOverWithBlackVictory() {
    if(player1.getSelectedCheckerColor() == PlayerLogics.BLACK_CHECKER){
      player1.setAmountOfVictories(player1.getAmountOfVictories() + 1);
      player2.setAmountOfDefeats(player2.getAmountOfDefeats() + 1);
      printer.printInMiddleYellow("BLACK IS WINNER ! " + player1.getName() + "WIN!");
    }else {
      player2.setAmountOfVictories(player2.getAmountOfVictories() + 1);
      player1.setAmountOfDefeats(player1.getAmountOfDefeats() + 1);
      printer.printInMiddleYellow("BLACK IS WINNER ! " + player2.getName() + "WIN!");
    }

    System.exit(1);
  }

  public static boolean isCanDoNextMove() {
    return canDoNextMove;
  }

  public static void setCanDoNextMove(boolean canDoNextMove) {
    Board.canDoNextMove = canDoNextMove;
  }
}
