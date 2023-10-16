import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visited;
    static int cnt;
    static int wSum;
    static int bSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        arr = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = c[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    cnt = 0;
                    dfs(i,j);
                    if (arr[i][j] == 'W') wSum += cnt*cnt;
                    else bSum += cnt*cnt;
                }
            }
        }
        System.out.println(wSum + " " + bSum);
    }
    static void dfs(int y, int x) {
        visited[y][x] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (visited[ny][nx]) continue;
            if (arr[ny][nx] != arr[y][x]) continue;
            visited[ny][nx] = true;

            dfs(ny, nx);
        }
    }
}