package dev.jojonari.algorithm.programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 *
 * Comparator.reverseOrder() : 내림 차순 정렬
 */
public class DualPriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queueMin = new PriorityQueue<>();
        PriorityQueue<Integer> queueMax = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String[] operaterArr = operation.split(" ");
            Integer intValue = Integer.valueOf(operaterArr[1]);

            if ("I".equals(operaterArr[0])) {
                queueMin.offer(intValue);
                queueMax.offer(intValue);
                continue;
            }

            if (intValue == 1) {
                queueMin.remove(queueMax.poll());
                continue;
            }

            queueMax.remove(queueMin.poll());
        }

        if (queueMin.isEmpty()) {
            queueMin.offer(0);
        }

        if (queueMax.isEmpty()) {
            queueMax.offer(0);
        }

        return new int[]{queueMax.poll(), queueMin.poll()};
    }
}