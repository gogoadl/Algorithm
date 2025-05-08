import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static List<Integer>[] graph;
    static int[] sccId;
    static int[] discovered;
    static int vertexCounter, sccCounter;
    static Stack<Integer> stack = new Stack<>();
    static List<Queue<Integer>> scc;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt((st.nextToken()));
        E = Integer.parseInt((st.nextToken()));
        sccId = new int[V+1];
        discovered = new int[V+1];
        graph = new ArrayList[V+1];
        scc = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
            discovered[i] = -1;
            sccId[i] = -1;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }
        for (int i = 1; i <= V; i++) {
            if (discovered[i] == -1) // 탐색된 정점이 아닌경우 탐색
                dfs(i);
        }

        System.out.println(sccCounter);
        Collections.sort(scc, (Comparator.comparingInt(Queue::peek)));
        StringBuilder sb = new StringBuilder();

        for (Queue<Integer> q : scc) {
            while (!q.isEmpty()) {
                sb.append(q.poll() + " ");
            }
            sb.append(-1 + "\n");
        }
        System.out.println(sb);
    }
    public static int dfs(int root) {
        int parent = discovered[root] = vertexCounter++;
        stack.push(root);

        for (int i = 0; i < graph[root].size(); i++) { // 정점과 연결된 모든 정점을 비교해 부모 정점을 찾는다
            int target = graph[root].get(i);
            if (discovered[target] == -1) { // 연결된 노드가 탐색되지 않은 경우 재귀 호출
                parent = Math.min(parent, dfs(target));
            } else if (sccId[target] == -1) { // 탐색되었으나 SCC로 성립되지 않은 정점
                parent = Math.min(parent, discovered[target]);
            }
        }
        if (parent == discovered[root]) {
            Queue<Integer> queue = new PriorityQueue<>();
            while (true) {
                int t = stack.pop();
                queue.add(t);
                sccId[t] = sccCounter;
                if (t == root) break;
            }
            scc.add(queue);
            sccCounter++;
        }
        return parent;
    }
}
