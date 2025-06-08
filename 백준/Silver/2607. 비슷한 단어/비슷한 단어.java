import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String base = br.readLine().trim();
        int baseLen = base.length();

        int[] baseCnt = new int[26];
        for (char c : base.toCharArray()) baseCnt[c - 'A']++;

        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            String s = br.readLine().trim();
            int sl = s.length();
            if (Math.abs(baseLen - sl) > 1) continue;

            int[] cnt = baseCnt.clone();
            int same = 0;
            for (char c : s.toCharArray()) {
                if (cnt[c - 'A'] > 0) {
                    cnt[c - 'A']--;
                    same++;
                }
            }

            if (baseLen == sl) {
                if (same == baseLen || same == baseLen - 1) ans++;
            } else if (baseLen - 1 == sl) {
                if (same == sl) ans++;
            } else if (baseLen + 1 == sl) {
                if (same == baseLen) ans++;
            }
        }
        System.out.println(ans);
    }
}
