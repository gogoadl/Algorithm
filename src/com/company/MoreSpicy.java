package com.company;


import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num:scoville)
        { priorityQueue.add(num); }

        while(true)
        {

            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            priorityQueue.add(a + (b * 2));
            answer++;
            if(priorityQueue.isEmpty())
                return -1;
                break;
        }
//        for (int i = 0; i <arrayList.size() ; i++) {
//            System.out.println(arrayList.get(i));
//        }
        return answer;
    }

    public static void main(String[] args) {
        MoreSpicy moreSpicy = new MoreSpicy();
        moreSpicy.solution(new int[]{1,2,3,9,10,12},7);
    }
}
