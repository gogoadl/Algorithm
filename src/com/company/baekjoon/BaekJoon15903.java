package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add((long) Integer.parseInt(st.nextToken()));
        }
        long a;
        long b;
        while(m > 0) {
            a = queue.poll();
            b = queue.poll();
            queue.add(a+b);
            queue.add(a+b);
            m--;
        }
        long sum = 0;
        while(!queue.isEmpty()) {
            sum += queue.poll();
        }
        System.out.println(sum);
    }
}