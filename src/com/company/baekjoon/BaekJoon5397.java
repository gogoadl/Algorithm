package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCaseCount = Integer.parseInt(br.readLine());
        Stack<Character> lStack = new Stack<Character>();
        Stack<Character> rStack = new Stack<Character>();

        for (int i = 0; i < testCaseCount; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '<') {
                    if (!rStack.isEmpty())
                        lStack.push(rStack.pop());
                } else if (c == '>') {
                    if (!lStack.isEmpty())
                        rStack.push(lStack.pop());
                } else if  (c == '-') {
                    if (!rStack.isEmpty())
                        rStack.pop();
                } else {
                    rStack.push(c);
                }
            }
            while (!lStack.isEmpty()) {
                rStack.push(lStack.pop());
            }
            for (int j = 0; j < rStack.size(); j++) {
                sb.append(rStack.elementAt(j));
            }

            System.out.println(sb);
            sb.setLength(0);
            lStack.clear();
            rStack.clear();
        }
    }
}
