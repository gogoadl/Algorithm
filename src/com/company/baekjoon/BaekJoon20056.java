package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon20056 {
    public static int[] dc = new int[] {0,1,1,1,0,-1,-1,-1};
    public static int[] dr = new int[] {-1,-1,0,1,1,1,0,-1};
    public static ArrayList<FireBall>[][] graph;
    public static ArrayList<FireBall> fireBalls;
    public static int N;
    public static int M;
    public static int C;
    public static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;
        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 배열 크기
        M = Integer.parseInt(st.nextToken()); // 명령 갯수
        C = Integer.parseInt(st.nextToken()); // 명령 반복 횟수
        graph = new ArrayList[N][N];
        fireBalls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = new ArrayList();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBalls.add(new FireBall(r,c,m,s,d));
        }

        for (int time = 0; time < C; time++) {
            move();
            divide();
        }
        int answer = 0;

        for (FireBall fireBall : fireBalls) {
            answer += fireBall.m;
        }
        System.out.println(answer);
    }
    public static void move() {
        for (FireBall fireBall : fireBalls) {
            // 파이어볼 리스트에서 꺼내기
            int nr = (fireBall.r + N + dr[fireBall.d] * (fireBall.s % N)) % N;
            int nc = (fireBall.c + N + dc[fireBall.d] * (fireBall.s % N)) % N;
            fireBall.r = nr;
            fireBall.c = nc;
            graph[nr][nc].add(fireBall);
        }
    }
    public static void divide() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j].size() < 2) { // 이동 후 좌표에 파이어볼이 1개라면 삭제
                    graph[i][j].clear();
                    continue;
                }

                int massSum = 0;
                int aSum = 0;

                boolean even = graph[i][j].get(0).d % 2 == 0;
                boolean odd = graph[i][j].get(0).d % 2 == 1;

                for (FireBall fireBall: graph[i][j]) {
                    massSum += fireBall.m;
                    aSum += fireBall.s;
                    even = even & fireBall.d % 2 == 0;
                    odd = odd & fireBall.d % 2 == 1;
                    fireBalls.remove(fireBall);
                }
                int newMass = massSum / 5;
                int size = graph[i][j].size();
                graph[i][j].clear();

                if (newMass == 0)
                    continue;
                int newS = aSum / size;
                if (even | odd) {
                    for (int k = 0; k < 8; k+=2) {
                        fireBalls.add(new FireBall(i,j,newMass,newS,k));
                    }
                } else {
                    for (int k = 1; k < 8; k+=2) {
                        fireBalls.add(new FireBall(i,j,newMass,newS,k));
                    }
                }
            }
        }
    }
}