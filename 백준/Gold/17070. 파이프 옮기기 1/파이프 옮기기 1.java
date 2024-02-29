import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int count = 0;

    static int TO_RIGHT = 1;
    static int TO_MIDDLE = 2;
    static int TO_BOTTOM = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int currentY = 0;
        int currentX = 1;
        dfs(currentY, currentX, TO_RIGHT);

        System.out.println(count);
    }
    public static void dfs(int cy, int cx, int type) {
        if (cy == N - 1 && cx == N - 1) {
            count++;
            return;
        } else if (type == TO_RIGHT && cx == N - 1)
            return;
        else if (type == TO_BOTTOM && cy == N - 1)
            return;

        if (type == TO_RIGHT) {
            if (cx + 1 < N && arr[cy][cx+1] != 1) {
                dfs(cy, cx+1, TO_RIGHT);
            }
            if (cx + 1 < N && cy + 1 < N && arr[cy+1][cx+1] != 1 && arr[cy+1][cx] != 1 && arr[cy][cx+1] != 1) {
                dfs(cy+1,cx+1, TO_MIDDLE);
            }
        } else if (type == TO_MIDDLE) {
            if (cx + 1 < N && arr[cy][cx+1] != 1) {
                dfs(cy, cx+1, TO_RIGHT);
            }
            if (cx + 1 < N && cy + 1 < N && arr[cy+1][cx+1] != 1 && arr[cy+1][cx] != 1 && arr[cy][cx+1] != 1) {
                dfs(cy+1,cx+1, TO_MIDDLE);
            }
            if (cy + 1 < N && arr[cy+1][cx] != 1) {
                dfs(cy+1, cx, TO_BOTTOM);
            }
        } else if (type == TO_BOTTOM) {
            if (cx + 1 < N && cy + 1 < N && arr[cy+1][cx+1] != 1 && arr[cy+1][cx] != 1 && arr[cy][cx+1] != 1) {
                dfs(cy+1,cx+1, TO_MIDDLE);
            }
            if (cy + 1 < N && arr[cy+1][cx] != 1) {
                dfs(cy+1, cx, TO_BOTTOM);
            }
        }
    }
}
