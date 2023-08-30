import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        if (N == 1) {
            System.out.println(0);
        }
        else if (N == 2) {
            System.out.println(1);
        }
        else {
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= N; i++) {
                dp(i);
            }
            System.out.println(dp[N]);
        }
    }
    public static void dp(int n) {
        int min = Integer.MAX_VALUE;
        if (n % 3 == 0)
            min = Math.min(dp[n/3] + 1, min);
        if (n % 2 == 0)
            min = Math.min(dp[n/2] + 1, min);

        min = Math.min(dp[n-1] + 1, min);
        dp[n] = min;
    }
}