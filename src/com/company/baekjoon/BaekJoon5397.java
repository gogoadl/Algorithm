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
        Stack<Character> temp = new Stack<>();
        Stack<Character> result = new Stack<>();
        for (int i = 0; i < testCaseCount; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '>') {
                    if (!temp.isEmpty()) {
                        result.push(temp.pop());
                    }
                } else if (c == '<') {
                    if (!result.isEmpty()) {
                        temp.push(result.pop());
                    }
                } else if (c == '-') {
                    if (!result.isEmpty()) {
                        result.pop();
                    }
                } else {
                    result.push(c);
                }
            }
            while (!temp.isEmpty()) {
                result.push(temp.pop());
            }
            for (int j = 0; j < result.size(); j++) {
                sb.append(result.elementAt(j));
            }
            System.out.println(sb);
            sb.setLength(0);
            temp.clear();
            result.clear();
        }

    }
}
