package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
첫번째 방법

String 배열 타입으로 문자 입력 후 리스트에 추가 및 중복 발견 시 제거하고 카운트를 늘리고 출력 하는 방식
매우 비효율적으로 풀었으며 입력 방법이 잘못됨 (String 배열)

두번째 방법

입력 방법만을 String 배열에서 InputStreamReader를 통해 입력 받음.
시간 초과로 실패.

세번째 방법

시간 단축을 위해 HashMap 사용

 */
public class BaekJoon4358 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = 0;
        String str = br.readLine();
        while (true) {
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
            str = br.readLine();
            length++;
            if (str == null || str.length() == 0)
                break;
        }

        String[] keys = hashMap.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        for(String key : keys) {
            int count = hashMap.get(key);

            System.out.println(String.format("%s %.4f", key, (double) count / length * 100));
        }
    }
}
