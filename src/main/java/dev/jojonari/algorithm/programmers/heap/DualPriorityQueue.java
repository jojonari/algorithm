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

        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            String[] s = operation.split(" ");

            if (s[0].equals("I")) {
                queueMin.offer(Integer.valueOf(s[1]));
                queueMax.offer(Integer.valueOf(s[1]));
                continue;
            }

            if (Integer.parseInt(s[1]) == 1) {
                Integer target = queueMax.poll();
                queueMin.remove(target);
                continue;
            }

            Integer target = queueMin.poll();
            queueMax.remove(target);
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