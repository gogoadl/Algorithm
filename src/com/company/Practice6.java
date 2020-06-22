package com.company;

public class Practice6 { // 수바수박수박
    public String solution(int n) {
        String answer = "";

        for(int i = 1; i <= n; i++)
        {
            if(i % 2 == 1)
            {
                answer += "수";
            }
            else
                answer += "박";
        }

        return answer;
    }
    public static void main(String[] args) {
        Practice6 practice6 = new Practice6();
        practice6.solution(3);
    }
}
