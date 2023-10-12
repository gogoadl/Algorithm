import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int p = 1500000;
    static long dp[] = new long[p+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = 0;
        dp[1] = 1;
        long n = Long.parseLong(br.readLine()) % p;
        if (n == 0) {
            System.out.println(0);
            return;
        }
        else if (n == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 2; i <= p; i++) {
            dp[i] = (dp[i-1]+dp[i-2]) % 1000000;
        }

        System.out.println(dp[(int)n]);
    }
}