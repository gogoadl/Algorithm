package com.company;

public class Practice24 { // 서울에서 김서방 찾기
    public String solution(String[] seoul) {
        String answer = "김서방은 ";

        for(int i = 0; i < seoul.length; i++)
        {
            if(seoul[i].equals("Kim"))
            {
                answer += i + "에 있다";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice24 practice24 = new Practice24();
        practice24.solution(new String[]{"Jane","Kim"});


    }

}
