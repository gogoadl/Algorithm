import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int[] arr, int[] target, boolean[] visited, int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                if (i == N - 1) {
                    sb.append(target[i] + "\n");
                } else {
                    sb.append(target[i] + " ");
                }

            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                target[depth] = arr[i];
                dfs(arr, target, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] target = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        dfs(arr, target, visited, 0);
        System.out.println(sb);
    }
}
