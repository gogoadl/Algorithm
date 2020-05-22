package com.company;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for(int i = 0; i < (citations.length / 2) + 1; i++)
        {
            int h = citations.length - i;
            if(citations[i] >= h)
            {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        hIndex.solution(new int[]{5,5,5,5,5});
    }
}
