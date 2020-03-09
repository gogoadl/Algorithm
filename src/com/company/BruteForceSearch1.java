package com.company;


import java.util.ArrayList;

public class BruteForceSearch1 {
    public int[] solution(int[] answers) {


        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};

        int[] cnt = new int[3];

        for(int i = 0; i < answers.length; i++)
        {
            if(answers[i] == arr1[i%5])
            {
                cnt[0]++;
            }
            if(answers[i] == arr2[i%8])
            {
                cnt[1]++;
            }
            if(answers[i] == arr3[i%10])
            {
                cnt[2]++;
            }
        }
        int max = Math.max(Math.max(cnt[0], cnt[1]),cnt[2]); // max값 구하기
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(max==cnt[0]) list.add(1);
        if(max==cnt[1]) list.add(2);
        if(max==cnt[2]) list.add(3);

        int[] answer = new int[list.size()];

        for(int i =0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        BruteForceSearch1 firstSearch1 = new BruteForceSearch1();
        int[] arr = firstSearch1.solution(new int[]{1,2,3,4,5});
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }

    }
}