import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String, Integer> positionMap = new HashMap<>();

        for (int[] route : routes) {
            int time = 0;
            int[] start = points[route[0] - 1];
            int r = start[0];
            int c = start[1];
            positionMap.merge(time + "," + r + "," + c, 1, Integer::sum);

            for (int i = 1; i < route.length; i++) {
                int[] end = points[route[i] - 1];
                int targetR = end[0];
                int targetC = end[1];

                while (r != targetR || c != targetC) {
                    if (r != targetR) {
                        r += (r < targetR) ? 1 : -1;
                    } else if (c != targetC) {
                        c += (c < targetC) ? 1 : -1;
                    }
                    time++;
                    positionMap.merge(time + "," + r + "," + c, 1, Integer::sum);
                }
            }
        }

        for (int count : positionMap.values()) {
            if (count > 1) {
                answer++;
            }
        }

        return answer;
    }
}