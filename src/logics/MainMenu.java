package logics;


import graphics.code.ColoredPrinter;

public class MainMenu {

  ColoredPrinter printer;

  MainMenu() {
    printer = new ColoredPrinter();
  }


  public void showMainMenu() {
    printer.printInMiddlePurple("Checkers created by Natalya Seluynina & Kenan Iusubovi");
  }

}