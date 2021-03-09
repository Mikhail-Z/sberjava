package lesson01;

import lesson012.*;
import java.util.UUID;


public class Lesson01 {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        Lesson012 lesson = new Lesson012();
        for (var arg : args) {
            System.out.println(arg);
        }
    }
}