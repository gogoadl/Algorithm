package com.company.programmers;

public class Practice15 { // 최대공약수와 최소공배수
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] =  gcd(n,m);
        answer[1] = lcm(n,m,answer[0]);
        return answer;
    }
    public int gcd(int a, int b)
    {
        while (b != 0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
    public int lcm(int a, int b, int gcd)
    {
        return (a*b)/gcd;
    }
    public static void main(String[] args) {
        Practice15 practice15 = new Practice15();
        practice15.solution(3,12);
    }
}
