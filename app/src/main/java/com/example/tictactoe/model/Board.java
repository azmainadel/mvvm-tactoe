package com.example.tictactoe.model;

//
// Created by Azmain Adel on 8/4/19.
//

import com.example.tictactoe.model.enums.GameState;
import com.example.tictactoe.model.enums.Player;

import static com.example.tictactoe.model.enums.GameState.FINISHED;
import static com.example.tictactoe.model.enums.GameState.IN_PROGRESS;

public class Board {

    private Cell[][] cells = new Cell[3][3];

    private GameState gameState;
    private Player currentPlayer;
    private Player winner;

    public Board() {
        restartGame();
    }

    public void restartGame() {
        clearCells();

        gameState = IN_PROGRESS;
        currentPlayer = Player.X;
        winner = null;
    }

    private void clearCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Player mark(int row, int col) {

        Player playerThatMoved = null;

        if (isValid(row, col)) {

            cells[row][col].setCellValue(currentPlayer);
            playerThatMoved = currentPlayer;

            if (isWinningMoveByPlayer(currentPlayer, row, col)) {
                gameState = FINISHED;
                winner = currentPlayer;

            } else {
                flipCurrentTurn();
            }
        }

        return playerThatMoved;
    }

    private boolean isWinningMoveByPlayer(Player player, int currentRow, int currentCol) {

        return (cells[currentRow][0].getCellValue() == player
                && cells[currentRow][1].getCellValue() == player
                && cells[currentRow][2].getCellValue() == player
                || cells[0][currentCol].getCellValue() == player
                && cells[1][currentCol].getCellValue() == player
                && cells[2][currentCol].getCellValue() == player
                || currentRow == currentCol
                && cells[0][0].getCellValue() == player
                && cells[1][1].getCellValue() == player
                && cells[2][2].getCellValue() == player
                || currentRow + currentCol == 2
                && cells[0][2].getCellValue() == player
                && cells[1][1].getCellValue() == player
                && cells[2][0].getCellValue() == player);
    }

    private void flipCurrentTurn() {
        currentPlayer =
                (currentPlayer == Player.X) ? Player.O : Player.X;
    }

    private boolean isValid(int row, int col) {
        if (gameState == FINISHED) {
            return false;
        } else if (isOutOfBounds(row) || isOutOfBounds(col)) {
            return false;
        } else if (isCellValueAlreadySet(row, col)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isOutOfBounds(int idx) {
        return idx < 0 || idx > 2;
    }

    private boolean isCellValueAlreadySet(int row, int col) {
        return cells[row][col].getCellValue() != null;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }
}
