package com.company;

public class Practice17 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int i = 1;
        int j = 0;
        long xx = x;
        while (i <= n)
        {
            answer[j] = xx * i;
            j++;
            i += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Practice17 practice17 = new Practice17();
        practice17.solution(10000000,1000);
    }
}
