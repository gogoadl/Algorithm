import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon3109 {
    static int R;
    static int C;
    static char[][] graph;
    static boolean[][] visited;
    static int answer = 0;
    static boolean flag = false;
    static int[] dy = new int[] {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");

        R = Integer.parseInt(size[0]);
        C = Integer.parseInt(size[1]);

        graph = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            visited[i][0] = true;
            dfs(i, 0,0);
            flag = false;
        }
        System.out.println(answer);
    }
    public static void dfs(int y, int x, int depth) {
        if (depth == C-1) {
            answer++;
            flag = true;
            return;
        }

        for (int i = 0; i < dy.length; i++) {
            if (flag)
                break;
            int currentX = x + 1;
            int currentY = y + dy[i];

            if (currentY < 0 || currentY >= R) continue;
            if (visited[currentY][currentX] || graph[currentY][currentX] == 'x') continue;
            visited[currentY][currentX] = true;
            dfs(currentY, currentX, depth + 1);
        }
    }
}
