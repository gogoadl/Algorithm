import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int aCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aCnt++;
            }
        }
        s += s;
        int cnt = Integer.MAX_VALUE;
        int idx = 0;
        while (idx <= (s.length() / 2)) {
            int bCnt = 0;
            for (int i = idx; i < idx+aCnt; i++) {
                if (s.charAt(i) == 'b') bCnt++;
            }
            cnt = Math.min(cnt, bCnt);
            idx++;
        }
        System.out.println(cnt);
    }


}
