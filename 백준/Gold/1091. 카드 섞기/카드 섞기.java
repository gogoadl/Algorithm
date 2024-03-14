import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] P;
    static int[] S;
    static int[] origin;
    static int[] tmp;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        P = new int[N];
        origin = new int[N];
        tmp = new int[N];
        S = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            origin[i] = P[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        while (true) {
            if (cnt > 0 && isEqual()) {
                cnt = -1;
                break;
            }
            if (isStop()) {
                break;
            }
            swap();
            cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean isEqual() {
        for (int i = 0; i < N; i++) {
            if (tmp[i] != origin[i]) return false;
        }
        return true;
    }
    public static boolean isStop() {
        for (int i = 0; i < N; i++) {
            if (P[i] != i % 3) return false;
        }
        return true;
    }
    public static void swap() {
        for (int i = 0; i < N; i++) {
            tmp[S[i]] = P[i];
        }
        P = Arrays.copyOf(tmp, tmp.length);
    }
}
