import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 상하좌우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] mapCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int problemIndex = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                return; // 종료 조건
            }
            map = new int[N][N];
            mapCost = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(mapCost[i], Integer.MAX_VALUE); // 비용 배열 초기화
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.add(new int[]{map[0][0], 0, 0}); // {비용, x좌표, y좌표}
            mapCost[0][0] = map[0][0];
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int cost = current[0];
                int x = current[1];
                int y = current[2];

                if (x == N - 1 && y == N - 1) {
                    System.out.println(String.format("Problem %d: %d", problemIndex++, cost));
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (mapCost[nx][ny] > map[nx][ny] + cost) {
                            mapCost[nx][ny] = map[nx][ny] + cost;
                            pq.add(new int[]{mapCost[nx][ny], nx, ny});
                        }
                    }
                }
            }
        }
    }
}
