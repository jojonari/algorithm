package dev.jojonari.algorithm.programmers.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KnumberTest {

    @Test
    void solution() {
        //given
        var sut = new Knumber();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        //when
        int[] actual = sut.solution(array, commands);

        //then
        assertArrayEquals(actual, new int[]{5, 6, 3});
    }

    @Test
    void solution2() {
        //given
        var sut = new Knumber();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        //when
        int[] actual = sut.solution2(array, commands);

        //then
        assertArrayEquals(actual, new int[]{5, 6, 3});
    }
}