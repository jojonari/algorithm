package dev.jojonari.algorithm.programmers.stackQueue;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class Stock {
    /**
     * 스택을 사용한 풀이
     *
     * Stack.peek() : Stack의 맨 위에서 개체를 제거하지 않고 반환합니다.
     * Stack.pop() : Stack의 맨 위에서 개체를 제거하고 반환합니다.
     * Stack.add() : Stack은 Vector를 상속받고 있는데 Vector는 List도 구현하고 있다.
     *               -> add()사용도 가능하지만, Stack을 사용할 때는 push를 사용하자.
     *               -> push()의 리턴값은 <E>이고, add()의 리턴값은 boolean이다.
     * @param prices
     * @return
     */
    public int[] solution(int[] prices) {
        int times = prices.length;
        int[] answer = new int[times];
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (; i < times; i++) {
            while (!stack.empty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.add(i);
        }

        while (!stack.empty()) {
            int index = stack.pop();
            answer[index] = i - index - 1;
        }

        return answer;
    }

    /**
     * 스택을 쓰지 않은 풀이
     *
     * @param prices
     * @return
     */
    public int[] solutionNoneStack(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;

        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}
