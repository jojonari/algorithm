package dev.jojonari.algorithm.programmers.stackQueue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TruckTest {

    @Test
    void 한_대의_트럭만_있는_경우() {
        //given
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = { 10};
        var sut = new Truck();

        //when
        int actual = sut.solution(bridgeLength, weight, truckWeights);

        //then
        assertEquals(actual, 101);
    }

    @Test
    void 다리와_트럭의_무게가_서로_다른_경우() {
        //given
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7, 4, 5, 6};
        var sut = new Truck();

        //when
        int actual = sut.solution(bridgeLength, weight, truckWeights);

        //then
        assertEquals(actual, 8);
    }

    @Test
    void 트럭의_무게가_모두_같은_경우() {
        //given
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};
        var sut = new Truck();

        //when
        int actual = sut.solution(bridgeLength, weight, truckWeights);

        //then
        assertEquals(actual, 110);
    }

}