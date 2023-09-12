# CHECKERS GAME


The idea of the project is to recreate the well-known game of checkers. This project is for completely different people who can pursue their goals in the game. The user can play one with himself or with another player. In the course of the project, it is planned to implement a game with a computer and with artificial intelligence.

## Technical requirements

- To write the project, we used the Java SE 20 version.
- To run the tests in this project, the JUnit 5 framework is used.
- To run the program, use the Main class, which is located in the "logic" folder.

```java
     PlayerLogics movementLogics = new PlayerLogics();
     MainMenu menu = new MainMenu();

     menu.showMainMenu();
```

- The game requires a file ""src/logic/res/playersStatistics.csv", where the names of players and their statistics are stored.

## Project structure

There are 2 main folders in our project:

1. **"graphics"**
   - There are 2 classes in the "code" folder.
      - The Board class was created to draw the game itself, the playing field and the movements of checkers, and it also has methods that control the number of checkers available in the game, and implement their counting and conclusion about the end of the game.
      - The ColoredPrinter class allows you to output text in different colors, including in the center of the console.
   - The "sprite" folder contains images of checkers:


   ![White king's checker](C:\Users\selun\IdeaProjects\Checkers\src\graphics\sprites\whiteKingSprite.png)
   ![Black king's checker](C:\Users\selun\IdeaProjects\Checkers\src\graphics\sprites\blackKingSprite.png)
   ![White checker](C:\Users\selun\IdeaProjects\Checkers\src\graphics\sprites\whiteSprite.png)
   ![Black checker](C:\Users\selun\IdeaProjects\Checkers\src\graphics\sprites\blackSprite.png)

2. **"logics"**
   - There are the following classes in the folder:
      - The FileReader class allows you to read data from a file when starting a game and overwrite the changed data to a file for further use when exiting the game.
      - The Player class is created to store information about the player, his name and statistics.
      - In the PlayerLogics class, the logic of moving an ordinary checker and eating the opponent's checkers is implemented.
      - In the KingLogics class, the logic of the movement of the queen and the eating of the opponent's checkers is implemented.
      - In the ComLogics class, it is planned to implement logic for playing with a computer.
      - The MainMenu class demonstrates the main menu of the program when starting the game, gives you the opportunity to choose the game mode, you can play one, two, with a computer and watch the battle of the computer with yourself. Also, this class can show player statistics and allows you to choose the color of checkers.
   - A file with the names of players and their statistics is stored in the "res" folder.


3. **"tests"**
   Tests for the following classes are written in this folder:
