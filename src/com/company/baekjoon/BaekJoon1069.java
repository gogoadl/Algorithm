package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken()); // 현재 X 좌표
        int Y = Integer.parseInt(st.nextToken()); // 현재 Y 좌표
        int D = Integer.parseInt(st.nextToken()); // 점프로 움직일 수 있는 칸
        int T = Integer.parseInt(st.nextToken()); // 점프에 걸리는 시간

        double dist = Math.sqrt(X*X+Y*Y); // (X,Y) - (0,0) 사이의 직선 거리
        double result = dist;

        // 점프 이동거리가 점프에 걸리는 시간보다 작다면, 걷는 것이 더 효율적이다.
        if (T > D) { // 걷는 경우
            System.out.println(dist + "\n");
        } else { // 점프를 사용하는 경우
            int jump = (int) dist / D; // 점프 횟수

            double time = dist - D * jump;

            result = Math.min(result, time + T * jump); // 점프하고 남은 거리 걷는 경우

            result = Math.min(result, D * (jump + 1) - dist + T * (jump + 1)); // 0,0 넘어서까지 점프하고 뒤로 걷는 경우

            if (jump > 0)
                result = Math.min(result, (double) (jump + 1) * T); // 방향 꺾어서 점프만 하는 경우
            else
                result = Math.min(result, T * 2.0); // 점프만 두번 하는 경우
            System.out.println(result + "\n");
        }
    }
}
