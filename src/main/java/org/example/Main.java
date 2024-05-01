package org.example;

import org.example.dto.User;
import org.example.enums.CellType;
import org.example.exceptions.UserNotFoundException;

public class Main {
    public static void main(String[] args) throws UserNotFoundException {
        TicTacToeGame ticTacToeGame = new TicTacToeGame(3);
        ticTacToeGame.addUser1(new User("Player1", CellType.X));
        ticTacToeGame.addUser2(new User("Player2", CellType.O));
        ticTacToeGame.startGame();

    }
}
