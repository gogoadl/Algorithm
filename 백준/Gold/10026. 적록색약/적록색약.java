import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int N;
    static char[][] RGBArr;
    static char[][] RBArr;
    static boolean[][] RGBVisited;
    static boolean[][] RBVisited;
    static int RGBCount;
    static int RBCount;
    static void RGBDfs(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
            if (RGBVisited[cx][cy]) continue;
            if (RGBArr[cx][cy] != RGBArr[x][y]) continue;
            RGBVisited[cx][cy] = true;
            RGBDfs(cx, cy);
        }
    }

    static void RBDfs(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
            if (RBVisited[cx][cy]) continue;
            if (RBArr[cx][cy] != RBArr[x][y]) continue;
            RBVisited[cx][cy] = true;
            RBDfs(cx, cy);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        RGBArr = new char[N][N];
        RBArr = new char[N][N];
        RGBVisited = new boolean[N][N];
        RBVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                RGBArr[i][j] = c;
                RBArr[i][j] = (c == 'R' || c == 'G') ? 'R' : 'B';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!RGBVisited[i][j]) {
                    RGBDfs(i,j);
                    RGBCount++;
                }
                if (!RBVisited[i][j]) {
                    RBDfs(i,j);
                    RBCount++;
                }
            }

        }

        System.out.println(String.format("%d %d", RGBCount, RBCount));

    }
}
