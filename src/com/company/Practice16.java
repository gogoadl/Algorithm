package com.company;

public class Practice16 { // 피보나치 수
    public int solution(int n) {
        int answer = 0;

        if( n == 1 || n == 2)
        {
            answer = 1;
            return answer;
        }
        int n1 = 1, n2 = 1, sum = 0;
        for(int i = 3; i <= n; i++)
        {
            sum = n1 + n2;
            sum %= 1234567;
            n1 = n2;
            n2 = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        Practice16 practice16 = new Practice16();
        practice16.solution(6);
    }
}
