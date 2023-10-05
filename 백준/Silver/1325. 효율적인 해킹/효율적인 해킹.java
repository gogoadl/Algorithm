import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int maxCnt = 0;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        cnt = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            graph[first].add(second);
        }
        for (int i = 0; i < N; i++) {
            if (!graph[i].isEmpty()) {
                Arrays.fill(visited,false);
                dfs(i);
            }
        }

        for (int i = 0; i < N; i++) {
            maxCnt = Math.max(cnt[i], maxCnt);
        }
        for (int i = 0; i < N; i++) {
            if (cnt[i] == maxCnt)
                sb.append(i+1).append(" ");
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        System.out.println(sb);
    }
    public static void dfs(int s) {
        visited[s] = true;
        for (int val: graph[s]) {
            if (!visited[val]) {
                dfs(val);
                cnt[val]++;
            }
        }
//        for (int i = 0; i < graph[s].size(); i++) {
//            int val = graph[s].get(i);
//            if (!visited[val]) {
//                dfs(val);
//                cnt[val]++;
//            }
//        }
    }
}