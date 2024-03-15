class Solution {
     static int EMPTY_SPACE = 0;
    static int RED_START = 1;
    static int BLUE_START = 2;
    static int RED_END = 3;
    static int BLUE_END = 4;
    static int WALL = 5;
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static int[] originRedPos = new int[2];
    static int[] originBluePos = new int[2];
    static int[] redEndPos = new int[2];
    static int[] blueEndPos = new int[2];
    static int count = Integer.MAX_VALUE;
    static boolean[][] redVisited;
    static boolean[][] blueVisited;
    static int[][] arr;
    public int solution(int[][] maze) {
        int answer = 0;

        arr = maze;
        // red 먼저 시작, blue 먼저 시작
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == RED_START) {
                    originRedPos[0] = i;
                    originRedPos[1] = j;
                } else if (maze[i][j] == BLUE_START) {
                    originBluePos[0] = i;
                    originBluePos[1] = j;
                } else if (maze[i][j] == RED_END) {
                    redEndPos[0] = i;
                    redEndPos[1] = j;
                } else if (maze[i][j] == BLUE_END) {
                    blueEndPos[0] = i;
                    blueEndPos[1] = j;
                }
            }
        }
        redVisited = new boolean[maze.length][maze[0].length];
        blueVisited = new boolean[maze.length][maze[0].length];
        redVisited[originRedPos[0]][originRedPos[1]] = true;
        blueVisited[originBluePos[0]][originBluePos[1]] = true;
        dfs(originRedPos[1], originRedPos[0], originBluePos[1], originBluePos[0], 0);
        if (count == Integer.MAX_VALUE) count = 0;
        return count;
    }

 
        public static void dfs(int redX, int redY, int blueX, int blueY, int round) {
        if (redY == redEndPos[0] && redX == redEndPos[1] && blueY == blueEndPos[0] && blueX == blueEndPos[1]) {
            count = Math.min(round, count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int[] newRedPos = new int[2];
                int[] newBluePos = new int[2];
                boolean skipRedCheck = false;
                boolean skipBlueCheck = false;
                // 새로운 이동 지점 선택
                if (redY == redEndPos[0] && redX == redEndPos[1]) {
                    newRedPos[0] = redY;
                    newRedPos[1] = redX;
                    skipRedCheck = true;
                } else {
                    newRedPos[0] = redY + dy[i];
                    newRedPos[1] = redX + dx[i];
                }
                if (blueY == blueEndPos[0] && blueX == blueEndPos[1]) {
                    newBluePos[0] = blueY;
                    newBluePos[1] = blueX;
                    skipBlueCheck = true;
                } else {
                    newBluePos[0] = blueY + dy[j];
                    newBluePos[1] = blueX + dx[j];
                }

                 // 이동 가능 여부 체크
                if (newRedPos[0] < 0 || newRedPos[1] < 0 || newBluePos[0] < 0 || newBluePos[1] < 0
                || newRedPos[0] >= arr.length || newRedPos[1] >= arr[0].length || newBluePos[0] >= arr.length || newBluePos[1] >= arr[0].length) continue;

                if (arr[newRedPos[0]][newRedPos[1]] == WALL || arr[newBluePos[0]][newBluePos[1]] == WALL) continue;

                // 이미 도착한 경우 움직이지 않게되므로 중복체크 하지 않음
                if (!skipRedCheck) {
                    if (redVisited[newRedPos[0]][newRedPos[1]]) continue;
                }
                if (!skipBlueCheck) {
                    if (blueVisited[newBluePos[0]][newBluePos[1]]) continue;
                }

                // 수레가 같은 곳으로 이동하려는 경우
                if (newRedPos[0] == newBluePos[0] && newRedPos[1] == newBluePos[1]) continue;
                if (newRedPos[0] == blueY && newRedPos[1] == blueX && newBluePos[0] == redY && newBluePos[1] == redX) continue;
                // 이동 및 round 추가
                redVisited[newRedPos[0]][newRedPos[1]] = true;
                blueVisited[newBluePos[0]][newBluePos[1]] = true;
                dfs(newRedPos[1], newRedPos[0], newBluePos[1], newBluePos[0], round + 1);
                redVisited[newRedPos[0]][newRedPos[1]] = false;
                blueVisited[newBluePos[0]][newBluePos[1]] = false;
            }
        }
    }
}