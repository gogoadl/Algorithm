package org.example.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int a = -1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                a = 0;
                break;
            }
        }
        if (input.contains("__") || input.charAt(0) == '_' || Character.isUpperCase(input.charAt(0)) ||input.charAt(input.length()-1) == '_' || (a == 0 && input.contains("_"))){ // 대문자 없고, _ 포함
            a = 4;
        } else if (a == 0 && Character.isLowerCase(input.charAt(0)) && !input.contains("_")) { // 대문자 있음, 첫번째는 소문자, _없어야 함
            a = 1;
        }  else if (a == -1 && input.contains("_")) { // 대문자 없음, _ 포함되어야 함.
            a = 2;
        } else {
            a = 3;
        }
        if (a == 1) {
            int index = 0;
            for (int i = 0; i < input.length(); i++) {
                if (Character.isUpperCase(input.charAt(i))) {
                    sb.append(input.substring(index, i).toLowerCase()).append("_");
                    index = i;
                }
            }
            sb.append(input.substring(index).toLowerCase());
        } else if (a == 2) {
            int index = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '_') {
                    String s = input.substring(index, i);
                    sb.append(Character.toUpperCase(s.charAt(0)));
                    s = s.substring(1);
                    sb.append(s);
                    index = i+1;
                }
            }
            String s = input.substring(index);
            sb.append(Character.toUpperCase(s.charAt(0)));
            s = s.substring(1);
            sb.append(s);
            sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        } else if (a == 3) {
            sb.append(input);
        } else {
            sb.append("Error!");
        }
        System.out.println(sb);
    }
}
