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
    movementLogics = new PlayerLogics();
    isPlayALone = true;
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
        if (activePlayer.isMoveValid(board, row, col, selectedRow, selectedCol)) {
            board[row][col] = board[selectedRow][selectedCol];
            board[selectedRow][selectedCol] = 0;
          movementLogics.isKing(row, col);
            selectedRow = -1;
            selectedCol = -1;
          if (!activePlayer.isCanDoNextMove()) {
            activePlayer.changeMoveColor();
            }
          }

        repaint();
      }
    });
  }

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
    //FIXME
    // vidilyaem kraya doski cvetom
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
        if (piece == PlayerLogics.getWhitechecker()) {
          g.drawImage(whitePieceImage, x, y, null);
        } else if (piece == PlayerLogics.getBlackchecker()) {
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
    } else if (movementLogics.isCanDoNextMove()) {
      g.setColor(Color.RED);
      g.drawRect(movementLogics.getLastColPosition() * CELL_SIZE,
          movementLogics.getLastRowPosition() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
  }

  public static void setKing(int row, int col) {
    if (board[row][col] == PlayerLogics.getWhitechecker()) {
      board[row][col] = KingLogics.getKING_WHITE_CHECKER();
    } else if (board[row][col] == PlayerLogics.getBlackchecker()) {
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

  public static void setPlayer1(Player player) {
    player1 = player;
  }

  public static void setPlayer2(Player player) {
    player2 = player;
  }

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
    // TODO увеличение побед белых и увеличение поражений черных
    System.out.println("Игра завершена! Белые выиграли!");
    System.exit(1);
  }

  /**
   * The end of the game with the victory of the black checkers and exit the game
   */
  public static void gameOverWithBlackVictory() {
    // TODO увеличение побед черных и увеличение поражений белых
    System.out.println("Игра завершена! Черные выиграли!");
    System.exit(1);
  }
}
