package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1240 {
    // 암호문 시작 위치 찾기. 암호문의 마지막 문자가 항상 1이므로, 문자열의 마지막 위치가 1인지 확인하여 56자만 추출
    // 추출한 문자열과 암호를 비교하여 실제 값 추출
    // 정답 여부 확인하여 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());
        int passwordCount = 8;

        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;
            int[] passwordArray = new int[passwordCount];
            String[] arraySize = br.readLine().split(" ");

            for (int j = 0; j < Integer.parseInt(arraySize[0]); j++) {
                String str = br.readLine();
                String s = "";
                int idx = str.lastIndexOf("1");
                if (idx != -1) {
                    s = String.valueOf(str.subSequence(idx - 55, idx + 1));
                    for (int k = 0; k < passwordCount; k++) {
                        String ss = s.substring(k*7, (k+1)*7);
                        if (ss.equals("0001101"))
                            passwordArray[k] = 0;
                        else if (ss.equals("0011001"))
                            passwordArray[k] = 1;
                        else if (ss.equals("0010011"))
                            passwordArray[k] = 2;
                        else if (ss.equals("0111101"))
                            passwordArray[k] = 3;
                        else if (ss.equals("0100011"))
                            passwordArray[k] = 4;
                        else if (ss.equals("0110001"))
                            passwordArray[k] = 5;
                        else if (ss.equals("0101111"))
                            passwordArray[k] = 6;
                        else if (ss.equals("0111011"))
                            passwordArray[k] = 7;
                        else if (ss.equals("0110111"))
                            passwordArray[k] = 8;
                        else if (ss.equals("0001011"))
                            passwordArray[k] = 9;
                    }
                    int isAnswer = (passwordArray[0] + passwordArray[2] + passwordArray[4] + passwordArray[6]) * 3 +
                            passwordArray[1] + passwordArray[3] + passwordArray[5] + passwordArray[7];

                    if (isAnswer % 10 == 0)
                        answer = passwordArray[0] +
                                passwordArray[1] +
                                passwordArray[2] +
                                passwordArray[3] +
                                passwordArray[4] +
                                passwordArray[5] +
                                passwordArray[6] +
                                passwordArray[7];

                    sb.append(String.format("#%d %d\n", i, answer));
                    for (int k = 0; k < Integer.parseInt(arraySize[0]) - j - 1; k++) {
                        br.readLine();
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
