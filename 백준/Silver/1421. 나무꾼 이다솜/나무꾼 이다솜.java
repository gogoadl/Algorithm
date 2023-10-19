import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long arr[];
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int W = Integer.parseInt(input[2]);

        int[] timbers = new int[N];
        for (int i = 0; i < N; i++) {
            timbers[i] = Integer.parseInt(br.readLine());
            max = Math.max(timbers[i], max);
        }
        arr = new long[max+1];
        int divideCount;
        int modCount;
        long sum;
        int money;
        for (int i = 1; i <= max; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                if (timbers[j] >= i) {
                    divideCount = timbers[j] / i;
                    modCount = timbers[j] % i;

                    if (modCount > 0) { // 자르고 나머지가 있을 경우
                        money = (timbers[j]-modCount) * W - divideCount * C;
                    } else {
                        money = timbers[j] * W - (divideCount-1) * C;
                    }
                    if (money > 0) sum += money;
                }

            }
            arr[i] = sum;
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
    }
}