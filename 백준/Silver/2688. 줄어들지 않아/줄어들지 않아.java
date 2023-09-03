import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] dp = new long[65][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        for (int i = 0; i < testCaseCount; i++) {
            int N = Integer.parseInt(br.readLine());
            long ans = 0;

            for (int j = 0; j <= 9; j++) {
                ans += dp[N][j];
            }

            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}