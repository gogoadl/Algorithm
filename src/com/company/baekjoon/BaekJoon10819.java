import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10819 {
	static int N;
	static boolean[] visited;
	static int[] arr;
	static int max;
	public static void dfs(int depth, int index, int sum) {
		// 탈출 조건은 depth가 N-1번 까지
		if (depth == N-1) {
			if (sum > max)
				max = sum;
			return;
		}
		visited[index] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(depth+1, i, sum + Math.abs(arr[index] - arr[i]));
				visited[i] = false;
			}
		}
		visited[index] = false;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			dfs(0,i,0);
		}
		System.out.println(max);
	}
}
