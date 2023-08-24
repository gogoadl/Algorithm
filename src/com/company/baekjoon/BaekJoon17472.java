import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon17472 {
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static ArrayList<int[]> bridges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] graph = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        int islandIndex = 1;

        ArrayList<ArrayList<int[]>> lists = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            lists.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i,j});
                    visited[i][j] = true;
                    graph[i][j] = islandIndex;
                    lists.get(islandIndex).add(new int[]{i,j});
                    while (!queue.isEmpty()) {
                        int[] value = queue.poll();
                        for (int k = 0; k < dx.length; k++) {
                            int cy = value[0] + dy[k];
                            int cx = value[1] + dx[k];

                            if (cx < 0 || cx >= M || cy < 0 || cy >= N) continue;
                            if (visited[cy][cx] || graph[cy][cx] == 0) continue;
                            int[] newVal = new int[]{cy,cx};
                            queue.add(newVal);
                            graph[cy][cx] = islandIndex;
                            lists.get(islandIndex).add(newVal);
                            visited[cy][cx] = true;
                        }
                    }
                    islandIndex++;
                }
            }
        }

//        // bridge에 현재값, 타겟값, 거리
        for (int i = 0; i < lists.size(); i++) {
            ArrayList<int[]> islands = lists.get(i);
            for (int j = 0; j < islands.size(); j++) {
                int[] island = islands.get(j);
                for (int k = island[0]-1; k > 0; k--) { // 위쪽 탐색
                    if (graph[k][island[1]] == graph[island[0]][island[1]])
                        break;
                    if (graph[k][island[1]] != 0) { // 0 이 아니고, 현재 값과 다르다면
                        if (island[0] - k == 2) // 다리의 길이가 1인 경우 연결 불가
                            break;
                        int[] bridge = new int[3];
                        bridge[0] = graph[island[0]][island[1]];
                        bridge[1] = graph[k][island[1]];
                        bridge[2] = island[0] - k - 1;
                        bridges.add(bridge);
                        break;
                    }
                }
                for (int k = island[0]+1; k < N; k++) { // 아래쪽 탐색
                    if (graph[k][island[1]] == graph[island[0]][island[1]])
                        break;
                    if (graph[k][island[1]] != 0) { // 0 이 아니고, 현재 값과 다르다면
                        if (k - island[0] == 2) // 다리의 길이가 1인 경우 연결 불가
                            break;
                        int[] bridge = new int[3];
                        bridge[0] = graph[island[0]][island[1]];
                        bridge[1] = graph[k][island[1]];
                        bridge[2] = k - island[0] - 1;
                        bridges.add(bridge);
                        break;
                    }
                }
                for (int k = island[1]-1; k > 0; k--) { // 왼쪽 탐색

                    if (graph[island[0]][k] == graph[island[0]][island[1]])
                        break;
                    if (graph[island[0]][k] != 0) { // 0 이 아니고, 현재 값과 다르다면
                        if (island[1] - k == 2) // 다리의 길이가 1인 경우 연결 불가
                            break;
                        int[] bridge = new int[3];
                        bridge[0] = graph[island[0]][island[1]];
                        bridge[1] = graph[island[0]][k];
                        bridge[2] = island[1] - k - 1;
                        bridges.add(bridge);
                        break;
                    }
                }
                for (int k = island[1]+1; k < M; k++) { // 오른쪽 탐색

                    if (graph[island[0]][k] == graph[island[0]][island[1]])
                        break;
                    if (graph[island[0]][k] != 0) { // 0 이 아니고, 현재 값과 다르다면
                        if (k - island[1] == 2) // 다리의 길이가 1인 경우 연결 불가
                            break;
                        int[] bridge = new int[3];
                        bridge[0] = graph[island[0]][island[1]];
                        bridge[1] = graph[island[0]][k];
                        bridge[2] = k - island[1] - 1;
                        bridges.add(bridge);
                        break;
                    }
                }
            }
        }
        // 간선의 값을 기준으로 연결 시키기
        Collections.sort(bridges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int[] arr = new int[islandIndex];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < bridges.size(); i++) {
            int[] bridge = bridges.get(i);
            int a = find(arr, bridge[0]);
            int b = find(arr, bridge[1]);
            if (a == b) continue;
            union(arr, a, b);
            answer += bridge[2];
        }
        int parent = find(arr, arr[1]);
        for (int i = 1; i < arr.length; i++) {
            if (find(arr, i) != parent) {
                answer = -1;
                break;
            }
        }
        if (answer == 0)
            answer = -1;
        System.out.println(answer);
    }
    public static int find(int[] array, int x) {
        // 내 루트노드 찾기
        if(array[x] == x) return x;
        return array[x] = find(array, array[x]);
    }
    public static void union(int[] array, int x, int y) {
        int a = find(array, x); // 1의 부모 찾기
        int b = find(array, y); // 2의 부모 찾기
        if(a==b)return;
        array[b] = a;
    }
}
