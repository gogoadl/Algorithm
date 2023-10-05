import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static int N;
    static int W;
    static int H;
    static int[][] arr;
    static int[][] temp;
    static boolean[][] visited;
    static int max;
    static int count;
    static int blocks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            arr = new int[H][W];
            visited = new boolean[H][W];
            temp = new int[H][W];
            int[] target = new int[N];
            max = 0;
            count = 0;
            blocks = 0;
            for (int j = 0; j < H; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < W; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, target);
            sb.append(String.format("#%d %d\n", i, blocks));
        }
        System.out.println(sb);
    }
    public static void dfs(int depth, int[] target) {
        if (depth == N) {
            for(int i=0; i<arr.length; i++){
                System.arraycopy(arr[i], 0, temp[i], 0, arr[0].length);
            }
            for (int i = 0; i < N; i++) { // 선택된 구슬 순서대로 벽 부수기
                for (int j = 0; j < H; j++) {
                    if (temp[j][target[i]] != 0) {
                        bfs(j, target[i],temp[j][target[i]]);
                        destroy();
                        gravity();
                        visited = new boolean[H][W];
                        break;
                    }
                }
            }
            if (max < count) {
                max = count;
                blocks = getBlocks();
            }
            count = 0;
            return;
        }

        for (int i = 0; i < W; i++) { // N개만큼 구슬 선택
            target[depth] = i;
            dfs(depth+1, target);
        }
    }
    public static void bfs(int j, int i, int value) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {j,i, value});
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            for (int k = 0; k < dx.length; k++) {
                for (int l = 0; l < val[2]; l++) {
                    int cy = val[0] + dy[k]*l;
                    int cx = val[1] + dx[k]*l;
                    if (cx < 0 || cy < 0 || cx >= W || cy >= H) continue;
                    if (visited[cy][cx] || temp[cy][cx] == 0) continue;
                    queue.add(new int[] {cy,cx, temp[cy][cx]});
                    visited[cy][cx] = true;
                    count++;
                }
            }
        }
    }
    public static void destroy() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j])
                    temp[i][j] = 0;
            }
        }
    }
    public static void gravity() {
        for (int i = 0; i < W; i++) {
            for (int j = H-1; j >= 0; j--) {
                if (temp[j][i] == 0) continue;
                int idx = j+1;
                while (true) {
                    if (idx == H) break;
                    if (temp[idx][i] == 0) idx++;
                    else break;
                }
                if (idx == j+1) continue;
                temp[idx-1][i] = temp[j][i];
                temp[j][i] = 0;
            }
        }
    }
    public static int getBlocks() {
        int res = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (temp[i][j] != 0) res++;
            }
        }
        return res;
    }
}