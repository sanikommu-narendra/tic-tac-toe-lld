package org.example.dto;

import org.example.enums.CellType;

public class Board {
    private final int n;
    private final CellType[][] cells;
    private Board(int n) {
        this.n = n;
        cells = new CellType[n][n];
        for(int i=0 ;i<n; i++) {
            for(int j=0; j<n; j++) {
                cells[i][j] = CellType.EMPTY;
            }
        }
    }

    public void printBoard() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                System.out.print(cells[i][j].name() + "\t\t");
            System.out.println();
        }
    }

    public int getN() {
        return n;
    }

    public CellType[][] getCells() {
        return cells;
    }

    private static Board board = null;

    public static Board getInstance(int n) {
        if(board == null) {
            synchronized (Board.class) {
                if(board == null)
                    board = new Board(n);
            }
        }
        return board;
    }


}
