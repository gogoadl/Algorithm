package com.company;

import java.util.*;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());
        for (int i : priorities) {
            priorityQueue.add(i);
        }
        while (!priorityQueue.isEmpty())
        {
            for (int i = 0; i < priorities.length ; i++) {
                if(priorityQueue.peek() == priorities[i])
                {
                    priorityQueue.poll();
                    answer++;
                    if(location == i)
                    {
                        priorityQueue.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.solution(new int[]{2,1,3,2},2);
    }
}
