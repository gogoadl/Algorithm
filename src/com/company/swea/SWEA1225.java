package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = 10;
        for (int i = 1; i <= testCaseCount; i++) {
            int testCaseNumber = Integer.parseInt(br.readLine());

            String[] str = br.readLine().split(" ");
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < str.length; j++) {
                queue.add(Integer.parseInt(str[j]));
            }
            boolean isBreak = true;
            while (isBreak) {
                for (int j = 1; j <= 5; j++) {
                    int value = queue.poll() - j;
                    if (value <= 0) {
                        queue.offer(0);
                        isBreak = false;
                        break;
                    } else {
                        queue.offer(value);
                    }
                }
            }
            sb.append(String.format("#%d ",i));
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                sb.append(queue.poll() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
