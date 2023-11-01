import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Node>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arrayLists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) -1;
            int second = Integer.parseInt(st.nextToken()) -1;
            int value = Integer.parseInt(st.nextToken());

            arrayLists[first].add(new Node(first, second, value));
            arrayLists[second].add(new Node(second, first, value));
        }

        int[] dist = new int[n];
        for(int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;

        boolean isFirst = false;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0,0,0));
        dist[0] = 0;
        visited[0] = false;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!visited[node.s]) {
                visited[node.s] = true;
                if (!isFirst) isFirst = true;
                else {
                    sb.append(String.format("%d %d\n", node.f+1, node.s+1));
                    count++;
                }
            }

            for(int i = 0; i < arrayLists[node.s].size(); i++) {
                Node next = arrayLists[node.s].get(i);
                
                if(dist[next.s] > dist[node.s] + next.cost){
                    dist[next.s] = dist[node.s] + next.cost;
                    queue.offer(new Node(next.f, next.s, dist[next.s]));
                }
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
    static class Node implements Comparable<Node>{
        int f;
        int s;
        int cost;
        public Node(int f, int s, int cost) {
            this.f = f;
            this.s = s;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
/*
4 5
1 2 1
1 3 2
1 4 3
2 3 1
3 4 1

 */