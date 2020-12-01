package com.company.ui;

import com.company.ui.Game2048Panel;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

class MyException extends Exception {

}

public class PlayGame {
    public static void main(String[] args) {

        JFrame game = new JFrame();
        game.setTitle("2048 Game");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(360, 360);
        game.setResizable(false);

        game.add(new Game2048Panel());

        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}