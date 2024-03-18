import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb.append(br.readLine());

        System.out.println(process(0));


    }
    public static int process(int start) {
        int len = 0;
        for (int i = start; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.add(sb.charAt(i));
                len += (sb.charAt(i-1)-48) * process(i+1)-1;
                i = idx;
            } else if (sb.charAt(i) == ')'){
                while (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                    idx = i;
                    return len;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
