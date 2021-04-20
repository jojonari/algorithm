package dev.jojonari.algorithm.programmers.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DualPriorityQueueTest {

    @Test
    void solution() {
        //given
        var sut = new DualPriorityQueue();
        String[] operations = {"I 16", "D 1"};

        //when
        int[] actual = sut.solution(operations);

        //than
        assertArrayEquals(actual, new int[]{0, 0});
    }

    @Test
    void solution2() {
        //given
        var sut = new DualPriorityQueue();
        String[] operations = {"I 7","I 5","I -5","D -1"};

        //when
        int[] actual = sut.solution(operations);

        //than
        assertArrayEquals(actual, new int[]{7, 5});
    }
}