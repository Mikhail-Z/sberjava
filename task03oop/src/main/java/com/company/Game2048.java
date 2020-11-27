package com.company;

import java.util.Random;

public class Game2048 implements Game {
    GameHelper helper = new GameHelper();
    Board board;
    Random random = new Random();

    public Game2048(Board board) {
        this.board = board;
    }

    public void init() {

    }

    public boolean canMove() {
        return false;
    }

    public void move(Direction direction) {

    }

    public void addItem() {

    }

    public Board getGameBoard() {
        return null;
    }

    public boolean hasWin() {
        throw new UnsupportedOperationException();
    }
}
