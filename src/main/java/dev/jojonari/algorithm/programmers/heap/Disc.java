package dev.jojonari.algorithm.programmers.heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class Disc {
    public int solution(int[][] jobs) {
        int answer = 0; //각 잡의 대기시간 + 처리시간 총 합
        int currTime = 0; // 현재 시간
        int jobsIdx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 갯수
        int jobsSize = jobs.length;

        //요청시간 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        //우선순위큐 세팅 - 소요시간 오름차순 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while (count < jobsSize) {
            /**
             * 이부분이 중요
             * 현재시간 이전에 요청된 작업을 큐에 담음
             * 작업이 완료된 시간(currTime) 이전에 요청된 건 모두를 큐에 담음
             * 이요청 건들은 작업시간 순서로 큐에 담기고 짧은 순서대로 처리됨
             */
            while (jobsIdx < jobsSize && jobs[jobsIdx][0] <= currTime) {
                queue.offer(jobs[jobsIdx++]);
            }

            //큐가 비어있으면 남은 요청의 가장 처음값으로 세팅
            if (queue.isEmpty()) {
                currTime = jobs[jobsIdx][0];
                continue;
            }

            //큐에서 하나씩 꺼내어 처리
            int[] temp = queue.poll();
            currTime += temp[1]; //처리사간을 더 함
            answer += currTime - temp[0]; // 총 처리 시간에서 요청시간을 뺀다. 그래야 실제 대기시간 + 처리시간만 더해짐.
            count++;
        }

        return (int) Math.floor(answer / jobsSize);
    }
}