package com.company;

public class Practice9 {
    public int[] solution(long n) {
        int[] answer;

        String s = String.valueOf(n);

        char[] chars = s.toCharArray();
        answer = new int[chars.length];
        for(int i = chars.length - 1; i >= 0; i--)
        {
            answer[(chars.length - 1) - i] = Character.getNumericValue(chars[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        Practice9 practice9 = new Practice9();
        practice9.solution(12345);
    }
}
