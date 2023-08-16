import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i])
                max = arr[i];
        }
        int start = 0;
        long sum;
        int mid = 0;
        int res = 0;
        while (start<=max) {
            sum = 0;
            mid = (start + max) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid)
                    sum += arr[i] - mid;
            }
            if (sum >= M) {
                start = mid+1;
                res = mid;
            } else {
                max = mid-1;
            }
        }
        System.out.println(res);
    }
}
