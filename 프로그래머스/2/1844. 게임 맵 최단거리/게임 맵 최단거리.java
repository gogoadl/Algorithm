import java.util.LinkedList;
import java.util.Queue;

class Solution {
  static int[] dy = new int[] {-1,1,0,0};
    static int[] dx = new int[] {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        map = maps;

        visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        bfs();
        if (min == Integer.MAX_VALUE) min = -1;
        return min;
    }
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        while (!queue.isEmpty()) {
            int[] val = queue.poll();

            if (val[0] == map.length - 1  && val[1] == map[0].length - 1) {
                min = Math.min(val[2], min);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = val[0] + dy[i];
                int nx = val[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny,nx,val[2]+1});
            }
        }

    }
}