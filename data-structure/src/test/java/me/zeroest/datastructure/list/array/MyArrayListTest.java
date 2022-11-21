package me.zeroest.datastructure.list.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void beforeEach() {
        list = new MyArrayList<>();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
    }


    @Test
    void add() {
        // given

        // when
        list.add(0, -1);
        list.add(0, -2);
        list.add(0, -3);
        list.add(0, -4);
        list.add(0, -5);
        list.add(0, -6);
        list.add(0, -7);

        // then
        assertEquals(12, list.size());
    }

    @Test
    void append() {
        // when
        list.append(6);

        // then
        assertEquals(6, list.size());
        assertEquals(5, list.indexOf(6));
    }

    @Test
    void remove() {
        // given
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);
        list.append(10);

        // when
        Integer firstLast = list.remove(9);
        Integer secondLast = list.remove(8);
        Integer firstItem = list.remove(0);

        // then
        assertEquals(7, list.size());
        assertEquals(10, firstLast);
        assertEquals(9, secondLast);
        assertEquals(1, firstItem);
    }

    @Test
    void removeEmptyList() {
        // given
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);

        // when
        Integer remove = list.remove(0);

        // then
        assertNull(remove);
    }

    @Test
    void removeItem() {
        // when
        boolean result = list.remove(Integer.valueOf(3));
        Integer removedIdxItem = list.get(2);

        // then
        assertTrue(result);
        assertEquals(4, list.size());
        assertEquals(4, removedIdxItem);
    }

    @Test
    void get() {
        // when
        Integer thirdIdxItem = list.get(2);

        // then
        assertEquals(3, thirdIdxItem);
    }

    @Test
    void set() {
        // given
        Integer settingItem = 9;
        list.set(2, settingItem);

        // when
        Integer thirdIdxItem = list.get(2);

        // then
        assertEquals(settingItem, thirdIdxItem);
    }

    @Test
    void indexOf() {
        // then
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
    }

    @Test
    void size() {
        // then
        assertEquals(5, list.size());
    }

    @Test
    void isEmpty() {
        // then
        assertFalse(list.isEmpty());
    }

    @Test
    void removeAndIsEmpty() {
        // given
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);

        // then
        assertTrue(list.isEmpty());
    }

    @Test
    void clear() {
        // when
        list.clear();
        Integer firstItem = list.get(0);

        // then
        assertNull(firstItem);
        assertTrue(list.isEmpty());
    }

}