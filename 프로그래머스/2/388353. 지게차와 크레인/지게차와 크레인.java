import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    public int solution(String[] storage, String[] requests) {
        int answer = storage.length * storage[0].length();
        String[][] map = new String[storage.length + 2][storage[0].length() + 2];

        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> targets = new ArrayList<>();
        ArrayList<String> typeList = new ArrayList<>();
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[0].length(); j++) {
                map[i+1][j+1] = String.valueOf(storage[i].charAt(j));
                if (!typeList.contains(map[i+1][j+1]))
                    typeList.add(map[i+1][j+1]);
            }
        }
        for (int i = 0; i < requests.length; i++) {
            boolean[][] visited = new boolean[map.length][map[0].length];
            queue.add(new int[]{0,0});
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                int[] check = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int ny = check[0] + dy[j];
                    int nx = check[1] + dx[j];

                    if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                    if (visited[ny][nx]) continue;
                    if (map[ny][nx] != null) continue;
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny,nx});
                }
            }
            String type = String.valueOf(requests[i].charAt(0));
            if (!typeList.contains(type)) continue;
            if (requests[i].length() == 1) {
                for (int j = 1; j < map.length-1; j++) {
                    for (int k = 1; k < map[0].length-1; k++) {
                        if (map[j][k] != null && map[j][k].equals(requests[i])) {
                            boolean target = false;
                            for (int l = 0; l < dx.length; l++) {
                                int ny = j + dy[l];
                                int nx = k + dx[l];
                                if (map[ny][nx] == null && visited[ny][nx]) {
                                    target = true;
                                    break;
                                }
                            }
                            if (target) {
                                targets.add(new int[]{j,k});
                            }
                        }
                    }
                }
            } else {
                for (int j = 1; j < map.length-1; j++) {
                    for (int k = 1; k < map[0].length-1; k++) {
                        if (map[j][k] != null && map[j][k].equals(type)) {
                            targets.add(new int[]{j,k});
                        }
                    }
                }
            }
            for (int[] target: targets) {
                map[target[0]][target[1]] = null;
                answer--;
            }
            targets.clear();

        }
        return answer;
    }

}