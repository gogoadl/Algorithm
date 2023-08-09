package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16935 {
    static int N;
    static int M;
    static int R;
    static int[][] arr;
    static int[][] clone;
    static int[][] small;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        clone = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int calc = Integer.parseInt(st.nextToken());
            if (calc == 1) rotateTopDownReverse();
            else if (calc == 2) rotateLeftRightReverse();
            else if (calc == 3) rotateRight90();
            else if (calc == 4) rotateLeft90();
            else if (calc == 5) rotateGroup();
            else rotateGroupReverse();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void copyArray() {
        clone = new int[N][M];
        for(int i=0; i<N; i++){
            System.arraycopy(arr[i], 0, clone[i], 0, M);
        }
    }
    public static void copySmallArray(int startX, int startY, int endX, int endY) {
        small = new int[N/2][M/2];
        for(int i=startX; i<endX; i++){
            System.arraycopy(clone[i], startY, small[i-startX], 0, endY-startY);
        }
    }
    public static void pasteSmallArray(int startX, int startY, int endX, int endY) {
        for(int i=startX; i<endX; i++){
            System.arraycopy(small[i-startX], 0, arr[i], startY, endY-startY);
        }
    }
    public static void rotateTopDownReverse() {
        copyArray();
        for (int i = 0; i < N; i++) {
            arr[i] = clone[N-i-1];
        }
    }
    public static void rotateLeftRightReverse() {
        copyArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = clone[i][M-j-1];
            }
        }
    }
    public static void rotateLeft90() {
        copyArray();
        arr = new int[M][N];
        // 0.0 - 0.5 0.1 - 1.5
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = clone[j][M-i-1];
            }
        }
        int temp = N;
        N = M;
        M = temp;
    }
    public static void rotateRight90() {
        copyArray();
        arr = new int[M][N];
        // 0.0 - 0.5 0.1 - 1.5
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = clone[N-j-1][i];
            }
        }
        int temp = N;
        N = M;
        M = temp;
    }
    public static void rotateGroup() {
        copyArray();

        copySmallArray(0,0,N/2,M/2);
        pasteSmallArray(0, M/2, N/2, M);

        copySmallArray(0,M/2,N/2,M);
        pasteSmallArray(N/2, M/2, N, M);

        copySmallArray(N/2,M/2,N,M);
        pasteSmallArray(N/2, 0, N, M/2);

        copySmallArray(N/2,0,N,M/2);
        pasteSmallArray(0, 0, N/2, M/2);
    }
    public static void rotateGroupReverse() {
        copyArray();

        copySmallArray(0,0,N/2,M/2);
        pasteSmallArray(N/2, 0, N, M/2);

        copySmallArray(N/2,0,N,M/2);
        pasteSmallArray(N/2, M/2, N, M);

        copySmallArray(N/2,M/2,N,M);
        pasteSmallArray(0, M/2, N/2, M);

        copySmallArray(0,M/2,N/2,M);
        pasteSmallArray(0, 0, N/2, M/2);
    }
}
