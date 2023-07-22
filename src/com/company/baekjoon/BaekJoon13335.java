package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]); // 트럭 갯수
        int w = Integer.parseInt(inputs[1]); // 다리 길이
        int L = Integer.parseInt(inputs[2]); // 다리 하중

        String[] trucks = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList();
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(trucks[i]));
        }
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        int answer = 0;
        int sum = 0;
        while (!bridge.isEmpty()) {
            sum -= bridge.poll();
            if (!queue.isEmpty()) {
                if (sum + queue.peek() <= L) {
                    int truck = queue.poll();
                    sum += truck;
                    bridge.offer(truck);
                } else
                    bridge.offer(0);
            }
            answer++;
        }
        System.out.println(answer);
    }
}
