import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] { 0,0,-1,1};

    static int N;
    static int M;
    static int[][] graph;
    static int[][] tempGraph;
    static ArrayList<int[]> virus = new ArrayList<>();
    static int safeArea;
    static int initWallCount;
    static int initVirusCount;
    static int virusCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new int[N][M];
        tempGraph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                graph[i][j] = Integer.parseInt(arr[j]);
                if (graph[i][j] == 2) {
                    virus.add(new int[]{i, j});
                    initVirusCount++;
                } else if (graph[i][j] == 1) {
                    initWallCount++;
                }
            }
        }
        combi(0);
        System.out.println(safeArea);
    }
    static void copyGraph() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(graph[i],0,tempGraph[i],0,graph[i].length);
        }
    }
    public static void combi(int wallCount) {
        if (wallCount == 3) {
            // bfs 탐색
            copyGraph();
            bfs();
            int count = N*M - (initWallCount + wallCount + initVirusCount + virusCount);
            safeArea = Math.max(count, safeArea);
            virusCount = 0;
            copyGraph();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    combi(wallCount+1);
                    graph[i][j] = 0;
                }
            }
        }
    }
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.addAll(virus);
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cy = v[0] + dy[i];
                int cx = v[1] + dx[i];

                if (cy < 0 || cx < 0 || cy >= N || cx >= M) continue;
                if (tempGraph[cy][cx] != 0) continue;
                tempGraph[cy][cx] = 2;
                virusCount++;
                queue.add(new int[]{cy,cx});
            }
        }
    }
}