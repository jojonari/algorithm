package dev.jojonari.algorithm.programmers.stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * <p>
 * Math.ceil() : 소숫점 올림
 */
class Improvement {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        //작업 완료일을 큐에 추가
        for (int i = 0; i < progresses.length; i++) {
            int workload = 100 - progresses[i];
            queue.add(workload % speeds[i] == 0 ? workload / speeds[i] : workload / speeds[i] + 1);
        }

        List<Integer> result = new ArrayList<>();
        int baseDay = queue.poll();
        int deploy = 1;
        //큐를 기준으로 제일 앞에 있는 값과 비교하여 같거나 작으면 배포 수 증가, 그렇지 않으면 카운트된 배포수 정리 후 기준일 변경
        while (!queue.isEmpty()) {
            int workingDay = queue.poll();
            if (baseDay >= workingDay) {
                deploy++;
                continue;
            }

            result.add(deploy);
            deploy = 1; // 배포 초기화 workingDay가 baseDay에 대입되므로 +1로 시작
            baseDay = workingDay;
        }

        result.add(deploy);

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
