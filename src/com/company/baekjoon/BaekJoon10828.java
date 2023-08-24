package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                Integer value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if (command.equals("top")) {
                if (stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.peek()).append("\n");
            } else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                int val = stack.empty() ? 1 : 0;
                sb.append(val).append("\n");
            } else if (command.equals("pop")) {
                if (stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.pop()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
