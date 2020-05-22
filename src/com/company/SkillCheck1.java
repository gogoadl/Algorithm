package com.company;

public class SkillCheck1 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            for(int j = i; j < n; j++)
            {
                sum += j;
                if(sum == n)
                {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SkillCheck1 s = new SkillCheck1();
        System.out.println(s.solution(15));
    }
}
