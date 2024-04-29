package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {

    private CustomList<Integer> customList;

    @BeforeEach
    void setUp() {
        customList = new CustomList<>();
    }

    @Test
    void add() {
        customList.add(1);
        assertEquals(1, customList.size());
        assertEquals(Integer.valueOf(1), customList.get(0));
    }

    @Test
    void addAll() {
        Integer[] elements = {1, 2, 3};
        customList.addAll(elements);
        assertEquals(3, customList.size());
        assertEquals(Integer.valueOf(1), customList.get(0));
        assertEquals(Integer.valueOf(2), customList.get(1));
        assertEquals(Integer.valueOf(3), customList.get(2));
    }

    @Test
    void testAddWithIndex() {
        customList.add(0, 1);
        customList.add(1, 3);
        customList.add(1, 2);
        assertEquals(3, customList.size());
        assertEquals(Integer.valueOf(1), customList.get(0));
        assertEquals(Integer.valueOf(2), customList.get(1));
        assertEquals(Integer.valueOf(3), customList.get(2));
    }

    @Test
    void remove() {
        customList.add(1);
        customList.add(2);
        Integer removedElement = customList.remove(0);
        assertEquals(Integer.valueOf(1), removedElement);
        assertEquals(1, customList.size());
        assertEquals(Integer.valueOf(2), customList.get(0));
    }

    @Test
    void clear() {
        customList.add(1);
        customList.add(2);
        customList.clear();
        assertEquals(0, customList.size());
    }

    @Test
    void get() {
        customList.add(1);
        assertEquals(Integer.valueOf(1), customList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> customList.get(1));
    }

    @Test
    void size() {
        assertEquals(0, customList.size());
        customList.add(1);
        assertEquals(1, customList.size());
    }
}