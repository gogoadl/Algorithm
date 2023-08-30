import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1003 {
    static int dp[] = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0)
                sb.append(1).append(" ").append(0).append("\n");
            else if (N == 1)
                sb.append(0).append(" ").append(1).append("\n");
            else
                sb.append(dp(N-1)).append(" ").append(dp(N)).append("\n");
        }
        System.out.println(sb);
    }
    public static int dp(int n) {
        if (n >= 2 && dp[n] == 0)
            dp[n] = dp(n - 1) + dp(n - 2);
        return dp[n];
    }
}