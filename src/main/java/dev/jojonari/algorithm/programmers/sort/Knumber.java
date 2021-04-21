package dev.jojonari.algorithm.programmers.sort;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 *
 * class java.util.Arrays : 배열을 다루기 위한 다양한 메소드 지원
 */
public class Knumber {
    /**
     * Arrays를 사용하여 구현
     * @param array
     * @param commands
     * @return
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int from = command[0] - 1;
            int to = command[1];

            //Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) : 배열의 특정 구역 복사
            int[] target = Arrays.copyOfRange(array, from, to);
            Arrays.sort(target);
            answer[i] = target[command[2] - 1];
        }
        return answer;
    }

    /**
     * 직접 구현하는 코드
     * @param array
     * @param commands
     * @return
     */
    public int[] solution2(int[] array, int[][] commands) {
        int n = 0;
        int[] ret = new int[commands.length];

        while (n < commands.length) {
            int arrSize = commands[n][1] - commands[n][0] + 1;

            if (arrSize == 1) {
                ret[n] = array[commands[n++][0] - 1];
                continue;
            }

            int[] sliceArr = new int[arrSize];
            int j = 0;
            for (int i = commands[n][0] - 1; i < commands[n][1]; i++)
                sliceArr[j++] = array[i];

            sort(sliceArr, 0, arrSize - 1);

            ret[n] = sliceArr[commands[n++][2] - 1];
        }

        return ret;
    }

    /**
     * 퀵소트 구현
     * @param array
     * @param left
     * @param right
     */
    void sort(int[] array, int left, int right) {
        int pl = left;
        int pr = right;
        int x = array[(pl + pr) / 2];

        do {
            while (array[pl] < x) pl++;
            while (array[pr] > x) pr--;
            if (pl <= pr) {
                int temp = array[pl];
                array[pl] = array[pr];
                array[pr] = temp;
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (left < pr) sort(array, left, pr);
        if (right > pl) sort(array, pl, right);
    }
}