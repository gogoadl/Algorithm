package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BaekJoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (!arrayList.contains(s))
                arrayList.add(s);
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
