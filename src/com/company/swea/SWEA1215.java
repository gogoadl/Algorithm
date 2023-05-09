package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1215 {
    public static boolean isPalindrome(String str) {
        StringBuilder reverse = new StringBuilder();
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString().equals(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = 10;

        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;
            int palindromeLength = Integer.parseInt(br.readLine());
            int arrayLength = 8;
            String[][] array = new String[arrayLength][arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                array[j] = br.readLine().split("");
            }
            for (int j = 0; j < arrayLength; j++) {

                for (int k = 0; k <= arrayLength - palindromeLength; k++) {
                    String yStr = "";
                    String xStr = "";
                    for (int l = k; l < palindromeLength+k; l++) {
                        xStr += array[j][l];
                    }
                    if (isPalindrome(xStr)) {
                        answer++;
                    }
                    for (int l = k; l < palindromeLength+k; l++) {
                        yStr += array[l][j];
                    }
                    if (isPalindrome(yStr)) {
                        answer++;
                    }
                }
            }

            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
