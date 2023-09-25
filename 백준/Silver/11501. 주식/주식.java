import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 9시 40분 시작

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            long sum = 0;
            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = N-1; j >= 0; j--) {
                if (max < arr[j])
                    max = arr[j];
                else
                    sum += (max - arr[j]);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}