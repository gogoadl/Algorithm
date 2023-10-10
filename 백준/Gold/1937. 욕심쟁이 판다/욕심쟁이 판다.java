import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static int n;
    static int[][] dp;
    static int[][] graph;
    static int maxSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n][n];
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSize = Math.max(maxSize, updateMaxSize(i,j));
            }
        }
        System.out.println(maxSize);
    }
    static int updateMaxSize(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];

        dp[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int cy = i + dy[k];
            int cx = j + dx[k];

            if (cy < 0 || cx < 0 || cy >= n || cx >= n) continue;
            if (graph[cy][cx] > graph[i][j]) {
                dp[i][j] = Math.max(dp[i][j], updateMaxSize(cy,cx)+1);
            }
        }

        return dp[i][j];
    }

}