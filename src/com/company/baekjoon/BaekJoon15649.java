import java.util.Scanner;

public class BaekJoon15649 {
	static StringBuilder sb = new StringBuilder();
	static StringBuilder result = new StringBuilder();
	public static void dfs(int[] arr, boolean[] visited, int depth, int index, int d) {
		visited[index] = true;
		sb.append(arr[index]+" ");
		if (depth == 1)  {
			result.append(sb + "\n");
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(arr, visited, depth-1, i, d);
				visited[i] = false;
				sb.delete(sb.length()-2, sb.length());
			}
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[] arr = new int[a];
		boolean[] visited = new boolean[a];
		for (int i = 0; i < a; i++) {
			arr[i] = i+1;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(arr, visited, b, i, b);
				visited[i] = false;
				sb.setLength(0);
			}
		}
		System.out.println(result);
	}
}
