package com.company;

public class Practice25 { // 문자열 내 p와 y의 개수

    boolean solution(String s) {
        boolean answer = true;
        int a = 0;
        int b = 0;
        s = s.toUpperCase();
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++)
        { 
            if(chars[i] == 'P')
                a++;
            if(chars[i] == 'Y')
                b++;
        }
        if(a == b)
            answer = true;
        else
            answer = false;

        return answer;
    }

    public static void main(String[] args) {
        Practice25 practice25 = new Practice25();
        practice25.solution("pPooyY");
    }

}
