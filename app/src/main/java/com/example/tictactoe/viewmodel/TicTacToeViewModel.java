package com.example.tictactoe.viewmodel;

//
// Created by Azmain Adel on 8/4/19.
//

import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;

import com.example.tictactoe.model.Board;
import com.example.tictactoe.model.enums.GameState;
import com.example.tictactoe.model.enums.Player;

public class TicTacToeViewModel implements ViewModel {

    private Board board;

    public final ObservableArrayMap<String, String> cells = new ObservableArrayMap<>();
    public final ObservableField<String> winner = new ObservableField<>();
    public final ObservableField<String> currentPlayer = new ObservableField<>();
    public final ObservableField<String> gameState = new ObservableField<>();

    public TicTacToeViewModel() {
        this.board = new Board();
    }


    @Override
    public void onCreate() {
        currentPlayer.set(board.getCurrentPlayer().toString());
        gameState.set(board.getGameState().toString());

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onResetSelected() {
        board.restartGame();
        gameState.set(board.getGameState().toString());
        winner.set(null);
        currentPlayer.set(board.getCurrentPlayer().toString());
        cells.clear();
    }

    public void onClickedCellAt(int row, int col) {
        Player playerThatMoved = board.mark(row, col);
        currentPlayer.set(board.getCurrentPlayer().toString());
        gameState.set(board.getGameState().toString());
        cells.put("" + row + col, (playerThatMoved == null) ? null : playerThatMoved.toString());
        winner.set((board.getWinner() == null) ? null : board.getWinner().toString());

    }
}
