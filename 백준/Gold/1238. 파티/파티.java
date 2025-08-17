import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node {
        int index;
        int cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static int N;
    static int M;
    static int X;
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] reverseList;
    static int[] distance;
    static boolean[] visited;
    static int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, cost));
            reverseList[end].add(new Node(start, cost));
        }

        int[] result = dijkstra(list);
        int[] reverseResult = dijkstra(reverseList);

        int max = -1;

        for (int i = 1; i <= N; i++) {
            if (result[i] == INF || reverseResult[i] == INF) continue; // 도달 불가면 스킵
            max = Math.max(max, result[i] + reverseResult[i]);
        }

        System.out.println(max);

    }

    public static int[] dijkstra(ArrayList<Node>[] list) {
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        Arrays.fill(distance, INF);

        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        queue.add(new Node(X,0));
        distance[X] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.index]) continue;
            visited[node.index] = true;

            for (Node current: list[node.index]) {
                if (distance[current.index] > distance[node.index] + current.cost) {
                    distance[current.index] = distance[node.index] + current.cost;
                    queue.add(new Node(current.index, distance[current.index]));
                }
            }
        }
        return distance;
    }
}
