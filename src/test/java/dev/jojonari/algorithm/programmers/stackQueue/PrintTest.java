package dev.jojonari.algorithm.programmers.stackQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {

    @Test
    void solution() {
        //given
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        var sut = new Print();

        //when
        int actual = sut.solution(priorities, location);

        //then
        assertEquals(actual, 1);
    }

    @Test
    void solution2() {
        //given
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        var sut = new Print();

        //when
        int actual = sut.solution(priorities, location);

        //then
        assertEquals(actual, 5);
    }
}