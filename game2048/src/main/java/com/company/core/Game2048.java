package com.company.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game2048 implements Game {
    public static final int GAME_SIZE = 4;
    private static final int RANDOM_VALUE_WHEN_FOUR_INIT_VALUE_GENERATED = 0;
    private static final int TWO_INIT_VALUE = 2;
    private static final int FOUR_INIT_VALUE = 4;
    public static final int WIN_VALUE = 2048;

    public Game2048(Board<Key, Integer> board, GameHelper helper) {
        this.board = board;
        this.helper = helper;
    }

    private final Board<Key, Integer> board;

    private final GameHelper helper;
    Random random = new Random();

    public void init() {
        List<Integer> values = new ArrayList<>(GAME_SIZE * GAME_SIZE);
        for (int i = 0; i < GAME_SIZE * GAME_SIZE; i++) values.add(null);
        board.fillBoard(values);
        try {
            addItem();
            addItem();
        } catch (GameOverException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    public boolean canMove() {
        return board.availableSpace().size() > 0;
    }

    public void move(Direction direction) throws GameOverException {
        switch (direction) {
            case LEFT:
                moveLeft();
                addItem();
                break;
            case RIGHT:
                moveRight();
                addItem();
                break;
            case UP:
                moveUp();
                addItem();
                break;
            case DOWN:
                moveDown();
                addItem();
                break;
            default:
                throw new IllegalArgumentException(direction.name());
        }
    }

    public void addItem() throws GameOverException {
        if (!canMove()) {
            throw new GameOverException();
        }

        int newItem = generateInitValue();
        List<Key> availableSpace = board.availableSpace();
        int i = random.nextInt(availableSpace.size());
        board.addItem(availableSpace.get(i), newItem);
    }

    public Board getGameBoard() {
        return board;
    }

    public boolean hasWin() {
        Integer maxValue = TWO_INIT_VALUE;
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                Key key = board.getKey(i, j);
                Integer value = board.getValue(key);
                if (value != null && value > maxValue) {
                    maxValue = value;
                }
            }
        }

        return maxValue >= WIN_VALUE;
    }

    private int generateInitValue() {
        int value = this.random.nextInt(10);
        return value == RANDOM_VALUE_WHEN_FOUR_INIT_VALUE_GENERATED ? FOUR_INIT_VALUE : TWO_INIT_VALUE;
    }

    private void moveLeft() {
        for (int i = 0; i < GAME_SIZE; i++) {
            List<Key> rowKeys = board.getRow(i).stream()
                    .sorted((Key k1, Key k2) -> k1.getJ() < k2.getJ() ? -1 : 1)
                    .collect(Collectors.toList());
            List<Integer> values = board.getValues(rowKeys);
            List<Integer> mergedValues = helper.moveAndMergeEqual(values);
            for (int j = 0; j < mergedValues.size(); j++) {
                board.addItem(rowKeys.get(j), mergedValues.get(j));
            }
        }
    }

    private void moveRight() {
        for (int i = 0; i < GAME_SIZE; i++) {
            List<Key> rowKeys = board.getRow(i).stream()
                    .sorted((Key k1, Key k2) -> k1.getJ() < k2.getJ() ? 1 : -1)
                    .collect(Collectors.toList());
            List<Integer> values = board.getValues(rowKeys);
            List<Integer> mergedValues = helper.moveAndMergeEqual(values);
            for (int j = 0; j < mergedValues.size(); j++) {
                board.addItem(rowKeys.get(j), mergedValues.get(j));
            }
        }
    }

    private void moveUp() {
        for (int i = 0; i < GAME_SIZE; i++) {
            List<Key> columnKeys = board.getColumn(i).stream()
                    .sorted((Key k1, Key k2) -> k1.getI() < k2.getI() ? -1 : 1)
                    .collect(Collectors.toList());
            List<Integer> values = board.getValues(columnKeys);
            List<Integer> mergedValues = helper.moveAndMergeEqual(values);
            for (int j = 0; j < mergedValues.size(); j++) {
                board.addItem(columnKeys.get(j), mergedValues.get(j));
            }
        }
    }

    private void moveDown() {
        for (int i = 0; i < GAME_SIZE; i++) {
            List<Key> columnKeys = board.getColumn(i).stream()
                    .sorted((Key k1, Key k2) -> k1.getI() < k2.getI() ? 1 : -1)
                    .collect(Collectors.toList());
            List<Integer> values = board.getValues(columnKeys);
            List<Integer> mergedValues = helper.moveAndMergeEqual(values);
            for (int j = 0; j < mergedValues.size(); j++) {
                board.addItem(columnKeys.get(j), mergedValues.get(j));
            }
        }
    }
}
