import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void belmanFord(long[][] graph, int n, int m, int start, long[] dist) {
        Arrays.fill(dist, Long.MAX_VALUE);
        // 시작점의 거리를 0으로 초기화
        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) { // 정점의 갯수 - 1 만큼 반복
            for (int j = 0; j < m; j++) { // 간선의 갯수 만큼 반복
                if (dist[(int) graph[j][0]] != Long.MAX_VALUE) { // 방문가능한 정점이라면
                    // 1. 1번 정점의 최단거리 배열이 초기값이 아니라면 (시작 점 이므로 무조건 0)
                    dist[(int) graph[j][1]] = Math.min(dist[(int) graph[j][1]], dist[(int) graph[j][0]] + graph[j][2]);
                    // 2. 시작점에서 해당 정점까지의 거리가 최소값보다 작다면 갱신
                } // 시작점에서 해당 정점까지의 거리가 최소값보다 작다면 갱신
            }
        }
    }
    public static boolean isCycle(long[][] graph, int m, long[] dist) { 
        // 사이클 확인을 위해서는 정점의 갯수 만큼 반복할 필요는 없음. 한번 수행 했을 때 기존값과 달라지면 음수 사이클 존재
        for (int i = 0; i < m; i++) {
            if (dist[(int) graph[i][0]] != Long.MAX_VALUE && dist[(int) graph[i][1]] > dist[(int) graph[i][0]] + graph[i][2]) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] graph = new long[m][3];
        long[] dist = new long[n + 1];



        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            graph[i][0] = u;
            graph[i][1] = v;
            graph[i][2] = w;
        }
        belmanFord(graph, n, m, 1, dist);
        if (isCycle(graph, m, dist))
            System.out.println("-1");
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Long.MAX_VALUE)
                    sb.append("-1\n");
                else
                    sb.append(dist[i]).append("\n");
            }
            System.out.print(sb);
        }
    }
}
