import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger dp[] = new BigInteger[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        else if (n == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 2; i <= n; i++) {
            fib(i);
        }
        System.out.println(dp[n]);
    }
    static void fib(int n) {
        dp[n] = dp[n-1].add(dp[n-2]);
    }
}