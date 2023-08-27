package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BaekJoon2733 {
    public static int ptr;
    public static char[] arr;
    public static String code;
    public static StringBuilder res = new StringBuilder();
    public static Map<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            ptr = 0;
            indexMap.clear();
            arr = new char[32768];
            boolean isBreak = false;
            res.append(String.format("PROGRAM #%d:\n", i));

            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = br.readLine();
                if ("end".equals(line)) {
                    break;
                }

                if (line.contains("%")) {
                    line = line.substring(0, line.indexOf("%"));
                }
                sb.append(line);
            }
            code = sb.toString();

            Stack<Integer> stk = new Stack<>();

            for (int j = 0; j < code.length(); j++) {
                char ch = code.charAt(j);
                if (ch == '[') {
                    stk.push(j);
                } else if (ch == ']') {
                    if (stk.isEmpty()) {
                        isBreak = true;
                        break;
                    } else {
                        int idx = stk.pop();
                        indexMap.put(j, idx);
                        indexMap.put(idx, j);
                    }
                }
            }

            if (stk.isEmpty() && !isBreak) {
                for (int j = 0; j < code.length(); j++) {
                    char c = code.charAt(j);
                    if (c == '>') {
                        if (ptr == 32767) ptr = 0;
                        else ptr++;
                    } else if (c == '<') {
                        if (ptr == 0) ptr = 32767;
                        else ptr--;
                    } else if (c == '+') {
                        if (arr[ptr] == 255) arr[ptr] = 0;
                        arr[ptr]++;
                    } else if (c == '-') {
                        if (arr[ptr] == 0) arr[ptr] = 255;
                        arr[ptr]--;
                    } else if (c == '.') {
                        res.append(arr[ptr]);
                    } else if (c == '[') {
                        if (arr[ptr] == 0) {
                            j = indexMap.get(j);
                        }
                    } else if (c == ']') {
                        if (arr[ptr] != 0) {
                            j = indexMap.get(j) - 1;
                        }
                    }
                }
            } else {
                res.append("COMPILE ERROR");
            }
            res.append("\n");
        }
        System.out.println(res);
    }
}