package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BaekJoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push_front")) {
                Integer value = Integer.parseInt(st.nextToken());
                queue.addFirst(value);
            } else if (command.equals("push_back")) {
                Integer value = Integer.parseInt(st.nextToken());
                queue.addLast(value);
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
            } else if (command.equals("pop_front")) {
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.pollFirst()).append("\n");
            } else if (command.equals("pop_back")) {
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.pollLast()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
        }
        System.out.println(sb);
    }
}

