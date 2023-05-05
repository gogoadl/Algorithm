package com.company.programmers;

import java.util.*;

public class BridgeTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridgeQueue = new ArrayDeque<>();
        Queue<Integer> waitQueue = new ArrayDeque<>();

        for (int i: truck_weights) {
            waitQueue.add(i);
        }
        int sum = 0;
        while (!waitQueue.isEmpty()){
            answer++;
            if(bridgeQueue.size() < bridge_length){
                if(sum + waitQueue.peek() <= weight){
                    sum += waitQueue.peek();
                    bridgeQueue.add(waitQueue.poll());

                }else{
                    bridgeQueue.add(0);
                }
            }else{
                sum -= bridgeQueue.poll();
                if(sum + waitQueue.peek() < weight){
                    sum += waitQueue.peek();
                    bridgeQueue.add(waitQueue.poll());

                }else{
                    bridgeQueue.add(0);
                }
            }
        }
        bridgeQueue.size();
        return answer + bridge_length;
    }

    public static void main(String[] args) {
        BridgeTruck bridgeTruck = new BridgeTruck();
        bridgeTruck.solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10});
    }
}
