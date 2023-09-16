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
  public void isMoveValidOneStepRight() {
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
  public void isMoveValidOneStepLeft() {
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
  public void isMoveValidTwoStepsRight() {
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
  public void isMoveValidTwoStepsLeft() {
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
  public void isMoveValidaAndCanKillNegativeTwoStepsLeftWhite() {
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
  public void isMoveValidaAndCanKillNegativeTwoStepsLeft() {
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
  public void isMoveValidAndCanKillNegativeSevenStepsLeft() {
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
}
