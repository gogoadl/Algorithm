import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int minMove = Integer.MAX_VALUE;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public int solution(String[] board) {
        String[][] b = new String[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                b[i][j] = String.valueOf(board[i].charAt(j));
                if (b[i][j].equals("R")) {
                    queue.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] robot = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int ny = robot[0] + dy[i];
                int nx = robot[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= b.length || nx >= b[0].length) continue;
                if (b[ny][nx].equals("D")) continue;

                while (true) {
                    int nextY = ny + dy[i];
                    int nextX = nx + dx[i];

                    if (nextY < 0 || nextX < 0 || nextY >= b.length || nextX >= b[0].length) break;
                    if (b[nextY][nextX].equals("D")) break;

                    ny = nextY;
                    nx = nextX;
                }

                if (b[ny][nx].equals("G")) {
                    minMove = Math.min(minMove, robot[2] + 1);
                    continue;
                }

                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.add(new int[]{ny,nx,robot[2]+1});
            }
        }
        if (minMove == Integer.MAX_VALUE) minMove = -1;

        return minMove;
    }

}
