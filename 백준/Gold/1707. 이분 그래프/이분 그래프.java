import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] colors;
    static ArrayList<Integer>[] arrayLists;
    static int V;
    static int E;
    static String res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCaseCount =  Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < testCaseCount; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            colors = new int[V];
            arrayLists = new ArrayList[V];
            for (int j = 0; j < V; j++) {
                arrayLists[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken())-1;
                int second = Integer.parseInt(st.nextToken())-1;
                arrayLists[first].add(second);
                arrayLists[second].add(first);
            }
            res = "YES";
            for (int j = 0; j < V; j++) {
                if (colors[j] == 0)
                    bfs(j);
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        colors[v] = 1;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int vertex : arrayLists[val]) {
                if (colors[vertex] == 0) { // 0이면 색칠 안된 곳
                    colors[vertex] = colors[val] * -1;
                    queue.add(vertex);
                }
                if (colors[vertex] == colors[val]) {
                    res = "NO";
                    return;
                }
            }
        }
    }
}