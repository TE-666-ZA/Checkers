package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
  public void isMoveValidViolationDiagonalRight() {
    int selectedRow = 2;
    int row = 2;
    int selectedCol = 3;
    int col = 4;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 3, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidViolationDiagonalLeft() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 5;
    int col = 2;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 3, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidOneStepRightDown() {
    int selectedRow = 2;
    int row = 3;
    int selectedCol = 1;
    int col = 2;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
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
  public void isMoveValidOneStepRightUp() {
    int selectedRow = 5;
    int row = 4;
    int selectedCol = 4;
    int col = 5;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 3, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidOneStepLeftDown() {
    int selectedRow = 2;
    int row = 3;
    int selectedCol = 1;
    int col = 0;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
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
  public void isMoveValidOneStepLeftUp() {
    int selectedRow = 7;
    int row = 6;
    int selectedCol = 4;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 0, 0, 2, 0, 2},
        {2, 0, 2, 0, 4, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidNegativeOneStepRight() {
    int selectedRow = 2;
    int row = 3;
    int selectedCol = 1;
    int col = 2;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
        {0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidNegativeOneStepLeft() {
    int selectedRow = 2;
    int row = 3;
    int selectedCol = 1;
    int col = 0;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
        {2, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidTwoStepsRightDown() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 1;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
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
  public void isMoveValidTwoStepsLeftDown() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 3;
    int col = 1;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
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
  public void isMoveValidTwoStepsRightUp() {
    int selectedRow = 6;
    int row = 4;
    int selectedCol = 1;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 2, 0, 2, 0},
        {0, 3, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidTwoStepsLeftUp() {
    int selectedRow = 5;
    int row = 3;
    int selectedCol = 6;
    int col = 4;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 2, 0, 4, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidButCanKillTwoStepsRightKingWhite() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 1;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
        {0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidButCanKillTwoStepsRightKingBlack() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 3;
    int col = 5;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 4, 0, 1, 0, 1},
        {0, 0, 0, 0, 3, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidNegativeTwoStepsRight() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 1;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidAndCanKillNegativeTwoStepsRightWhite() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 1;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
        {0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidAndCanKillNegativeTwoStepsRightBlack() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 1;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 4, 0, 1, 0, 1, 0, 1},
        {0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidAndCanKillNegativeTwoStepsRight() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 1;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 3, 0, 1, 0, 1, 0, 1},
        {0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }
  @Test
  public void isMoveValidButCanKillTwoStepsLeftWhite() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 3;
    int col = 1;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
        {0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidNegativeTwoStepsLeft() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 3;
    int col = 1;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 2, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidAndCanKillNegativeTwoStepsLeftWhite() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 3;
    int col = 1;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
        {0, 0, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidAndCanKillNegativeTwoStepsLeft() {
    int selectedRow = 2;
    int row = 4;
    int selectedCol = 3;
    int col = 1;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
        {0, 0, 2, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidNegativeThreeStepsRightDown() {
    int selectedRow = 3;
    int row = 6;
    int selectedCol = 2;
    int col = 5;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 0, 0},
        {2, 0, 2, 0, 0, 0, 2, 0},
        {0, 2, 0, 2, 0, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidThreeStepsRightDown() {
    int selectedRow = 3;
    int row = 6;
    int selectedCol = 2;
    int col = 5;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 0, 0, 2, 0},
        {0, 2, 0, 2, 0, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidNegativeThreeStepsLeftDown() {
    int selectedRow = 2;
    int row = 5;
    int selectedCol = 5;
    int col = 2;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 4, 0, 1},
        {0, 0, 3, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 0, 0, 2, 0},
        {0, 2, 0, 2, 0, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidThreeStepsLeftDown() {
    int selectedRow = 2;
    int row = 5;
    int selectedCol = 5;
    int col = 2;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 4, 0, 1},
        {0, 0, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 0, 0, 2, 0},
        {0, 2, 0, 2, 0, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidNegativeThreeStepsRightUp() {
    int selectedRow = 6;
    int row = 3;
    int selectedCol = 1;
    int col = 4;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 1, 0, 0, 0, 2, 0},
        {0, 4, 0, 2, 0, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidThreeStepsRightUp() {
    int selectedRow = 6;
    int row = 3;
    int selectedCol = 1;
    int col = 4;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 0, 0, 2, 0},
        {0, 4, 0, 2, 0, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidNegativeThreeStepsLeftUp() {
    int selectedRow = 6;
    int row = 3;
    int selectedCol = 7;
    int col = 4;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 1, 0, 0, 0, 3, 0},
        {0, 2, 0, 2, 0, 0, 0, 4},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidSevenStepsLeft() {
    int selectedRow = 0;
    int row = 7;
    int selectedCol = 7;
    int col = 0;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 3},
        {1, 0, 1, 0, 1, 0, 0, 0},
        {0, 1, 0, 3, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 2, 0, 2, 0, 2},
        {0, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidSevenStepsRight() {
    int selectedRow = 0;
    int row = 7;
    int selectedCol = 0;
    int col = 7;
    int[][] board = {
        {3, 0, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 2, 0, 2, 0, 2},
        {0, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidNegativeSevenStepsLeft() {
    int selectedRow = 0;
    int row = 7;
    int selectedCol = 7;
    int col = 0;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 3},
        {1, 0, 1, 0, 1, 0, 0, 0},
        {0, 1, 0, 3, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 2, 0, 2, 0, 2},
        {1, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidAndCanKillSevenStepsLeftWhite() {
    int selectedRow = 0;
    int row = 7;
    int selectedCol = 7;
    int col = 0;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 3},
        {1, 0, 1, 0, 1, 0, 0, 0},
        {0, 1, 0, 3, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 2, 0, 2, 0},
        {0, 4, 0, 2, 0, 2, 0, 2},
        {0, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertTrue(result);
  }

  @Test
  public void isMoveValidAndCanKillNegativeSevenStepsRight() {
    int selectedRow = 7;
    int row = 0;
    int selectedCol = 0;
    int col = 7;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 0},
        {1, 0, 1, 0, 1, 0, 0, 0},
        {0, 1, 0, 3, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 0, 0},
        {2, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 2, 0, 2, 0, 2},
        {4, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isCanDoNextMoveValidKingWhiteRightDown() {
    int row = 2;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
        {0, 0, 3, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isCanDoNextMoveValid(board, row, col);
    assertTrue(result);
  }

  @Test
  public void isCanDoNextMoveValidKingWhiteLeftDown() {
    int row = 2;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 3, 0, 1, 0, 1},
        {0, 0, 4, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isCanDoNextMoveValid(board, row, col);
    assertTrue(result);
  }

  @Test
  public void isCanDoNextMoveValidKingWhiteRightUp() {
    int row = 4;
    int col = 1;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 4, 0, 2, 0, 0, 0},
        {0, 3, 0, 0, 0, 1, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isCanDoNextMoveValid(board, row, col);
    assertTrue(result);
  }

  @Test
  public void isCanDoNextMoveValidKingWhiteLeftUp() {
    int row = 3;
    int col = 0;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0},
        {0, 2, 0, 0, 0, 1, 0, 1},
        {3, 0, 0, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isCanDoNextMoveValid(board, row, col);
    assertTrue(result);
  }

  @Test
  public void isCanDoNextMoveValidKingBlackRightDown() {
    int row = 2;
    int col = 1;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 4, 0, 1, 0, 1, 0, 1},
        {0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isCanDoNextMoveValid(board, row, col);
    assertTrue(result);
  }

  @Test
  public void isCanDoNextMoveValidKingBlackLeftDown() {
    int row = 3;
    int col = 4;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 4, 0, 0, 0},
        {0, 0, 0, 3, 0, 0, 0, 0},
        {2, 0, 0, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isCanDoNextMoveValid(board, row, col);
    assertTrue(result);
  }

  @Test
  public void isCanDoNextMoveValidKingBlackRightUp() {
    int row = 6;
    int col = 3;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 1, 0, 2, 0},
        {0, 2, 0, 4, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isCanDoNextMoveValid(board, row, col);
    assertTrue(result);
  }

  @Test
  public void isCanDoNextMoveValidKingBlackLeftUp() {
    int row = 3;
    int col = 2;
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 1, 0, 1, 0},
        {1, 4, 1, 1, 0, 1, 0, 1},
        {1, 0, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    boolean result = kingLogics.isCanDoNextMoveValid(board, row, col);
    assertTrue(result);
  }
}
