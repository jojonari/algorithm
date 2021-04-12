package dev.jojonari.algorithm.programmers.stackQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StockTest {

    @Test
    void 스택을_사용한_풀이() {
        //given
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = {4, 3, 1, 1, 0};
        var sut = new Stock();

        //when
        int[] actual = sut.solution(prices);

        //then
        assertArrayEquals(actual, result);
    }
    @Test
    void 스택을_사용하지_않은_풀이() {
        //given
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = {4, 3, 1, 1, 0};
        var sut = new Stock();

        //when
        int[] actual = sut.solutionNoneStack(prices);

        //then
        assertArrayEquals(actual, result);
    }
}