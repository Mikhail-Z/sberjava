package com.company;

interface Game {
    void init();
    boolean canMove();
    void move(Direction direction);
    void addItem();
    Board getGameBoard();
    boolean hasWin();
}
