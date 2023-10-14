import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, val));
            // list[e].add(new Node(s, val));
        }
        int[] dist = new int[V+1];
        boolean[] visited = new boolean[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        queue.add(new Node(K, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (visited[now.next]) continue;

            visited[now.next] = true;
            for (Node node: list[now.next]) {
                if (dist[node.next] > dist[now.next] + node.cost) {
                    dist[node.next] = dist[now.next] + node.cost;
                    queue.add(new Node(node.next, dist[node.next]));
                }
            }
        }

        for(int i = 1 ; i <= V ; i ++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
    static class Node {
        int next;
        int cost;
        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}