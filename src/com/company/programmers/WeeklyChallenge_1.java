package com.company.programmers;

public class WeeklyChallenge_1 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        int cnt = 0;
        for(int i = 1; i <= count; i++)
            cnt += i;
        money = price * cnt - money;
        answer = money > 0 ? 0 : money*-1;
        return answer;
    }
    public static void main(String[] args) {
        WeeklyChallenge_1 weeklyChallenge_1 = new WeeklyChallenge_1();
        weeklyChallenge_1.solution(3, 20, 4);
    }
}
