package com.company;

import java.util.ArrayList;

public class TraningSuit {
    public int solution(int n, int[] lost, int[] reserve) {

        int answer = n - lost.length;
        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();
        for(int i = 0; i < lost.length; i++)
        {
            lostList.add(lost[i]);
        }

        for(int j = 0; j < reserve.length; j++)
        {
            reserveList.add(reserve[j]);
        }
        for(int k = 0; k < lost.length; k++)
        {
            if(reserveList.contains(lostList.get(k) - 1) || reserveList.contains(lostList.get(k) + 1) )
            {
                lostList.remove(lostList.get(k));
                answer++;
            }

        }


        return answer;
    }
    public static void main(String[] args)
    {
        TraningSuit traningSuit = new TraningSuit();
        traningSuit.solution(5, new int[]{2,4}, new int[]{1,3,5});
    }
}
