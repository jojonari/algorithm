package dev.jojonari.algorithm.programmers.hash;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class marathon {

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for (i = 0; i < completion.length; i++) {

            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }
}
