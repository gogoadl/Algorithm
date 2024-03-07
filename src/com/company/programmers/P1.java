package com.company.programmers;

import java.nio.channels.AsynchronousFileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1 {
    static int[] current;
    static int time;
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = jobs.length;
        PriorityQueue<int[]> list = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                }
                else return o1[0]-o2[0];
            }
        });

        PriorityQueue<int[]> wait = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            list.add(jobs[i]);
        }

        while (true) {
            if (wait.isEmpty() && list.isEmpty()) break;
            // 맨 위에 있는거 꺼내기
            if (wait.isEmpty()) {
                current = list.poll();
                if (current[0] > time) {
                    time = current[0];
                }
            } else {
                current = wait.poll();
            }

            for (int i = 0; i < current[1]; i++) {
                if (!list.isEmpty() && list.peek()[0] <= time) {
                    wait.add(list.poll());
                }
                time++;
            }
            answer += time - current[0];
        }

        System.out.println(answer / count);
        return answer / count;
    }
    public static void main(String[] args) {
        P1 p1 = new P1();
//        p1.solution(new int[][] {{0,10}, {4,10}, {5,11}, {15,2}});
//        p1.solution(new int[][] {{0,3}, {10,1}});
//        p1.solution(new int[][] {{7,8}, {3,5}, {9,6}});
//        p1.solution(new int[][] {{0,3}, {5,20}, {7,4}});
        p1.solution(new int[][] {{1,4}, {7,9}, {1000,3}});
//        p1.solution(new int[][] {{0,1}, {2,2}, {2,3}});
    }
}
