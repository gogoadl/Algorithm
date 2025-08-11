class Solution {
    public int solution(int[][] info, int n, int m) {
        // dp[a][b] == true  <=>  A합 a, B합 b를 만들 수 있다 (a < n, b < m)
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;

        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];

            boolean[][] next = new boolean[n][m];
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!dp[a][b]) continue;

                    // 이 물건을 A에게
                    int na = a + aCost;
                    if (na < n) {
                        next[na][b] = true;
                    }

                    // 이 물건을 B에게
                    int nb = b + bCost;
                    if (nb < m) {
                        next[a][nb] = true;
                    }
                }
            }
            dp = next;
        }

        // A 합을 최소로 만드는 상태 찾기
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[a][b]) return a;
            }
        }
        return -1;
    }
}
