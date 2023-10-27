import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] dp = new long[1001][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i-1][j] % 10007 + dp[i][j-1] % 10007) % 10007 ;
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n-1][i]%10007;
        }
        System.out.println(sum % 10007);
    }
}