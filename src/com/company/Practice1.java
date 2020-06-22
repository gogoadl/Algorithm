package com.company;

import java.util.Stack;

public class Practice1 { // 프로그래머스 올바른 괄호

    boolean solution(String s) {
        boolean answer = false;
        char[] chars = s.toCharArray();

        Stack stack = new Stack();

        if(chars[0] == ')')
        {
            return answer;
        }

        for (char i : chars
        ) {
            if(i == '(')
            {
                stack.push(i);
            }
            else if (i == ')' && !stack.isEmpty())
            {
                stack.pop();
            }
        }
        if(stack.empty())
        {
            answer = true;
            return answer;
        }
        else
        {
            return answer;
        }
    }

    public static void main(String[] args) {
        Practice1 practice1 = new Practice1();
        practice1.solution(")()(");
    }
}
