package com.company.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Practice21 { // 가장 긴 팰린드롬

    public int solution(String s)
    {
        int answer = 1;
        ArrayList<Integer> arrayList = new ArrayList();
        char[] chars = s.toCharArray();
        for(int i = 1; i < chars.length - 1; i++)
        {
            if(chars[i-1] == chars[i+1] )
            {
                int j = 1;
                while (true)
                {
                    if(answer == chars.length)
                        break;
                    if(chars[i - j] == chars[i + j])
                    {
                        answer += 2;
                        if(chars[i - j] == chars[0] || chars[i + j] == chars[chars.length - 1])
                            break;
                    }
                    else
                        break;
                    j++;
                }
            }
            arrayList.add(answer);
        }
        answer = Collections.max(arrayList);

        return answer;
    }

    public static void main(String[] args) {
        Practice21 practice21 = new Practice21();
        practice21.solution("abcdcba");
    }
}
