import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int idx = queue.poll();
                    for (int j = 0; j < computers[idx].length; j++) {
                        if (!visited[j] && computers[idx][j] == 1) {
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}