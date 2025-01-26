import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int N;
    static int M;
    static int[][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int zeroCount=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) zeroCount++;
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    arrayList.add(new int[]{i,j,1});
                }
            }
        }
        bfs(arrayList);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max-1);

    }
    static void bfs(ArrayList<int[]> arrayList) {

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        q.addAll(arrayList);

        while (!q.isEmpty()) {
            int[] value = q.poll();
            for (int k = 0; k < dx.length; k++) {
                int cx = value[0] + dy[k];
                int cy = value[1] + dx[k];

                if (cx < 0 || cy < 0 || cx >= N || cy >= M) continue;
                if (arr[cx][cy] == -1) continue;
                if (arr[cx][cy] != 0) continue;
                arr[cx][cy] = value[2];
                q.add(new int[]{cx,cy,value[2]+1});
                max = Math.max(max, value[2]+1);
            }
        }
    }
}
