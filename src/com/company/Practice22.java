package com.company;

public class Practice22 { // 숫자의 표현
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++)
            {
                sum += j;
                if(sum == n)
                {
                    answer++;
                    break;
                }else if (sum > n)
                    break;
            }

        }
        return answer + 1;
    }

    public static void main(String[] args) {
        Practice22 practice22 = new Practice22();
        practice22.solution(15);
    }
}
