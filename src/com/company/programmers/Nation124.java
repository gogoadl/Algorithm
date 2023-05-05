package com.company.programmers;

public class Nation124 {
    public String solution(int n) {
        String answer = "";
        int[] arr = new int[]{4, 1, 2};
        int a;

        while (n > 0)
        {
            a = n % 3;
            n = n / 3;
            if (a == 0 )
                n -= 1;
            answer = arr[a] + answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        Nation124 nation124 = new Nation124();
        nation124.solution(10);
    }
}
