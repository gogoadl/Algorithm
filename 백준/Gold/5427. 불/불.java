import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int WALL = -2;
    static final int FIRE = -1;
    static final int EMPTY_SPACE = 0;
    static final int PERSON = 1;

    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static int[][] graph;
    static Queue<int[]> fires = new LinkedList<>();
    static Queue<int[]> person = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] size = br.readLine().split(" ");
            int w = Integer.parseInt(size[0]);
            int h = Integer.parseInt(size[1]);
            graph = new int[h][w];
            fires.clear();
            person.clear();
            int answer = Integer.MAX_VALUE;
            int time = 0;
            for (int j = 0; j < h; j++) {
                char[] s = br.readLine().toCharArray();
                for (int k = 0; k < s.length; k++) {
                    if (s[k] == '#') {
                        graph[j][k] = WALL;
                    } else if (s[k] == '.') {
                        graph[j][k] = EMPTY_SPACE;
                    } else if (s[k] == '*') {
                        graph[j][k] = FIRE;
                        fires.add(new int[] {j,k,0});
                    } else {
                        graph[j][k] = PERSON;
                        person.add(new int[]{j,k,0});
                    }
                }
            }
            // 불 먼저 움직이고 사람 움직이기
            while (!person.isEmpty()) {
                while (fires.peek() != null && fires.peek()[2] == time ) {
                    int[] fire = fires.poll();
                    for (int j = 0; j < dx.length; j++) {
                        int cy = fire[0] + dy[j];
                        int cx = fire[1] + dx[j];

                        if (cx < 0 || cy < 0 || cx >= w || cy >= h) continue;
                        if (graph[cy][cx] == FIRE) continue;
                        if (graph[cy][cx] != WALL) {
                            graph[cy][cx] = FIRE;
                            fires.add(new int[]{cy, cx, fire[2] + 1});
                        }
                    }
                }

                while (person.peek() != null && person.peek()[2] == time) {
                    int[] p = person.poll();
                    for (int j = 0; j < dx.length; j++) {
                        int cy = p[0] + dy[j];
                        int cx = p[1] + dx[j];

                        if (cx < 0 || cy < 0 || cx >= w || cy >= h) {
                            answer = Math.min(answer,p[2]);
                            break;
                        }
                        if (graph[cy][cx] == EMPTY_SPACE) {
                            graph[cy][cx] = PERSON;
                            person.add(new int[]{cy, cx, p[2] + 1});
                        }
                    }
                }
                time++;
            }
            if (answer == Integer.MAX_VALUE)
                sb.append("IMPOSSIBLE").append("\n");
            else
                sb.append(answer+1).append("\n");
        }
        System.out.println(sb);
    }
}