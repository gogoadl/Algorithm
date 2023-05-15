package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = 10;

        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;
            int testCaseNumber = Integer.parseInt(br.readLine());
            int arrayLength = 100;
            String[][] array = new String[arrayLength][arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                array[j] = br.readLine().split("");
            }
            StringBuilder yStr = new StringBuilder();
            StringBuilder xStr = new StringBuilder();
            for (int j = 0; j < arrayLength; j++) {
                for (int k = 0; k < arrayLength; k++) {
                    xStr.append(array[j][k]);
                    yStr.append(array[k][j]);
                }
                int max = 1;
                String xString = xStr.toString();
                String yString = yStr.toString();
                boolean[][] xPalindrome = new boolean[xString.length()][xString.length()];
                boolean[][] yPalindrome = new boolean[yString.length()][yString.length()];
                for (int k = 0; k < xString.length(); k++) {
                    xPalindrome[k][k] = true;
                }
                for (int k = 0; k < xString.length()-1; k++) {
                    if (xString.charAt(k) == xString.charAt(k+1)) {
                        xPalindrome[k][k+1] = true;
                        max = 2;
                    }
                }
                for (int cnt = 3; cnt < xString.length(); cnt++) {
                    for (int start = 0; start <= xString.length() - cnt; start++) {
                        int end = start + cnt - 1;
                        if(xPalindrome[start + 1][end - 1] && xString.charAt(start) == xString.charAt(end)) {
                            xPalindrome[start][end] = true;
                            max = cnt;
                        }
                    }
                }
                if (answer < max)
                    answer = max;

                for (int k = 0; k < yString.length(); k++) {
                    yPalindrome[k][k] = true;
                }
                for (int k = 0; k < yString.length()-1; k++) {
                    if (yString.charAt(k) == yString.charAt(k+1)) {
                        yPalindrome[k][k+1] = true;
                        max = 2;
                    }
                }
                for (int cnt = 3; cnt < yString.length(); cnt++) {
                    for (int start = 0; start <= yString.length() - cnt; start++) {
                        int end = start + cnt - 1;
                        if(yPalindrome[start + 1][end - 1] && yString.charAt(start) == yString.charAt(end)) {
                            yPalindrome[start][end] = true;
                            max = cnt;
                        }
                    }
                }
                if (answer < max)
                    answer = max;

                xStr.setLength(0);
                yStr.setLength(0);
            }
            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
