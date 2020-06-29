package com.company;

import java.util.ArrayList;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = brown + yellow;

        for(int i = 2; i < sum; i++)
        {
            if(sum % i == 0)
            {
                arrayList.add(i);
            }
        }
        int temp = (arrayList.size() / 2);
        if(arrayList.size() % 2 == 0)
        {
            answer[0] = arrayList.get(temp);
            answer[1] = arrayList.get(temp - 1);
        }else
        {
            answer[0] = arrayList.get(temp);
            answer[1] = arrayList.get(temp);
        }
        return answer;
    }
    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        carpet.solution(18,6);
    }
}
