import java.util.Scanner;

public class BaekJoon15650 {
	static StringBuilder sb = new StringBuilder();
	static int[] result;
	static int M;
	static int N;

	private static void combi(int cnt, int start) {
		if (cnt == M) {
			for (int i : result) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			result[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = new int[M];
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		combi(0, 1);

		System.out.println(sb);
	}
}
