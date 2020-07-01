package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

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
        ArrayList<String> arrayList = new ArrayList<>();


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
                arrayList.add(s[2]);
                break;
            }

        }
            if(arrayList.size() == 0)
            {
                return answer;
            }else
            {
                Collections.sort(arrayList);
                answer = arrayList.get(arrayList.size() - 1);
            }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("CC",new String[]{"04:00,04:02,ZERO,B#CC", "15:00,15:02,FIRST,B#CC", "04:04,04:06,SECOND,B#CC", "04:08,04:10,THIRD,B#CC"});
    }
}
