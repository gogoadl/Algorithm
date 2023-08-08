import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14888{
	static int N;
	static boolean[] visited;
	static int[] arr;
	static int max = -1000000000;
	static int min = 1000000000;
	public static void dfs(int[] arr2,int depth, int index, int result, int total) {
		// 탈출 조건은 depth가 N-1번 까지
		// 연산자를 뽑는 경우도 다름
		if (depth == N-1 || total == 0) {
			if (result > max)
				max = result;
			if (result < min)
				min = result;
			return;
		}
		for (int j = 0; j < 4; j++) {
			if (arr2[j] > 0) { // 해당 연산자 사용가능
				arr2[j]--;
				if (j == 0) { // +
					dfs(arr2, depth+1, index+1, result + arr[index+1], total - 1);
				} else if (j == 1) { // -
					dfs(arr2, depth+1, index+1, result - arr[index+1], total - 1);
				} else if (j == 2) { // *
					dfs(arr2, depth+1, index+1, result * arr[index+1], total - 1);
				} else { // /
					dfs(arr2, depth+1, index+1, result / arr[index+1], total - 1);
				} 
				arr2[j]++;
			}
		}	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		int[] arr2 = new int[4];
		visited = new boolean[N+1];
		int total = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
			total+=arr2[i];
		}
		
		dfs(arr2,0,1,arr[1],total);
		
		System.out.println(max);
		System.out.println(min);
	}
}
