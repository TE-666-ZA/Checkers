import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board extends JPanel {
    static final int BOARD_SIZE = 8;
    static final int CELL_SIZE = 60;
    static final Color LIGHT_COLOR = new Color(227, 193, 111);
    static final Color DARK_COLOR = new Color(175, 135, 83);

    private BufferedImage whitePieceImage;
    private BufferedImage blackPieceImage;

    private int[][] board = {
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 0, 2, 0, 2, 0},
            {0, 2, 0, 2, 0, 2, 0, 2},
            {2, 0, 2, 0, 2, 0, 2, 0}
    };

    private int selectedRow = -1;
    private int selectedCol = -1;

    public Board() {
        try {
            whitePieceImage = ImageIO.read(new File("graphics/res/whiteSprite.png"));
            blackPieceImage = ImageIO.read(new File("graphics/res/blackSprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = e.getY() / CELL_SIZE;
                int col = e.getX() / CELL_SIZE;

                if (selectedRow == -1) {
                    if (board[row][col] != 0) {
                        selectedRow = row;
                        selectedCol = col;
                    }
                } else {
                    // Здесь реализуйте логику перемещения шашек
                    board[row][col] = board[selectedRow][selectedCol];
                    board[selectedRow][selectedCol] = 0;
                    selectedRow = -1;
                    selectedCol = -1;
                }

                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

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
            g.setColor(Color.GREEN);
            g.drawRect(selectedCol * CELL_SIZE, selectedRow * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }
}
