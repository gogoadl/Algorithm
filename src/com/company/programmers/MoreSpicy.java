package com.company.programmers;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num:scoville)
        { priorityQueue.add(num); }
        while(!priorityQueue.isEmpty())
        {
            try {
                int a = priorityQueue.poll();
                int b = priorityQueue.poll();
                priorityQueue.add(a + (b * 2));
                answer++;
                if(priorityQueue.peek() > K)
                    break;
            }catch (Exception e)
            { return -1; }
        }
        return answer;
    }

    public static void main(String[] args) {
        MoreSpicy moreSpicy = new MoreSpicy();
        moreSpicy.solution(new int[]{0,0,0,0},7);
    }
}
