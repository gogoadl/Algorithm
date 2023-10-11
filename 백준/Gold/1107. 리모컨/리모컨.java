import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] available = new boolean[10];
    static int input;
    static long count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = Integer.parseInt(br.readLine());

        Arrays.fill(available, true);

        int n = Integer.parseInt(br.readLine());
        if (n > 0) {
            String[] idxs = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                available[Integer.parseInt(idxs[i])] = false;
            }
        }
        
        if (input == 100) {
            System.out.println(0);
            return;
        }

        count = Math.abs(input - 100);
        
        dfs(0,0);
        
        System.out.println(count);
    }
    public static void dfs(int idx, int click) {
        for (int i = 0; i < 10; i++) {
            if (available[i]) {
                int val = click * 10 + i;
                int cnt = Math.abs(input - val) + String.valueOf(val).length();
                count = Math.min(count, cnt);

                if (idx < 6) {
                    dfs(idx + 1, val);
                }
            }
        }
    }
}