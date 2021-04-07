package dev.jojonari.algorithm.programmers.hash;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Camouflage {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }
}
