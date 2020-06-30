package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Solution {
    public String replaceStr(String m)
    {
        m = m.replace("C#","H");
        m = m.replace("D#","I");
        m = m.replace("F#","J");
        m = m.replace("G#","K");
        m = m.replace("A#","L");
        return m;
    }
    public String solution(String m, String[] musicinfos) { // 카카오 악보
        String answer = "(None)";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");

        for (int i = 0; i < musicinfos.length; i++) {
            long diff;
            long sec = 0;
            String str = "";

            String[] s = musicinfos[i].split(",");
            String m1 = replaceStr(m);
            String m2 = replaceStr(s[3]);
            try {
                Date d1 = simpleDateFormat.parse(s[1]);

                Date d2 = simpleDateFormat.parse(s[0]);

                diff = d1.getTime() - d2.getTime();
                sec = diff / 60000;

            } catch (ParseException e) {
                e.printStackTrace();
            }
            int k = 0;
            for (int j = 0; j < sec; j++) {
                if (k == m2.length())
                    k = 0;
                str += m2.charAt(k);
                k++;
            }
            if (str.contains(m1)) {

                answer = s[2];
                break;
            }

        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("CC#BCC#BCC#BCC#B",new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"});
    }
}
