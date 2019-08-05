package com.example.tictactoe.viewmodel;

//
// Created by Azmain Adel on 8/4/19.
//

import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;

import com.example.tictactoe.model.Board;
import com.example.tictactoe.model.enums.Player;

public class TicTacToeViewModel implements ViewModel {

    private Board board;

    public final ObservableArrayMap<String, String> cells = new ObservableArrayMap<>();
    public final ObservableField<String> winner = new ObservableField<>();

    public TicTacToeViewModel() {
        this.board = new Board();
    }


    @Override
    public void onCreate() {

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
        winner.set(null);
        cells.clear();
    }

    public void onClickedCellAt(int row, int col) {
        Player playerThatMoved = board.mark(row, col);

        cells.put("" + row + col, (playerThatMoved == null) ? null : playerThatMoved.toString());

        winner.set((board.getWinner() == null) ? null : board.getWinner().toString());
    }
}
