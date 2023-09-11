import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int min = -1;
        for (int i = 0; i < targets.length; i++) {
            int l = targets[i][0];
            int r = targets[i][1];
            if (l  >= min) {
                min = r;
                answer++;
            }
        }

        return answer;
    }
}
