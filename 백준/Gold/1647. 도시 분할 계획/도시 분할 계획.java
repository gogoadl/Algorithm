import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 1. 그래프의
public class Main {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }
    static int N;
    static int M;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = i;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.add(new Node(n1,n2,w));
        }

        int sum = 0;
        int cnt = 0;
        while (cnt < N - 2) {
            Node value = queue.poll();
            if (find(value.start) != find(value.end)) {
                sum += value.weight;
                union(value.start, value.end);
                cnt++;
            }
        }

        System.out.println(sum);
    }
    static int find(int x) {
        if (nums[x] == x) return x;
        else return nums[x] = find(nums[x]);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        nums[y] = x;
    }
}