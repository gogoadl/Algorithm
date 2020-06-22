package com.company;

public class Practice13 { // 콜라츠 추측
    public long solution(long num) {
        int answer = 0;

        while (num != 1)
        {
            if(answer >= 500)
            {
                answer = -1;
                return  answer;
            }

            if(num % 2 == 0)
            {
                num = num / 2;
                answer++;
            }
            else
            {
                num = (num * 3) + 1;
                answer++;
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        Practice13 practice13 = new Practice13();
        practice13.solution(6);
    }
}
