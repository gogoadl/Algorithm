package com.company;

public class Practice4 { // 문자열 정수로 변환

    public int solution(String s) {
        int answer = 0;

        answer = Integer.parseInt(s);

        return answer;
    }
    public static void main(String[] args) {
        Practice4 practice4 = new Practice4();
        practice4.solution("-1234");
    }
}
