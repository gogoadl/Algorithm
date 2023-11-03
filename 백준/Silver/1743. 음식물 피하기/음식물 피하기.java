import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[a][b] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    count = Math.max(count, bfs(i,j));
                }
            }
        }
        System.out.println(count);
    }
    static int bfs(int i, int j) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()) {
            int[] val = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = val[0] + dy[k];
                int nx = val[1] + dx[k];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visited[ny][nx]) continue;
                if (graph[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                count++;
                queue.add(new int[]{ny,nx});
            }
        }
        return count;
    }
}