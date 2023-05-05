package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BaekJoon2992 {
    // 1. 문자열 분리하기
    // 2. 분리한 숫자의 모든 경우의 수 뽑기
    // 3. 정렬 이후 해당 입력받은 문자열의 인덱스 검색
    // 4. 입력받은 문자열 인덱스의 다음 인덱스 문자열을 출력

    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] ints = new int[input.length()];
        int[] outputs = new int[input.length()];
        boolean visited[] = new boolean[input.length()];


        for (int i = 0; i < input.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        perm(ints, outputs, visited, 0, ints.length, ints.length);
        
        Collections.sort(arrayList);

        ArrayList arrayList1 = new ArrayList();

        for (int val: arrayList) {
            if (!arrayList1.contains(val))
                arrayList1.add(val);
        }
        int targetIndex = arrayList1.indexOf(Integer.parseInt(input)) + 1;

        if (targetIndex >= arrayList1.size())
            System.out.println(0);
        else
            System.out.println(arrayList1.get(targetIndex));

    }
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (r == depth) {
            String outputString = "";
            for (int i = 0; i < output.length; i++) {
                outputString += output[i];
            }
            arrayList.add(Integer.parseInt(outputString));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
