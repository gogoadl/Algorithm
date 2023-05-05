package com.company.programmers;

public class BinaryChange {



    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int binaryCount = 0;
        while (true) {

            if (s.length() == 1) {
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                }
            }

            s = s.replaceAll("0", "");

            int binaryStr = s.length();

            s = Integer.toBinaryString(binaryStr);
            binaryCount++;
        }
        answer[0] = binaryCount;
        answer[1] = zeroCount;

        return answer;
    }
    public static void main(String[] args) {
        BinaryChange binaryChange = new BinaryChange();
        binaryChange.solution("110010101001");
    }
}

