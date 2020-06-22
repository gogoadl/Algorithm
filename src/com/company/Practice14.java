package com.company;

public class Practice14 { // 핸드폰 번호 가리기
    public String solution(String phone_number) {
        String answer = "";

        char[] chars = phone_number.toCharArray();
        for (int i = 0; i < phone_number.length(); i++) {
            if(i >= (phone_number.length() - 4))
                answer += chars[i];
            else
            {
                answer += "*";
            }

        }

        return answer;
    }
    public static void main(String[] args) {
        Practice14 practice14 = new Practice14();
        practice14.solution("01033334444");
    }
}
