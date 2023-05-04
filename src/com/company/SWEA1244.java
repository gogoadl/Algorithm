package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA1244 {
    static String swap(String[] str, int from, int to) {
        String[] tempStr = str.clone();
        String temp;
        temp = tempStr[from];
        tempStr[from] = tempStr[to];
        tempStr[to] = String.valueOf(temp);

        return String.join("",tempStr);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount ; i++) {
            String[] input = br.readLine().split(" ");
            int swapCount = Integer.parseInt(input[1]);
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<Integer> newList = new ArrayList<>();
            arrayList.add(Integer.parseInt(input[0]));
            while (swapCount != 0) {
                int size = arrayList.size();
                for (int j = 0; j < size; j++) {
                    Integer a = arrayList.get(j);
                    String[] numbers = String.valueOf(a).split("");
                    for (int k = 0; k < numbers.length; k++) {
                        for (int l = k + 1; l < numbers.length; l++) {
                            int value = Integer.parseInt(swap(numbers, k, l));
                            if (!newList.contains(value))
                                newList.add(value);
                        }
                    }

                }
                arrayList.clear();
                arrayList.addAll(newList);
                newList.clear();
                swapCount--;
            }
            Collections.sort(arrayList);
            int val = arrayList.get(arrayList.size()-1);
            sb.append(String.format("#%d %d\n", i, val));
        }
        System.out.println(sb);
    }
}