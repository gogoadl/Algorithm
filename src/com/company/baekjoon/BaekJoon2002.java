package com.company.baekjoon;

import java.io.*;
import java.util.ArrayList;

public class BaekJoon2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> inputList = new ArrayList<>();
        ArrayList<String> outputList = new ArrayList<>();
        int carCount = Integer.parseInt(br.readLine());

        int overtakeCount = 0;

        for (int i = 0; i < carCount*2; i++) {
            String str = br.readLine();
            if (i >= carCount)
                outputList.add(str);
            else
                inputList.add(str);
        }
        for (int j = 0; j < carCount; j++) {
            String s = inputList.get(j);
            int outputIndex = outputList.indexOf(s);
            if (j > outputIndex) {
                overtakeCount++;
            }
        }
        System.out.println(overtakeCount);
    }
}
