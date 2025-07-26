import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];

        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0)
                    distance[i][j] = -1;
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (distance[nx][ny] != -1) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    distance[nx][ny] = 0;
                    continue;
                }
                distance[nx][ny] = distance[current[0]][current[1]] + 1;
                queue.add(new int[]{nx, ny});

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}


//15 15
//2 1 0 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 0 1 1 1 1 1 1 1 1 1 1 1 1
//0 0 0 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 1