import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[2001][2001];
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(solve(start, end)).append("\n");
        }
        System.out.println(sb);
    }
    public static int solve(int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) { // 시작점, 끝점이 같을 경우 회문
            return 1;

        } else if (end - start == 1) { // 검색 구간의 길이가 2인 경우
            return arr[start] == arr[end] ? 1 : 0; // 값이 동일한 경우에는 회문
        }

        if (dp[start][end] == 1) return dp[start][end];

        int res = arr[start] == arr[end] ? 1 : 0;

        if (res == 0) {
            return dp[start][end] = res;
        }

        int inner = solve(start + 1, end - 1);

        if (inner == res) {
            return dp[start][end] = res;
        }

        return dp[start][end] = 0;

    }
}
