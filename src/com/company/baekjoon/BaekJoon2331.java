package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BaekJoon2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        arrayList.add(n);
        int answer = 0;
        while (true) {
            int value = arrayList.get(arrayList.size()-1);
            String[] str = String.valueOf(value).split("");
            int nextValue = 0;
            for (int i = 0; i < str.length; i++) {
                nextValue += Math.pow(Integer.parseInt(str[i]), m);
            }
            if (arrayList.contains(nextValue)) {
                answer = arrayList.indexOf(nextValue);
                break;
            }
            arrayList.add(nextValue);
        }
        System.out.println(answer);

    }
}
