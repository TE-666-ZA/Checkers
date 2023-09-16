package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import logics.KingLogics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KingLogicsTest {
  private KingLogics kingLogics;

  @BeforeEach
  public void setUp() {
    this.kingLogics = new KingLogics();
  }

  @Test
  public void differentRowDown() {
    int selectedRow = 3;
    int row = 7;
    int differentRow = kingLogics.differentRow(selectedRow, row);
    assertEquals(4, differentRow);
  }

  @Test
  public void differentRowUp() {
    int selectedRow = 7;
    int row = 3;
    int differentRow = kingLogics.differentRow(selectedRow, row);
    assertEquals(4, differentRow);
  }

  @Test
  public void differentColRight() {
    int selectedCol = 2;
    int col = 5;
    int differentCol = kingLogics.differentCol(selectedCol, col);
    assertEquals(3, differentCol);
  }

  @Test
  public void differentColLeft() {
    int selectedCol = 5;
    int col = 2;
    int differentCol = kingLogics.differentCol(selectedCol, col);
    assertEquals(3, differentCol);
  }

  @Test
  public void isMoveValidOneStepRightKingWhiteChecker() {
    int selectedRow = 2;
    int row = 3;
    int selectedCol = 1;
    int col = 2;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidOneStepLeftKingWhiteChecker() {
    int selectedRow = 2;
    int row = 3;
    int selectedCol = 1;
    int col = 0;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }
}
