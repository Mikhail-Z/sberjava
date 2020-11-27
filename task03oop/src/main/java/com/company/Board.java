package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {
    private int weight;
    private int height;
    protected Map<Key, Integer> board;

    public Board(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.board = new HashMap<>();
    }

    /** Заполняем поле элементами из входного списка.
     * Если нужно задать пустой элемент, указываем null.
     */
    abstract void fillBoard(List<Integer> list);

    /** Возвращаем все ключи, у которых значение null. */
    abstract List<Key> availableSpace();

    /** Добавляем элемент {@param value} по ключу {@param key}. */
    abstract void addItem(Key key, Integer value);

    /** Ищем уже существующий ключ по координатам {@param i} {@param j}. */
    abstract Key getKey(int i, int j);

    /** Получаем значение по {@param key} */
    abstract Integer getValue(Key key);

    /** Получаем столбец ключей, по которым потом можно будет выбрать значения. */
    abstract List<Key> getColumn(int j);

    /** Получаем строку ключей, по которым потом можно будет выбрать значения. */
    abstract List<Key> getRow(int i);

    /** Проверяем, есть ли такое значение на поле. */
    abstract boolean hasValue(Integer value);

    /** Получаем строку значений по строке ключей. */
    abstract List<Integer> getValues(List<Key> keys);

}
