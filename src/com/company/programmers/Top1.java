package com.company.programmers;


import java.util.Stack;

public class Top1 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            stack.push(heights[i]);
        }

        while(stack.empty())
        {
            for(int j = 0; j < stack.size(); j++)
            {
                if(stack.pop() < stack.get(j))
                {
                    answer[j] = j;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Top1 top = new Top1();
        top.solution(new int[]{6,9,5,7,4});
    }
}
