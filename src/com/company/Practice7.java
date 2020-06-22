package com.company;

import java.util.Arrays;

public class Practice7 { // 문자열 내림차순으로 배치하기
    public String solution(String s) {
        String answer = "";

        char[] chars = s.toCharArray();

        Arrays.sort(chars);
        for (int i = chars.length - 1; i >= 0 ; i--) {
            answer += chars[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice7 practice7 = new Practice7();
        practice7.solution("ZBcdefg");
    }
}
