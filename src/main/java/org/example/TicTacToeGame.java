package org.example;

import org.example.dto.Board;
import org.example.dto.User;
import org.example.enums.CellType;
import org.example.enums.GameState;
import org.example.exceptions.UserNotFoundException;

import java.util.Scanner;

public class TicTacToeGame {
    private Board board;
    private User user1;
    private User user2;

    private GameState state;

    TicTacToeGame(int n) {
        board = Board.getInstance(n);
        state = GameState.NOT_STARTED;
    }

    public void addUser1(User user) {
        user1 = user;
    }

    public void addUser2(User user) {
        user2 = user;
    }

    public void startGame() throws UserNotFoundException{
        if(user1 == null || user2 == null)
            throw new UserNotFoundException();

        state = GameState.IN_PROGRESS;
        Scanner scanner = new Scanner(System.in);
        board.printBoard();

        int n = board.getN();
        int totalMoves = n * n;

        for(int i=0; i<totalMoves; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            while (!isEmptyCell(row, col)) {
                row = scanner.nextInt();
                col = scanner.nextInt();
            }

            User user = null;
            CellType type = null;

            if(i%2 == 1) {
                user = user1;
                type = CellType.X;

                markCell(row, col, type);
                board.printBoard();
                if(checkIsSuccess(row, col, type)) {
                    this.state = GameState.COMPLETED;
                    System.out.println("Winner is " + user.toString());
                    System.exit(1);
                }


            } else {
                user = user2;
                type = CellType.O;
                markCell(row, col, type);
                board.printBoard();
                if(checkIsSuccess(row, col, type)) {
                    this.state = GameState.COMPLETED;
                    System.out.println("Winner is " + user.toString());
                    System.exit(1);
                }
            }
        }

        this.state = GameState.COMPLETED;
        System.out.println("Game is Draw ");
        System.exit(1);

    }

    public void markCell(int row, int cell, CellType type) {
        board.getCells()[row][cell] = type;
    }

    public boolean isEmptyCell(int row, int col) {
        return board.getCells()[row][col] == CellType.EMPTY;
    }
    public boolean checkIsSuccess(int row, int col, CellType type) {
        int n = board.getN();
        boolean flag = true;
        for(int i=0; i <n; i++)
            if(board.getCells()[row][i] == CellType.EMPTY || board.getCells()[row][i] != type)
                flag = false;
        if(flag)
            return true;

        flag = true;
        for(int i=0; i <n; i++)
            if(board.getCells()[i][col] == CellType.EMPTY || board.getCells()[i][col] != type)
                flag = false;
        if(flag)
            return true;

        if(row == col) {
            for(int i=0,j=0; i<n; i++,j++) {
                if(board.getCells()[i][j] == CellType.EMPTY || board.getCells()[i][j] != type)
                    return false;
            }
            return true;
        }

        return false;
    }

}



