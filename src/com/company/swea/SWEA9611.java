package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SWEA9611 {
    // 1. 질문을 읽은 후 마지막 인덱스가 YES일 경우 YES 리스트에 저장.
    // 2. 질문을 읽은 후 마지막 인덱스가 NO일 경우 NO 리스트에 저장.
    // 3. 질문을 모두 읽고나서 YES 리스트에서 갯수가 가장 많은 하나를 리턴 (숫자를 오직 하나만 리턴함.)
    // 4. YES만 있거나, NO만 존재하는 경우를 생각할 필요는 없지 않나?
    // (> 명진이가 생각한 숫자는 언제나 유일하게 결정됨이 보장되는 경우만 입력으로 주어진다.)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        int questionNumberCount = 4;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            HashSet<String> yesList = new HashSet<>();
            HashSet<String> noList = new HashSet<>();
            int questionCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < questionCount; j++) {
                String[] arr = br.readLine().split(" ");
                String isAnswer = arr[4];
                if (isAnswer.equals("YES")) {
                    for (int k = 0; k < questionNumberCount; k++) {
                        yesList.add(arr[k]);
                    }
                } else {
                    for (int k = 0; k < questionNumberCount; k++) {
                        noList.add(arr[k]);
                    }
                }
            }
            Iterator iter = noList.iterator();
            while (iter.hasNext()) {
                String value = iter.next().toString();
                yesList.remove(value);
            }

            Iterator iter2 = yesList.iterator();
            String value = iter2.next().toString();

            sb.append(String.format("#%d %s\n", i, value));

            yesList.clear();
            noList.clear();
        }
        System.out.println(sb.toString());

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testCaseCount = Integer.parseInt(br.readLine());
//
//        int questionNumberCount = 4;
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i <= testCaseCount; i++) {
//            HashMap<String, Integer> yesList = new HashMap<>();
//            HashSet<String> noList = new HashSet<>();
//            int questionCount = Integer.parseInt(br.readLine());
//            for (int j = 0; j < questionCount; j++) {
//                String[] arr = br.readLine().split(" ");
//                String isAnswer = arr[4];
//                if (isAnswer.equals("YES")) {
//                    for (int k = 0; k < questionNumberCount; k++) {
//                        yesList.put(arr[k], yesList.getOrDefault(arr[k], 0) + 1);
//                    }
//                } else {
//                    for (int k = 0; k < questionNumberCount; k++) {
//                        noList.add(arr[k]);
//                    }
//                }
//            }
//            Iterator iter = noList.iterator();
//            while (iter.hasNext()) {
//                String value = iter.next().toString();
//                yesList.remove(value);
//            }
//
//            sb.append(String.format("#%d %s\n", i, yesList.));
//
//            yesList.clear();
//            noList.clear();
//        }
//        System.out.println(sb.toString());
    }
}
