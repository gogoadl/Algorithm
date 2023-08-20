package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon6209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        arrayList.add(d);
        Collections.sort(arrayList);
        int start = 0;
        int end = d;
        int mid;

        int now = 0;
        int sum;
        int ret = 0;

        while (start<=end) {
            mid = (start + end) / 2;
            sum = 0;
            now = 0;
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) - arrayList.get(now) < mid) {
                    sum++;
                }
                else
                    now = i;
            }

            if (sum > m) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ret = mid;
            }
        }
        System.out.println(ret);
    }

}
