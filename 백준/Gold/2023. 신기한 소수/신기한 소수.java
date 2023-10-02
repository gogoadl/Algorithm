import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        dfs(1, N, 0);

        System.out.println(sb);
    }
    public static void dfs(int index, int N, int s) {
        if (index == N+1) {
            sb.append(s).append("\n");
            return;
        }
        for (int i = 1; i < 10; i++) {
            int s2 = 10 * s + i;

            boolean isPrime = true;
            if (s2 == 1) isPrime = false;
            for (int j = 2; j <= Math.sqrt(s2); j++) {
                    if (s2 % j == 0) isPrime = false;
                }
            if (isPrime)
                dfs(index + 1, N, s2);
        }
    }
}