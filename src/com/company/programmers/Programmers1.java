package com.company.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
연속된 부분 수열의 합
 */
public class Programmers1 {

    public int[] solution(int[] sequence, int k) {
        int[] answer;

        ArrayList<int []> arrayList = new ArrayList<int[]>();

        for (int i = 0; i < sequence.length; i++) {
            int sum = 0;
            int start = i;
            int end;
            for (int j = i; j < sequence.length; j++) {
                sum+= sequence[j];
                if (sum == k) {
                    end = j;
                    arrayList.add(new int[] {start, end});
                }else if (sum > k)
                    break;
            }

        }
        arrayList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        });

        //System.out.println(arrayList);
        answer = arrayList.get(0);

        return answer;
    }

    public static void main(String[] args) {
        Programmers1 programmers1 = new Programmers1();
        int[] sequence = new int[]{1,1,1,2,3,4,5};
        int k = 5;
        System.out.println(programmers1.solution(sequence, k).toString());
    }
}
