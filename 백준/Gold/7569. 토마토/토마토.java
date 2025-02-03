import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] dz = new int[]{-1,1};
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int N;
    static int M;
    static int H;
    static int[][][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int zeroCount=0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) zeroCount++;
                }
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        arrayList.add(new int[]{i,j,k,1});
                    }
                }

            }
        }
        bfs(arrayList);
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(max-1);

    }
    static void bfs(ArrayList<int[]> arrayList) {

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[3]));
        q.addAll(arrayList);

        while (!q.isEmpty()) {
            int[] value = q.poll();
            for (int k = 0; k < dx.length; k++) {
                int cz = value[0];
                int cx = value[1] + dy[k];
                int cy = value[2] + dx[k];

                if (cx < 0 || cy < 0 || cx >= N || cy >= M) continue;
                if (arr[cz][cx][cy] == -1) continue;
                if (arr[cz][cx][cy] != 0) continue;
                arr[cz][cx][cy] = value[3];
                q.add(new int[]{cz,cx,cy,value[3]+1});
                max = Math.max(max, value[3]+1);
            }
            for (int i = 0; i < dz.length; i++) {
                int cz = value[0] + dz[i];
                int cx = value[1];
                int cy = value[2];
                if (cz < 0 || cz >= H) continue;
                if (arr[cz][cx][cy] == -1) continue;
                if (arr[cz][cx][cy] != 0) continue;
                arr[cz][cx][cy] = value[3];
                q.add(new int[]{cz,cx,cy,value[3]+1});
                max = Math.max(max, value[3]+1);
            }
        }
    }
}
