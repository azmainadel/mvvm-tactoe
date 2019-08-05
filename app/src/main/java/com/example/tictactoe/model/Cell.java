package com.example.tictactoe.model;

//
// Created by Azmain Adel on 8/4/19.
//

import com.example.tictactoe.model.enums.Player;

public class Cell {
    private Player cellValue;

    public Player getCellValue() {
        return cellValue;
    }

    public void setCellValue(Player cellValue) {
        this.cellValue = cellValue;
    }
}
