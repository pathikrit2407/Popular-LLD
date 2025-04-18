package SnakesAndLadders.model;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    private Integer boardSize;
    private Cell[][] cells;

    public Board(Integer boardSize, Integer noOfLadders, Integer noOfSnakes) {
        this.boardSize = boardSize;
        initialiseBoard(boardSize);
        initialiseLaddersAndSnakes(noOfLadders, noOfSnakes);
    }

    private void initialiseBoard(Integer boardSize) {

        cells = new Cell[boardSize][boardSize];

        for(int i=0;i<boardSize;i++) {
            for(int j=0;j<boardSize;j++) {
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }

    private void initialiseLaddersAndSnakes(Integer noOfLadders, Integer noOfSnakes) {
        while(noOfLadders > 0) {
            int start = ThreadLocalRandom.current().nextInt(0, boardSize*boardSize-1);
            int end = ThreadLocalRandom.current().nextInt(0, boardSize*boardSize-1);

            if (start < end) {
                Cell cell = findCell(start);
                cell.setJumpObject(new Jump(start, end));

                System.out.println("Ladder placed at position : " + start);
                noOfLadders--;
            }
        }

        while(noOfSnakes > 0) {
            int start = ThreadLocalRandom.current().nextInt(0, boardSize*boardSize-1);
            int end = ThreadLocalRandom.current().nextInt(0, boardSize*boardSize-1);

            if (start > end) {
                Cell cell = findCell(start);
                cell.setJumpObject(new Jump(start, end));

                System.out.println("Snake placed at position : " + start);
                noOfSnakes--;
            }
        }
    }

    public Cell findCell(Integer val) {
        int row = val/10, col = val%10;
        return cells[row][col];
    }

    public Integer getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }

}
