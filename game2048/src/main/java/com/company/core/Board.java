package com.company.core;

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
    public abstract void fillBoard(List<V> list);

    /** Возвращаем все ключи, у которых значение null. */
    public abstract List<K> availableSpace();

    /** Добавляем элемент {@param value} по ключу {@param key}. */
    public abstract void addItem(K key, V value);

    /** Ищем уже существующий ключ по координатам {@param i} {@param j}. */
    public abstract K getKey(int i, int j);

    /** Получаем значение по {@param key} */
    public abstract V getValue(K key);

    /** Получаем столбец ключей, по которым потом можно будет выбрать значения. */
    public abstract List<K> getColumn(int j);

    /** Получаем строку ключей, по которым потом можно будет выбрать значения. */
    public abstract List<K> getRow(int i);

    /** Проверяем, есть ли такое значение на поле. */
    public abstract boolean hasValue(V value);

    /** Получаем строку значений по строке ключей. */
    public abstract List<V> getValues(List<K> keys);

}
