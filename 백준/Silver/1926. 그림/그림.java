import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dy = new int[] {-1,1,0,0};
    static int[] dx = new int[] {0,0,-1,1};
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {

                    max = Math.max(dfs(i,j,1), max);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);

    }
    static int dfs(int i, int j, int count) {
        int size = 1;
        visited[i][j] = true;

        for (int k = 0; k < dx.length; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (arr[ny][nx] == 0) continue;
            visited[ny][nx] = true;
            size += dfs(ny,nx,count+1);
        }
        return size;
    }
}
