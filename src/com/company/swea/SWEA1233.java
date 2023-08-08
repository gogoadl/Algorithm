import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1233 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCaseCount = 10;
		int answer;
		String [] tree;

		for (int i = 1; i <= testCaseCount; i++) {
			int N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			boolean b = false;
			for (int j = 1; j <= N; j++) {
				String[] input = br.readLine().split(" ");
				tree[j] = input[1];
			}
			for (int j = 1; j < tree.length; j++) {	
				if (j*2 == N) { // 자식이 1개만 있는 경우, 부모노드가 연산자를 가진다고 해도 연산을 할 수 없음.
					b = true;
				}
				if (j*2+1 <= N) { // 부모노드 (자식이 2개 다 있는경우)
					if (!tree[j].equals("*") &&
						!tree[j].equals("/") &&
						!tree[j].equals("+") &&
						!tree[j].equals("-")) {
						b = true;
					}	
				} else { // 자식노드
					if (tree[j].equals("*") &&
						tree[j].equals("/") &&
						tree[j].equals("+") &&
						tree[j].equals("-")) {
						b = true;	
					}	
				}
			}
			if (b) answer = 0;
			else answer = 1;
			sb.append(String.format("#%d %d\n", i, answer));
		}
		System.out.println(sb);
	}
//	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int testCaseCount = 10;
//		int answer;
//		boolean b;
//		for (int i = 1; i <= testCaseCount; i++) {
//			b = false;
//			int N = Integer.parseInt(br.readLine());
//			for (int j = 0; j < N; j++) {
//				String[] input = br.readLine().split(" ");
//				if (b)
//					continue;
//				if (input.length == 4) { // 하나라도 1번 인덱스에 숫자가 나오면 안됨
//					if (!input[1].equals("*") &&
//						!input[1].equals("/") &&
//						!input[1].equals("+") &&
//						!input[1].equals("-")) {
//						b = true;
//					}	
//				}
//				else { // 하나라도 1번 인덱스에 연산자가 나오면 안됨
//					if (input[1].equals("*") &&
//						input[1].equals("/") &&
//						input[1].equals("+") &&
//						input[1].equals("-")) {
//							b = true;
//					}
//				}
//			}
//			if (b) answer = 0;
//			else answer = 1;
//			sb.append(String.format("#%d %d\n", i, answer));
//		}
//		System.out.println(sb);
//	}
}
