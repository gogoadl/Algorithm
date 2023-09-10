import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;

    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            M += arr[i];
        }
        for (int i = 1; i <= N; i++) {
            combi(0, i, 0);
        }
        System.out.println(M-set.size());

    }
    public static void combi(int idx, int r, int sum) {
        if (r == 0)  {
            set.add(sum);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i, r-1,sum + arr[i]);
                visited[i] = false;
            }

        }
    }
}