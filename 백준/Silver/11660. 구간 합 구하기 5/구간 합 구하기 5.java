import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[][] arr = new int[N][N];
		int[][] sum = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i-1][j-1] = Integer.parseInt(st.nextToken());
				sum[i][j] = arr[i-1][j-1] + sum[i][j-1];
			}
		}
		int x1, x2, y1, y2;
		int answer;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			answer = 0;
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			
			for (int j = x1; j <= x2; j++) {
				answer += sum[j][y2] - sum[j][y1-1];
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}