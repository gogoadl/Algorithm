import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int [][] graph = new int[N][N];
		boolean[] visited = new boolean[N];
		boolean[] target = new boolean[N];
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		int start = 0;
		boolean checkStart = false;
		while (st.hasMoreTokens()) {
			int val = Integer.parseInt(st.nextToken()) - 1;
			if (!checkStart) {
				start = val;
				checkStart = true;
			}
			target[val] = true;
		}

		dfs(graph,visited, start);
		boolean isTravel = checkCity(visited, target);

		if (isTravel) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	public static boolean checkCity(boolean[] visited, boolean[] target) {
		boolean isTravel = false;
		for (int i = 0; i <visited.length; i++) {
			if (target[i]) { // 꼭 들러야 하는곳이라면
				if (visited[i]) {
					isTravel = true;
				} else {
					isTravel = false;
					break;
				}
			}
		}
		return isTravel;
	}
	public static void dfs(int[][] graph, boolean[] visited, int start) {
		visited[start] = true;
		for (int i = 0; i < graph.length; i++) {
			if (!visited[i] && graph[start][i] == 1) {
				dfs(graph, visited, i);
			}
		}
	}
}