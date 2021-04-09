package dev.jojonari.algorithm.programmers.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 *
 */
public class Truck {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 0;
        int index = 0;
        int bridgeWeight = 0;

        //여기서 Queue다리의 길이를 표현하며 1초에 한 칸씩 진행하게 된다.
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridgeLength - 1; i++) {
            bridge.add(0);
        }

        //첫 번째 트럭을 다리위에 올린다.
        bridge.add(truckWeights[index]);
        bridgeWeight += truckWeights[index];
        index++;
        answer++;

        //루프를 돌면서 트럭을 내리고, 올리기를 반복한다.
        while (!bridge.isEmpty()) {
            answer++;
            int truck = bridge.poll();
            bridgeWeight -= truck;

            //대기중인 트럭을 모두 큐에 쌓으면 더 이상 큐에 쌓지 않는다.
            if (truckWeights.length > index) {
                if (weight >= bridgeWeight + truckWeights[index]) {
                    int addTruck = truckWeights[index];
                    bridge.add(addTruck);
                    bridgeWeight += addTruck;
                    index++;
                } else {
                    //다리의 여유 무게보다 다음 트럭의 무게가 무거우면 큐에 0을 넣는다.
                    bridge.add(0);
                }
            }
        }

        return answer;
    }
}