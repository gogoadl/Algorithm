import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean[] visited = new boolean[1000001];
    static int[][] dp = new int[1000001][2];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }
        find(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    public static void find(int x) {
        visited[x] = true;
        dp[x][1] = 1;
        for (int i = 0; i < arrayList.get(x).size(); i++) {
            int child = arrayList.get(x).get(i);

            if (!visited[child]) {
                visited[child] = true;
                find(child);
                dp[x][0] += dp[child][1];
                dp[x][1] += Math.min(dp[child][0], dp[child][1]);
                // 0: 일반인
                // 1: 얼리어답터
                // 일반인일 경우, 모든 자식이 얼리 어답터인 경우가 값이 됨.
                // 얼리어답터인 경우 자식이 일반인인 경우와 얼리어답터인 경우 모두를 확인해봐야함.
            }
        }
    }
}