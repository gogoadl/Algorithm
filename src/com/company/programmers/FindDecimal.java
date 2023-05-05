package com.company.programmers;

import java.util.ArrayList;

public class FindDecimal {
    ArrayList<String> arrayList = new ArrayList<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] booleans = new boolean[numbers.length()];
        ArrayList<String> answerList = new ArrayList<>();
        char[] chars = numbers.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String s = "";
            dfs(i, booleans, s, chars);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).startsWith("0")) {
                arrayList.remove(i);
                i = -1;
            }
            else if (!answerList.contains(arrayList.get(i))) {
                answerList.add(arrayList.get(i));
            }
        }
        for (int i = 0; i < answerList.size(); i++) {
            int n = Integer.parseInt(answerList.get(i));

            for(int j = 2; j <= n; j++) {
                if(j == n) {
                    answer++;
                }
                if ( n%j == 0) {
                    break;
                }

            }
        }
        System.out.println(answer);
        return answer;
    }
    public void dfs(int i, boolean[] booleans, String s, char[] chars) {
        booleans[i] = true;
        s = s + chars[i];
        arrayList.add(s);
        for (int j = 0; j < booleans.length; j++) {
            if (!booleans[j]) {
                dfs(j, booleans, s, chars);
            }

        }
        booleans[i] = false;
    }

    public static void main(String[] args) {
        FindDecimal findDecimal = new FindDecimal();
        findDecimal.solution("17");
        System.out.println(findDecimal.arrayList);

    }

}
