import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int width = 0;
        int height = 0;
        characterX = characterX * 2; // x 좌표 2배
        characterY = characterY * 2; // y 좌표 2배
        itemX = itemX * 2; // x 좌표 2배
        itemY = itemY * 2; // y 좌표 2배
        for (int i = 0; i < rectangle.length; i++) {
            rectangle[i][0] *= 2; // x 좌표 2배
            rectangle[i][1] *= 2; // y 좌표 2배
            rectangle[i][2] *= 2; // x 좌표 2배
            rectangle[i][3] *= 2; // y 좌표 2배
        }
        for (int i = 0; i < rectangle.length; i++) {
            int[] r = rectangle[i];
            width = Math.max(width, r[2]);
            height = Math.max(height, r[3]);
        }
        int[][] map = new int[width + 1][height + 1];
        boolean[][] visited = new boolean[width + 1][height + 1];

        for (int i = 0; i < rectangle.length; i++) { // rectangle 내부 1로 변경
            int[] r = rectangle[i];
            for (int j = r[0]; j <= r[2]; j++) {
                for (int k = r[1]; k <= r[3]; k++) {
                    map[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < rectangle.length; i++) { // rectangle 내부 1로 변경
            int[] r = rectangle[i];
            for (int j = r[0]; j <= r[2]; j++) {
                for (int k = r[1]; k <= r[3]; k++) {
                    if (j - 1 < 0 || j >= width || k - 1 < 0 || k >= height) {
                        continue; // 범위 벗어남
                    }
                    if (map[j-1][k-1] == 1 &&
                            map[j-1][k+1] == 1 &&
                            map[j+1][k-1] == 1 &&
                            map[j+1][k+1] == 1 &&
                            map[j-1][k] == 1 &&
                            map[j+1][k] == 1 &&
                            map[j][k-1] == 1 &&
                            map[j][k+1] == 1) {
                        visited[j][k] = true; // 내부는 방문 처리
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            if (x == itemX && y == itemY) {
                answer = distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= width + 1 || nextY >= height + 1) {
                    continue; // 범위 벗어남
                }
                if (map[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue; // 내부가 아니거나 방문한 곳
                }

                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY, distance + 1});
            }
        }

        return answer / 2;
    }
}