import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = br.readLine().split("");
        dfs(0, Integer.parseInt(input[0]));
        System.out.println(answer);
    }
    public static void dfs(int idx, int sum) {
        if (idx == input.length-1) {
            answer = Math.max(answer, sum);
            return;
        }
        // 괄호 안 친 경우 지금까지의 합과 나를 계산한 결과를 다음 숫자 (index는 +2)에 넘긴다
        dfs(idx+2, calc(sum, input[idx+1], Integer.parseInt(input[idx+2])));

        // 오른쪽에 괄호 친 경우
        if (idx + 4 <= input.length-1) {
            // 옆 괄호 먼저 계산
            int right = calc(Integer.parseInt(input[idx+2]), input[idx+3], Integer.parseInt(input[idx+4]));
            // 지금까지 결과와 합하기
            int left = calc(sum, input[idx+1], right);
            dfs(idx+4, left);
        }

    }
    public static int calc(int a, String exp, int b) {
        if (exp.equals("+")) return a+b;
        else if (exp.equals("-")) return a-b;
        else if (exp.equals("*")) return a*b;
        else return a/b;
    }
}