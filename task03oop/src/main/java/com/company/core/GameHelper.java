package com.company.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GameHelper {
    /**
     * Перемещает в начало все элементы, при этом если 2 соседних элемента равны, то эти элементы должны объединиться в один
     *
     * @param list список значений
     * @return список обновленных значений
     */
    List<Integer> moveAndMergeEqual(List<Integer> list) {
        List<Integer> mergedList = mergeNotNulls(list);
        List<Integer> movedMergedList = moveNotNulls(mergedList);

        return movedMergedList;
    }

    private List<Integer> moveNotNulls(List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list);
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i) != null) {
                moveNotNull(newList, i);
            }
        }

        return newList;
    }

    private void moveNotNull(List<Integer> list, int currentPos) {
        if (currentPos == 0) return;
        for (int i = currentPos; i > 0 && list.get(i - 1) == null; i--) {
            list.set(i - 1, list.get(i));
            list.set(i, null);
        }
    }

    private List<Integer> mergeNotNulls(List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list);

        int i = 0;
        int j = i + 1;
        while (j < list.size()) {
            Integer leftValue = newList.get(i);
            Integer rightValue = newList.get(j);
            if (leftValue == null) {
                i++;
                j++;
            } else if (rightValue == null) {
                j++;
            } else if (leftValue.equals(rightValue)) {
                newList.set(i, leftValue + rightValue);
                newList.set(j, null);
                i = j + 1;
                j = i + 1;
            } else {
                i++;
                j++;
            }
        }

        return newList;
    }
}