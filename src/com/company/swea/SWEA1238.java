import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {
    public static class Pair {
        int value;
        int depth;
        public Pair(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCaseCount = 10;
        for (int i = 1; i <= testCaseCount; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int d = 0;
            int max = 0;
            st = new StringTokenizer(br.readLine());
            ArrayList<Pair>[] lists = new ArrayList[101];
            boolean[] visited = new boolean[101];
            for (int j = 0; j < length / 2; j++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (lists[from] == null) {
                    lists[from] = new ArrayList<Pair>();
                }
                lists[from].add(new Pair(to, 0));
            }

            Queue<Pair> queue = new LinkedList<>();
            for (int j = 0; j < lists[start].size(); j++) {
                queue.add(lists[start].get(j));
                visited[lists[start].get(j).value] = true;
            }
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                ArrayList<Pair> list = lists[pair.value];
                if (d < pair.depth) {
                    d = pair.depth;
                    max = 0;
                }
                if (d == pair.depth) {
                    max = Math.max(pair.value, max);
                }
                if (list != null) {
                    for (int j = 0; j < list.size(); j++) {
                        if (!visited[list.get(j).value]) {
                            visited[list.get(j).value] = true;
                            queue.add(new Pair(list.get(j).value, pair.depth + 1));
                        }
                    }
                }
            }

            sb.append(String.format("#%d %d\n", i, max));
        }
        System.out.println(sb);
    }
}
