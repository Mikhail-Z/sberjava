package com.company.core;

public interface Game {
    void init();
    boolean canMove();
    void move(Direction direction) throws GameOverException;
    void addItem() throws GameOverException;
    Board getGameBoard();
    boolean hasWin();
}
