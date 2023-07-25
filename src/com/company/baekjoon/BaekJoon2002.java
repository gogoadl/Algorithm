package org.example.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BaekJoon2002 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        String[] s = new String[N];
        ArrayList<String> comp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            comp.add(br.readLine());
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int compIndex = comp.indexOf(s[j]);
                int index = comp.indexOf(s[i]);
                if (compIndex > index) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}

/*
추월한 차의 기준
1번으로 들어간 차는 추월 불가능
2번차는 1번차보다 앞에 있어야 추월
3번차는 1, 2번차보다 앞에 있어야 추월

String 없이 인덱스 만으로 풀 수 있을 것 같다.


5
ZG206A X
PU234Q X
OS945CK O (1번차보다 위)
ZG431SN X
ZG5962J O

ZG5962J
OS945CK
ZG206A
PU234Q
ZG431SN

 */