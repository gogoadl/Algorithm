package com.company.programmers;

import java.util.Calendar;

public class Year2016 {
    public String solution(int a, int b) {
        String answer = "";

        Calendar c = Calendar.getInstance();
        c.set(2016,a-1,b);
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        switch (c.get(Calendar.DAY_OF_WEEK))
        {
            case 1 :
                answer = "SUN";
                break;
            case 2 :
                answer = "MON";
                break;
            case 3 :
                answer = "TUE";
                break;
            case 4 :
                answer = "WED";
                break;
            case 5 :
                answer = "THU";
                break;
            case 6 :
                answer = "FRI";
                break;
            case 7 :
                answer = "SAT";
                break;
        }
        return answer;
    }
    public static void main(String[] args) {
        Year2016 year2016 = new Year2016();
        year2016.solution(5,24);
    }
}
