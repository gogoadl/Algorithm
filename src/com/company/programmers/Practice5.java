package com.company.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice5 { // 나누어 떨어지는 숫자 배열
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i: arr) {
            if(i % divisor == 0)
                arrayList.add(i);
        }
        if(arrayList.isEmpty())
        {
            answer = new int[]{-1};
            return answer;
        }
        answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        Practice5 practice5 = new Practice5();
        practice5.solution(new int[]{3,2,6},10);
    }
}
