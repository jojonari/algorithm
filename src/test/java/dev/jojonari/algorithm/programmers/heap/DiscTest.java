package dev.jojonari.algorithm.programmers.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscTest {

    @Test
    void solution() {
        //given
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        var sut = new Disc();

        //when
        int actual = sut.solution(jobs);

        //then
        assertEquals(actual, 9);
    }
}