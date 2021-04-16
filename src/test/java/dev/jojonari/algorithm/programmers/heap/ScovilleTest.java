package dev.jojonari.algorithm.programmers.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScovilleTest {

    @Test
    void solution() {
        //given
        int[] scoville ={1, 2, 3, 9, 10, 12};
        int k = 7;
        var sut = new Scoville();

        //when
        int actual = sut.solution(scoville, k);

        //then
        assertEquals(actual, 2);
    }
}