import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int current = 0;
        int start = 0;
        for (int i = 0; i < K; i++) {
            current += array[i];
        }
        int max = current;
        for (int i = K; i < N; i++) {
            current -= array[start++];
            current += array[i];
            max = Math.max(current, max);
        }
        System.out.println(max);
    }
}