package com.company.programmers;

import java.util.ArrayList;

public class Practice2 { // 같은 숫자는 싫어

    public int[] solution(int []arr) {
        int[] answer;

        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(arr[0]);
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != arrayList.get(arrayList.size() - 1))
            {
                arrayList.add(arr[i]);
            }
        }
        answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        Practice2 practice2 = new Practice2();
        practice2.solution(new int[]{1,1,3,3,0,1,1});
    }
}
