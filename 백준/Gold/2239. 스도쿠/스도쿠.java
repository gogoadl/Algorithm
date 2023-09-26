import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    static int[][] arr = new int[9][9];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < 9; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = c[j] - '0';
            }
        }
        dfs(0);

        for (int[] a : arr) {
            for (int b : a) {
                sb.append(b);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int d) {
        if (d == 81) {
            flag = true;
            return;
        }

        int r = d / 9;
        int c = d % 9;

        if (arr[r][c] != 0)
            dfs(d + 1);
        else {
            for (int i = 1; i < 10; i++) {
                if (!isValid(r, c, i)) continue;
                arr[r][c] = i;
                dfs(d + 1);

                if (flag) return;
                arr[r][c] = 0;
            }
        }
    }
    private static boolean isValid(int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][c] == n || arr[r][i] == n) return false;
        }

        int sr = r / 3 * 3;
        int sc = c - c % 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (arr[i][j] == n)
                    return false;
            }
        }
        return true;
    }
}