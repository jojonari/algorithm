package dev.jojonari.algorithm.programmers.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 * stream().allMatch()/stream().anyMatch()/stream().noneMatch() : 모두/적어도 하나/0개가 조건에 일치하면 true를 반환
 * Queue.offer() : 순차적으로 보관
 * Queue.poll() : 가장 먼저 보관한 값 꺼내고 반환
 * Queue.peek() : 가장 먼저 보관한 값 단순 참조, 꺼내지 않음
 */
public class Print {
    private Queue<Document> queue;
    private int answer;

    public int solution(int[] priorities, int location) {
        queue = new LinkedList<>();
        //전체를 Queue에 담음
        for (int i = 0; i < priorities.length; i++) {
            //필요한 값은 index와 문서의 우선순위 이므로 객체를 만들어서 보관
            queue.offer(new Document(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            Document head = queue.poll();
            if (isPrintable(head)) {
                //print 실행
                answer++;
                if (head.index == location) break;
            } else {
                //큰값이 있으면 다시 큐의 제일 마지막에 보관
                queue.offer(head);
            }
        }

        return answer;
    }

    /**
     * 첫번째 값과 나머지를 비교해서 큰값이 있는지 없는지 체크 : 큰값이 하나도 없을때 true
     * @param head
     * @return
     */
    private boolean isPrintable(Document head) {
        return queue.stream().noneMatch(document -> document.priority > head.priority);
    }
}

class Document {
    int priority;
    int index;

    public Document(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}
