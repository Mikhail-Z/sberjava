package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SquareBoard<V> extends Board<Key, V> {
    private int size;

    public SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    void fillBoard(List<V> list) {
        if (list.size() != size * size) {
            throw new IllegalArgumentException();
        }

        super.board.clear();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                V value = list.get(i * size + j);
                addItem(new Key(i, j), value);
            }
        }
    }

    List<Key> availableSpace() {
        return super.board.entrySet().stream()
                .filter(x -> x.getValue() == null)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    void addItem(Key key, V value) {
        super.board.put(key, value);
    }

    Key getKey(int i, int j) {
        var foundKey =  super.board.keySet().stream()
                .filter(integer -> integer.getI() == i && integer.getJ() == j)
                .findFirst();
        return foundKey.isEmpty() ? null : foundKey.get();
    }

    V getValue(Key key) {
        return super.board.get(key);
    }

    List<Key> getColumn(int j) {
        return super.board.keySet().stream()
                .filter(x -> x.getJ() == j)
                .sorted((o1, o2) -> o1.getI() < o2.getI() ? -1 : 1)
                .collect(Collectors.toList());
    }

    List<Key> getRow(int i) {
        return super.board.keySet().stream()
                .filter(y -> y.getI() == i)
                .sorted((o1, o2) -> o1.getJ() < o2.getJ() ? -1 : 1)
                .collect(Collectors.toList());
    }

    boolean hasValue(V value) {
        return super.board.containsValue(value);
    }

    List<V> getValues(List<Key> keys) {
        return keys.stream()
                .map(key -> super.board.getOrDefault(key, null))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Key key = getKey(i, j);
                V value = getValue(key);
                sb.append(value + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
