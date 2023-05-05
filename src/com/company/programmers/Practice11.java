package com.company.programmers;

public class Practice11 { // 정수 제곱근 판별
    public long solution(long n) {
        long answer = 0;

        double target = Math.sqrt(n);

        long l = (long)target;

        if(target % 1 == 0)
        {
            answer = (l+1)*(l+1);
        }else
            answer = -1;


        return answer;
    }
    public static void main(String[] args) {
        Practice11 practice11 = new Practice11();
        practice11.solution(121);
    }
}
