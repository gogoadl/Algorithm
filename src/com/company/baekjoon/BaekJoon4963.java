import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon4963 {
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int w;
    static int h;
    static boolean[][] visited;
    static int[][] islands;
    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i,j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] island = queue.poll();
            for (int k = 0; k < dx.length; k++) {
                int cx = island[0] + dx[k];
                int cy = island[1] + dy[k];

                if (cx < 0 || cx >= h || cy < 0 || cy >= w) continue;
                if (visited[cx][cy] || islands[cx][cy] == 0) continue;
                visited[cx][cy] = true;
                queue.add(new int[] {cx, cy});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 || h == 0) {
                break;
            }

            islands = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    islands[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (islands[i][j] == 1 && !visited[i][j]) {
                        bfs(i,j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
