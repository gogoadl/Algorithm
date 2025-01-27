import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - 48;
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.add(new int[]{0,0,0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] value = queue.poll();
            if (value[0] == N-1 && value[1] == M-1) {
                min = Math.min(min, value[2]);
            }
            for (int i = 0; i < dx.length; i++) {
                int cy = value[0] + dy[i];
                int cx = value[1] + dx[i];

                if (cx < 0 || cy < 0 || cx >= M || cy >= N) continue;
                if (visited[cy][cx]) continue;
                if (arr[cy][cx] == 0) {
                    visited[cy][cx] = true;
                    queue.add(new int[]{cy,cx,value[2]});
                } else {
                    visited[cy][cx] = true;
                    queue.add(new int[]{cy,cx,value[2]+1});
                }

            }
        }
        System.out.println(min);
    }

}
