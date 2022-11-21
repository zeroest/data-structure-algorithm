package me.zeroest.datastructure.list.linked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @BeforeEach
    void beforeEach() {
        list = new MyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
    }

    @Test
    void add() {
        // when
        list.add(0, -1);
        Integer firstItem = list.get(0);

        // then
        assertEquals(-1, firstItem);
        assertEquals(6, list.size());
    }

    @Test
    void append() {
        // when
        list.append(6);

        // then
        assertEquals(6, list.size());
    }

    @Test
    void remove() {
        // when
        Integer result = list.remove(4);
        Integer wrongIdxResult = list.remove(9);

        // then
        assertEquals(5, result);
        assertNull(wrongIdxResult);
        assertEquals(4, list.size());
    }

    @Test
    void removeByData() {
        // when
        boolean result = list.remove(Integer.valueOf(5));

        // then
        assertTrue(result);
        assertEquals(4, list.size());
    }

    @Test
    void get() {
        // when
        Integer fourth = list.get(3);
        Integer expectNull = list.get(9);

        // then
        assertEquals(4, fourth);
        assertNull(expectNull);
    }

    @Test
    void set() {
        // when
        list.set(3, 9);
        Integer fourth = list.get(3);

        // then
        assertEquals(9, fourth);
    }

    @Test
    void indexOf() {
        // when
        int four = list.indexOf(5);
        int minusOne = list.indexOf(9);

        // then
        assertEquals(4, four);
        assertEquals(-1, minusOne);
    }

    @Test
    void size() {
        assertEquals(5, list.size());
    }

    @Test
    void isEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        list.clear();
        assertTrue(list.isEmpty());
    }
}