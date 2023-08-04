import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int testCaseCount = 10;
		for (int i = 1; i <= testCaseCount; i++) {
			int length = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < length; j++) {
				char target = input[j];
				if (target == '{' 
				 || target == '(' 
				 || target == '<' 
				 || target == '[') {
					stack.add(target);
				} else {
					char c = stack.peek();
					
					if ((c == '{' && input[j] == '}') 
					|| (c == '(' && input[j] == ')')
					|| (c == '<' && input[j] == '>')
					|| (c == '[' && input[j] == ']')) 
						stack.pop();
					else // stack 최상단 값과 다를 경우 불완전한 괄호
						break;
				}
			}
			if (stack.size() == 0) 
				sb.append(String.format("#%d 1\n", i));
			else
				sb.append(String.format("#%d 0\n", i));
			stack.clear();
		}
		System.out.println(sb);
	}
}
