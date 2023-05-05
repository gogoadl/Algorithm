package com.company.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Practice10 { // 제일 작은수 제거하기
    public int[] solution(int[] arr) {
        int[] answer;

        ArrayList<Integer> arrayList = new ArrayList();

        for (int i: arr) {
            arrayList.add(i);
        }
        if(arrayList.size() != 1)
        {
            arrayList.remove(Collections.min(arrayList));
            answer = new int[arrayList.size()];
            for(int i = 0; i < arrayList.size(); i++)
            {
                answer[i] = arrayList.get(i);
            }
        }else
            answer = new int[]{-1};

        return answer;
    }
    public static void main(String[] args) {
        Practice10 practice10 = new Practice10();
        practice10.solution(new int[]{4,3,2,1});
    }
}
