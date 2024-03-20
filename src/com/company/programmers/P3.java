package com.company.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class P3 {

    static HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> arr = new ArrayList<>();
        String[] answer = {};

        for (int i = 0; i < course.length; i++) {
            map.clear();
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < orders.length; j++) {
                if (course[i] <= orders[j].length()) {
                    String s = orders[j];
                    String res = "";
                    combi(s, res, 0, 0, course[i]);
                }
            }
            for(Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }
            for(Entry<String,Integer> entry : map.entrySet()){
                if(max >=2 && entry.getValue() == max)
                    arr.add(entry.getKey());
            }
        }
        Collections.sort(arr);

        return arr.toArray(answer);
    }

    public static void combi(String origin, String result, int idx, int cnt, int n) {
        if (cnt == n) {
            map.put(result, map.getOrDefault(result, 0) + 1);
            return;
        }
        for (int i = idx; i < origin.length(); i++) {
                result += origin.charAt(i);
                combi(origin, result, i+1, cnt+1, n);
                result = result.substring(0, result.length()-1);
            }
    }
    public static void main(String[] args) {
        P3 p3 = new P3();
        p3.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4});

    }
}
