package com.company.programmers;

public class JadenCase {
    public String solution(String s) {
        String answer = "";

        s = s.toLowerCase();

        char[] chars = s.toCharArray();
        if(Character.isLetter(chars[0]))
        {
            chars[0] = Character.toUpperCase(chars[0]);
        }
        for(int i = 1; i < chars.length; i++)
        {
            if(chars[i - 1] == ' ')
                chars[i] = Character.toUpperCase(chars[i]);
        }

        answer = String.valueOf(chars);

        return answer;
    }
}
