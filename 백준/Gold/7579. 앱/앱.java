import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int allCost = 0;
        int[] apps = new int[n];
        int[] memories = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apps[i] = Integer.parseInt(st.nextToken());
            allCost += apps[i];
        }
        int max = Integer.MAX_VALUE;

        int[][] dp = new int[n][allCost+1];

        for (int i = 0; i < n; i++) {
            int memory = memories[i];
            int app = apps[i];

            for (int j = 0; j <= allCost; j++) {
                if (i == 0) {
                    if (j >= app)
                        dp[i][j] = memory;
                } else {
                    if (j >= app) {
                        dp[i][j] = Math.max(dp[i-1][j-app] + memory, dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                if (dp[i][j] >= m) {
                    max = Math.min(max, j);
                }
            }
        }
        System.out.println(max);
    }
}