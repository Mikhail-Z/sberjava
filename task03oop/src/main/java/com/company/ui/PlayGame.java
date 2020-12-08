package com.company.ui;

import com.company.core.Game2048;
import com.company.core.MyAnnotation;
import com.company.ui.Game2048Panel;

import javax.swing.*;
import java.beans.JavaBean;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.sql.SQLException;

class MyException extends Exception {

}

@MyAnnotation
public class PlayGame {
    public static void main(String[] args) {
        String[] values = {};
        @Target()
        Class clazz = Game2048.class;
        var fields = clazz.getFields();
        var declaredFields = clazz.getDeclaredFields();
        var annotations = clazz.getAnnotations();
        annotations
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