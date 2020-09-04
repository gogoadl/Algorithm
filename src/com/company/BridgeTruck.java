package com.company;

import java.util.*;

public class BridgeTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList();
        ArrayList<Integer> queue1 = new ArrayList<>();

        for (int i: truck_weights) {
            queue1.add(i);
        }
        int sum = 0;
        while (!queue.isEmpty() || !queue1.isEmpty()){
            answer++;
            if(queue.size() < bridge_length){

                queue.offer(queue1.get(0));

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        BridgeTruck bridgeTruck = new BridgeTruck();
        bridgeTruck.solution(2,10,new int[]{7,4,5,6});
    }
}
