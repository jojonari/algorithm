package dev.jojonari.algorithm.programmers.heap;

import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 *
 * PriorityQueue() : 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조
 * - 내부 요소는 힙으로 구성되어 이진트리 구조로 이루어져 있음
 * - 내부구조가 힙으로 구성되어 있기에 시간 복잡도는 O(NLogN)
 */
public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //우선순위 Queue 활용
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while (queue.size() > 1) {
            int first = queue.poll();
            //첫번째 값이 K보다 크거나 같으면 조건 만족
            if (first >= K) {
                break;
            }

            int second = queue.poll();

            answer++;
            int result = first + (second * 2);
            //마지막 계산값이 K보다 작으면 조건 만족 실패
            if (queue.isEmpty() && result < K) return -1;
            queue.add(result);
        }

        return answer;
    }
}
