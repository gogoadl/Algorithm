package com.company;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;

        char[] chars = name.toCharArray();

        for(int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if(c == 'A') {
                continue;
            }

            if(c <= 'N')
                answer += c - 'A';
            else
                answer += 'Z' - c + 1;

            answer++;
            System.out.println(answer);
        }


        return answer - 1;
    }

    public static void main(String[] args) {
        JoyStick joyStick = new JoyStick();

        System.out.println(joyStick.solution("JAN"));


    }


}
