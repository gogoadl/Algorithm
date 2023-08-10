import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon6497 {
	static int N;
	static int M;
	static ArrayList<Node>[] list;
	static int total;
	static int answer;
	static int minCost;
	static boolean[] visited;
	

	public static void bfs() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(0,0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (!visited[current.e]) visited[current.e] = true;
			else continue;
			
			minCost += current.cost;
			 for(int i = 0; i < list[current.e].size(); i++) {
	                Node next = list[current.e].get(i);
	                if(visited[next.e] == false) queue.offer(next);
	        }
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if (M == 0 && N == 0)
				break;
			total = 0;
			minCost = 0;
			visited = new boolean[M];
            list = new ArrayList[N];
            for(int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
	 
            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, cost));
                list[e].add(new Node(s, cost));
                total += cost;
            }
			bfs();
			sb.append(total - minCost).append("\n");
		}
		System.out.println(sb);
	}
}
class Node implements Comparable<Node> {
	int e;
	int cost;
	public Node(int e, int cost) {
		this.e = e;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
	
}