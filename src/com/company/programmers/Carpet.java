package com.company.programmers;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1; i <= yellow; i++)
        {
            if(yellow % i == 0)
            {
                if(2 * i + (2 * yellow / i) == brown - 4)
                {
                    answer[0] = i + 2;
                    answer[1] = yellow / i + 2;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        carpet.solution(18,6);
    }
}
