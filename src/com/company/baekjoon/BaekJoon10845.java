package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BaekJoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                Integer value = Integer.parseInt(st.nextToken());
                queue.add(value);
            } else if (command.equals("front")) {
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.peekFirst()).append("\n");
            } else if (command.equals("back")) {
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.peekLast()).append("\n");
            } else if (command.equals("empty")) {
                int val = queue.isEmpty() ? 1 : 0;
                sb.append(val).append("\n");
            } else if (command.equals("pop")) {
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
        }
        System.out.println(sb);
    }
}