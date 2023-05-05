package com.company.programmers;


public class Top {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i = 0; i < heights.length; i++)
        {
            for (int j = i; j >= 0; j--)
            {
                if(heights[i] < heights[j])
                {
                    answer[i] = j+1;
                    break;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Top top = new Top();
        top.solution(new int[]{3,9,9,3,5,7,2});
    }
}
