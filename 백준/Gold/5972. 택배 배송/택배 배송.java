
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 1000000000;
    public static void dijkstra(ArrayList<int[]>[] lists, int start, boolean[] visited, int[] dist) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (visited[node[0]]) continue; // 방문한 노드일 경우 스킵
            visited[node[0]] = true;

            for (int i = 0; i < lists[node[0]].size(); i++) {
                    int[] current = lists[node[0]].get(i);
                    dist[current[0]] = Math.min(dist[current[0]], dist[node[0]] + current[1]);
                    queue.add(new int[]{current[0], dist[current[0]]});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] lists = new ArrayList[N+1];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lists[start].add(new int[]{end, cost});
            lists[end].add(new int[]{start, cost});
        }

        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, INF);

        dist[1] = 0;
        dijkstra(lists, 1, visited, dist);

        System.out.println(dist[N]);
    }
}
