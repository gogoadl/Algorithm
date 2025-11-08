import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        map.put(0,1);

        long answer = 0;
        for (int j = 1; j <= N; j++) {
            answer += map.getOrDefault(sum[j] - K, 0);
            map.put(sum[j], map.getOrDefault(sum[j], 0) + 1);
        }

        System.out.println(answer);
    }
}
