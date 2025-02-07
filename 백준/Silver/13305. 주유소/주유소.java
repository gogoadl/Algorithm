import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] node = new long[N];
        long[] edge = new long[N-1];
        long[][]arr = new long[N-1][N-1];
        long cost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            edge[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }
        long minCost = node[0];
        for (int i = 0; i < N-1; i++) {
            if (node[i] < minCost) {
                minCost = node[i];
            }
            cost += minCost * edge[i];
        }
        System.out.println(cost);
    }
}
