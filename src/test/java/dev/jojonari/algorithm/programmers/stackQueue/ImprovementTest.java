package dev.jojonari.algorithm.programmers.stackQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImprovementTest {

    @Test
    void solution() {
        //given
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        var sut = new Improvement();

        //when
        int[] actual = sut.solution(progresses, speeds);

        //then
        assertArrayEquals(actual, new int[]{2, 1});
    }

    @Test
    void solution2() {
        //given
        int[] progresses = {40, 93, 30, 55, 60, 65};
        int[] speeds = {60, 1, 30, 5 , 10, 7};
        var sut = new Improvement();

        //when
        int[] actual = sut.solution(progresses, speeds);

        //then
        assertArrayEquals(actual, new int[]{1,2,3});
    }
}