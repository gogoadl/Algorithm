package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BaekJoon2733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            char[] array = new char[32768];
            int index = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            StringBuilder command = new StringBuilder();
            StringBuilder result = new StringBuilder();
            result.append(String.format("Program #%d:\n", i));
            while (true) {
                String input = br.readLine();
                input = input.replaceAll(" ",""); // 공백제거

                if (input.equals("end")) break;

                if (input.contains("%")) {
                    command.append(input, 0, input.indexOf("%"));
                } else
                    command.append(input);
            }
            String s = command.toString();
            for (int j = 0; j < s.length(); j++) { // 괄호가 있다면 스택에 추가
                if (s.charAt(j) == '[') {
                    stack.add(j);
                } else if (s.charAt(j) == ']') {
                    if (stack.isEmpty()) {// 스택이 비었다면 컴파일 에러 (짝 안맞음)
                        result.append("COMPILE ERROR");
                        break;
                    } else {
                        int left = stack.pop();
                        map.put(left, j);
                        map.put(j, left);
                    }
                }
            }
            if (!stack.isEmpty()) { // 스택이 비어있지 않으면 컴파일 에러 (짝 안맞음)
                result.append("COMPILE ERROR");
                sb.append(result).append("\n");
                continue;
            }
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '>') {
                    if (index == 32767) index = 0;
                    else index++;
                } else if (chars[j] == '<') {
                    if (index == 0) index = 32767;
                    else index--;
                } else if (chars[j] == '+') {
                    if (array[index] == 255) array[index] = 0;
                    array[index]++;
                } else if (chars[j] == '-') {
                    if (array[index] == 0) array[index] = 255;
                    array[index]--;
                } else if (chars[j] == '.') {
                    result.append(array[index]);
                } else if (chars[j] == '[') {
                    if (array[index] == 0) {
                        j = map.get(j);
                        j--;
                    }
                } else if (chars[j] == ']') {
                    if (array[index] != 0) {
                        j = map.get(j);
                        j--;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}