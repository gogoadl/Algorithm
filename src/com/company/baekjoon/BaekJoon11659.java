import java.util.Scanner;

public class BaekJoon11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] array = new int[N];
		int[] sum = new int[N+1];
		for (int i = 1; i <= N; i++) {
			array[i-1] = sc.nextInt();
			sum[i] = sum[i-1] + array[i-1];
		}
		int start = 0;
		int end = 0;
		for (int i = 0; i < M; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			
			sb.append(sum[end]-sum[start-1]+"\n");	
		}
		System.out.println(sb);
	}
}
