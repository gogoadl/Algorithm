
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		int[] result = new int[N];
		
		Stack<int[]> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		
		int num;
		for (int i = N-1; i >= 0; i--) { // N-2 인덱스부터 0까지 
			num = arr[i][0];
			while(!stack.isEmpty()) { // 스택에 값이 있다면 현재 인덱스의 값과 스택의 top 비교 
				if (stack.peek()[0] < num) { // 레이저가 맞는다면 인덱스 저장
					result[stack.pop()[1]] = i+1;
				} else break; // 레이저가 안맞으면 탈출 후 스택에 값 추가
				
			}
			stack.push(arr[i]);
		}
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}

// 5
// 6 9 5 7 4
// 1 2 3 4 5
