package SnakesAndLadders;

import SnakesAndLadders.model.*;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    private Board board;
    private Dice dice;
    private Deque<Player> players;
    private Player winner;

    public Game() {
        this.board = new Board(10, 4, 4);
        this.dice = new Dice(1, 1, 6);
        this.players = new ArrayDeque<>();
        this.winner = null;

        initialisePlayers();
    }

    private void initialisePlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);

        this.players.add(player1);
        this.players.add(player2);
    }

    public void playGame() {
        while(this.winner == null) {
            Player player = getNextPlayer();
            Integer diceVal = this.dice.rollDice(), currentPosition = player.getCurrentPosition();
            System.out.println("Turn of Player : " + player.getPlayerName() + " in position : " + currentPosition);
            System.out.println("Player " + player.getPlayerName() + " rolled dice and got value :" + diceVal);
            currentPosition += diceVal;
            currentPosition = checkSnakeOrLadderJumpPosition(currentPosition, player);
            if (currentPosition > this.board.getBoardSize() * this.board.getBoardSize() - 1) {
                System.out.println("Player " + player.getPlayerName() + " wins the match!!!!");
                winner = player;
            }
            player.setCurrentPosition(currentPosition);
        }

    }

    private Integer checkSnakeOrLadderJumpPosition(Integer currentPosition, Player player) {
        if (currentPosition > this.board.getBoardSize() * this.board.getBoardSize() -1) {
            return currentPosition;
        }
        Cell cell = this.board.findCell(currentPosition);
        Jump jump = cell.getJumpObject();
        if (jump != null && jump.getStartPosition().equals(currentPosition)) {
            System.out.println("Player "+ player.getPlayerName() +" Encountered "
                    + (jump.getStartPosition() < jump.getEndPosition() ? "Ladder" : "Snake") + " at position " + currentPosition);
           currentPosition = jump.getEndPosition();
        }
        return currentPosition;
    }

    private Player getNextPlayer() {
        Player player = this.players.getFirst();
        this.players.removeFirst();
        this.players.addLast(player);
        return player;
    }
}
