import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void perm(int[] arr, int[] target, int idx, int arrIdx) {
        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(target[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = arrIdx; i < arr.length; i++) {
                target[idx] = arr[i];
                perm(arr, target, idx + 1, i + 1);

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            int[] arr = new int[N];
            int[] target = new int[6];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            perm(arr, target, 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
