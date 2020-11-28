package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board<K, V> {
    private int weight;
    private int height;
    protected Map<K, V> board;

    public Board(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.board = new HashMap<>();
    }

    /** Заполняем поле элементами из входного списка.
     * Если нужно задать пустой элемент, указываем null.
     */
    abstract void fillBoard(List<V> list);

    /** Возвращаем все ключи, у которых значение null. */
    abstract List<K> availableSpace();

    /** Добавляем элемент {@param value} по ключу {@param key}. */
    abstract void addItem(K key, V value);

    /** Ищем уже существующий ключ по координатам {@param i} {@param j}. */
    abstract K getKey(int i, int j);

    /** Получаем значение по {@param key} */
    abstract V getValue(K key);

    /** Получаем столбец ключей, по которым потом можно будет выбрать значения. */
    abstract List<K> getColumn(int j);

    /** Получаем строку ключей, по которым потом можно будет выбрать значения. */
    abstract List<K> getRow(int i);

    /** Проверяем, есть ли такое значение на поле. */
    abstract boolean hasValue(V value);

    /** Получаем строку значений по строке ключей. */
    abstract List<V> getValues(List<K> keys);

}
