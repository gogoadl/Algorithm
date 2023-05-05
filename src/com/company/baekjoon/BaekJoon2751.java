package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class BaekJoon2751 {

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> set = new LinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String count = br.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(count); i++) {
            int value = Integer.parseInt(br.readLine());
            set.add(value);
        }
        Collections.sort(set);
        for (int value: set) {
            stringBuilder.append(value + "\n");
        }
        System.out.println(stringBuilder);
    }
}
