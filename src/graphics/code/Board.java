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
import logics.PlayerLogics;

public class Board extends JPanel {

  public static final int BOARD_SIZE = 8;
  public static final int CELL_SIZE = 100;
  public static final Color LIGHT_COLOR = new Color(194, 158, 120);
  public static final Color DARK_COLOR = new Color(2, 1, 1);

  private PlayerLogics movementLogics;
  private BufferedImage whitePieceImage;
  private BufferedImage blackPieceImage;
  private static int selectedRow;
  private static int selectedCol;
  private static String player1Name;
  private static String player2Name;

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
    try {
      whitePieceImage = ImageIO.read(new File("src/graphics/sprites/whiteSprite.png"));
      blackPieceImage = ImageIO.read(new File("src/graphics/sprites/blackSprite.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    selectedRow = -1;
    selectedCol = -1;
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = e.getY() / Board.CELL_SIZE;
        int col = e.getX() / Board.CELL_SIZE;

        if (selectedRow == -1) {
          if (board[row][col] != 0 && board[row][col] == movementLogics.getCheckerMove()) {
            selectedRow = row;
            selectedCol = col;
          }

        } else if (board[row][col] != 0 && board[row][col] == movementLogics.getCheckerMove()) {
          selectedRow = row;
          selectedCol = col;
        }
        if (movementLogics.isMoveValid(board, row, col, selectedRow, selectedCol)) {
            board[row][col] = board[selectedRow][selectedCol];
            board[selectedRow][selectedCol] = 0;
            selectedRow = -1;
            selectedCol = -1;
            if (!movementLogics.isCanDoNextMove()) {
              movementLogics.changeMoveColor();
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
    g.drawString("Player 1: " + player1Name, 10, getHeight() - 30);
    g.setColor(Color.green);
    g.drawString("Player 2: " + player2Name, 10, getHeight() - 10);
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
        if (piece == 1) {
          g.drawImage(whitePieceImage, x, y, null);
        } else if (piece == 2) {
          g.drawImage(blackPieceImage, x, y, null);
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

  public int[][] getBoard() {
    return board;
  }

  public static void setPlayer1Name(String Name) {
    player1Name = Name;
  }

  public static void setPlayer2Name(String Name) {
    player2Name = Name;
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

  public static void setSelectedRow(int row) {
    selectedRow = row;
  }

  public static void setSelectedCol(int col) {
    selectedCol = col;
  }
}
