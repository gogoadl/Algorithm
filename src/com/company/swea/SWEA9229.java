import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {
	static int count = 2;
	static int N;
	static int M;
	static int max = -1;
	public static void combi(int[] arr, int[] result, int depth, int index) {
		result[depth] = arr[index];
		if (depth == count-1) {
			int sum = 0;
			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}
			if (sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		}

		for (int i = index+1; i < N; i++) {
			combi(arr, result, depth+1, i);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int testCaseCount = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= testCaseCount; i++) {
			max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			int[] result = new int[2];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < arr.length; j++) {
				combi(arr, result, 0, j);
			}
			sb.append(String.format("#%d %d\n", i, max));
		}
		System.out.println(sb);
	}
}
