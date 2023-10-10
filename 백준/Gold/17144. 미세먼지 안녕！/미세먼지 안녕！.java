import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int[][] home;
    static int[][] tempHome;
    static int R;
    static int C;
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        home = new int[R][C];
        tempHome = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
                if (home[i][j] == -1) {
                    list.add(new int[]{i,j});
                } else if (home[i][j] != 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 확산 했으니까 공기청정기 돌리자
        for (int i = 0; i < T; i++) {
            copyArray();
            while (!queue.isEmpty()) {
                int[] val = queue.poll();
                bfs(val[0],val[1]);
            }
            top();
            bot();
            pasteArray();
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (tempHome[j][k] > 0) {
                        queue.add(new int[]{j,k});
                    }
                }
            }

        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (tempHome[i][j] > 0) {
                    answer+= tempHome[i][j];
                }
            }
        }
        System.out.println(answer);
    }
    public static void top() {
        int[] top = list.get(0);

        for (int i = top[0]-1; i > 0; i--) {
            tempHome[i][0] = tempHome[i-1][0];
        }
        tempHome[top[0]][top[1]] = -1;

        for (int i = 0; i < C-1; i++) {
            tempHome[0][i] = tempHome[0][i+1];
        }
        for (int i = 0; i < top[0]; i++) {
            tempHome[i][C-1] = tempHome[i+1][C-1];
        }

        for (int i = C-1; i > 1; i--) {
            tempHome[top[0]][i] = tempHome[top[0]][i-1];
        }
        tempHome[top[0]][1] = 0;
    }
    public static void bot() {
        int[] top = list.get(1);

        for (int i = top[0]+1; i < R-1; i++) {
            tempHome[i][0] = tempHome[i+1][0];
        }
        tempHome[top[0]][top[1]] = -1;

        for (int i = 0; i < C-1; i++) {
            tempHome[R-1][i] = tempHome[R-1][i+1];
        }
        for (int i = R-1; i > top[0]; i--) {
            tempHome[i][C-1] = tempHome[i-1][C-1];
        }
        for (int i = C-1; i > 1; i--) {
            tempHome[top[0]][i] = tempHome[top[0]][i-1];
        }
        tempHome[top[0]][1] = 0;
    }
    public static void bfs(int i, int j) {
        if (home[i][j] >= 5) {
            int val = home[i][j] / 5;
            for (int k = 0; k < 4; k++) {
                int cy = i + dy[k];
                int cx = j + dx[k];

                if (cx >= 0 && cy >= 0 && cx < C && cy < R) {
                    if (home[cy][cx] != -1) {
                        tempHome[cy][cx] += val;
                        tempHome[i][j] -= val;
                    }
                }
            }
        }
    }
    public static void copyArray() {
        for (int i = 0; i < R; i++) {
            tempHome[i] = Arrays.copyOf(home[i], home[i].length);
        }
    }
    public static void pasteArray() {
        for (int i = 0; i < R; i++) {
            home[i] = Arrays.copyOf(tempHome[i], home[i].length);
        }
    }
}

/*
7 8 3
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
0 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
-1 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0

 */

//0 = {int[8]@503} [0, 0, 0, 0, 0, 0, 1, 8]
//        1 = {int[8]@504} [0, 0, 1, 0, 3, 0, 5, 6]
//        2 = {int[8]@505} [0, 2, 1, 1, 0, 4, 6, 5]
//        3 = {int[8]@506} [-1, 5, 2, 0, 0, 2, 12, 0]
//        4 = {int[8]@507} [-1, 1, 1, 0, 5, 10, 13, 8]
//        5 = {int[8]@508} [0, 1, 9, 4, 3, 5, 12, 0]
//        6 = {int[8]@509} [0, 8, 17, 8, 3, 4, 8, 4]