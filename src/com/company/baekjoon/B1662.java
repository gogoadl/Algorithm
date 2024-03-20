package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1662 {
    static String sb = "";
    static Stack<Character> stack = new Stack<>();
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = br.readLine();

        System.out.println(process(0));


    }
    public static int process(int start) {
        int len = 0;
        for (int i = start; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.add(sb.charAt(i));
                len += (sb.charAt(i-1)-48) * process(i+1)-1; // 여는 괄호 바로 앞 숫자 * 괄호 안 숫자 길이
                i = idx;
            } else if (sb.charAt(i) == ')'){
                while (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                    idx = i;
                    return len;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
