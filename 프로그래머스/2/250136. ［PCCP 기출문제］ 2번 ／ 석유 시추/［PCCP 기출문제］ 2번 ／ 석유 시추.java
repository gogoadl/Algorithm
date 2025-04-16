import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
     static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int max = -1;
    public int solution(int[][] land) {
        int[][] visited = new int[land.length][land[0].length];
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> points;
        int number = 1;
        for (int i = 0; i < land[0].length; i++) {
            points = new ArrayList<>();
            int count = 0;
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1 && visited[j][i] == 0) {
                    queue.add(new int[]{j,i});
                    points.add(new int[]{j,i});
                    visited[j][i] = number;
                    count++;
                    while (!queue.isEmpty()) {
                        int[] value = queue.poll();

                        for (int k = 0; k < dx.length; k++) {
                            int ny = value[0] + dy[k];
                            int nx = value[1] + dx[k];

                            if (ny < 0 || nx < 0 || ny >= land.length || nx >= land[0].length) continue;
                            if (visited[ny][nx] != 0) continue;
                            if (land[ny][nx] == 0) continue;
                            visited[ny][nx] = number;
                            count++;
                            int[] p = new int[]{ny,nx};
                            queue.add(p);
                            points.add(p);
                        }
                    }

                    for (int [] point: points) {
                        land[point[0]][point[1]] = count;
                    }
                    points.clear();
                    count = 0;
                    number++;
                }
            }
        }

        for (int i = 0; i < land[0].length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] != 0 && !list.contains(visited[j][i])) {
                    count += land[j][i];
                    list.add(visited[j][i]);
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

}