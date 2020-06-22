package com.company;

public class Practice8 { // 문자열 다루기 기본
    public boolean solution(String s) {
        boolean answer = false;


        if(s.length() == 4 || s.length()  == 6) {
            try
            {
                Integer.parseInt(s);
                answer = true;
            }catch (Exception e)
            {
                answer = false;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Practice8 practice8 = new Practice8();
        practice8.solution("a234");
    }
}
