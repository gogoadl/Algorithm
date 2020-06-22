package com.company;

import java.util.ArrayList;

public class Practice3 { // 문자열 더하기

    public int solution(int n) {
        int answer = 0;

        char[] chars = String.valueOf(n).toCharArray();

        for(int i = 0; i < chars.length; i++)
        {

            answer += Character.getNumericValue(chars[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Practice3 practice3 = new Practice3();
        practice3.solution(123);
    }
}
