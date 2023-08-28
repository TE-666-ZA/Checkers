import graphics.code.Board;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Checkers!");
        JFrame frame = new JFrame("Checkers Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Board.BOARD_SIZE * Board.CELL_SIZE, Board.BOARD_SIZE * Board.CELL_SIZE);
        frame.add(new Board());
        frame.setVisible(true);
    }
}