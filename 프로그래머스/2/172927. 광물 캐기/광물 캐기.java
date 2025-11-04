class Solution {
    int minScore = Integer.MAX_VALUE;
    void dfs(String[] minerals, int[] picks, int index, int score) {
        if (index >= minerals.length || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            minScore = Math.min(minScore, score);
            return;
        }
        for (int tool = 0; tool < 3; tool++) {
            if (picks[tool] == 0) continue; // 곡괭이 없으면 skip

            int fatigue = 0;
            int limit = Math.min(5, minerals.length - index);

            // 이번 구간 5개 채굴
            for (int i = 0; i < limit; i++) {
                String m = minerals[index + i];
                if (m.equals("diamond")) {
                    fatigue += (tool == 0 ? 1 : tool == 1 ? 5 : 25);
                } else if (m.equals("iron")) {
                    fatigue += (tool == 0 ? 1 : tool == 1 ? 1 : 5);
                } else {
                    fatigue += 1;
                }
            }

            picks[tool]--;
            dfs(minerals, picks, index + limit, score + fatigue);
            picks[tool]++; // 복원
        }
    }
    public int solution(int[] picks, String[] minerals) {
        dfs(minerals, picks, 0, 0);
        return minScore;
    }
}