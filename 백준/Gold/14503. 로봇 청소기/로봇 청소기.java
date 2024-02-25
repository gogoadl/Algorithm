import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,1,-1};

    static int NOT_CLEANED = 0;
    static int WALL = 1;
    static int CLEANED = 2;
    static int n;
    static int m;
    static int[][] arr;

    static int r;
    static int c;
    static int d;
    static int count;
    static boolean state = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
            }
        }
        while (state) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            cleanCurrent();

            if (checkCleaned() == 4) { // 2.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                checkBack();
            }
            else if (checkNotCleaned() > 0) { // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                rotate();
                goToForward();
            }
        }
        System.out.println(count);

    }
    public static void cleanCurrent() {
        if (arr[r][c] == NOT_CLEANED) {
            arr[r][c] = CLEANED;
            count++;
        }
    }
    public static void rotate() {
        if (d == 0) {
            d = 3;
        } else if (d == 1) {
            d = 0;
        } else if (d == 2) {
            d = 1;
        } else if (d == 3) {
            d = 2;
        }
    }
    public static void checkBack() {
        if (d == 0) { // 북
            if (arr[r+1][c] == WALL) {
                state = false;
            } else {
                r = r + 1;
            }
        } else if (d == 1) { // 동
            if (arr[r][c-1] == WALL) {
                state = false;
            } else {
                c = c - 1;
            }
        } else if (d == 2) { // 남
            if (arr[r-1][c] == WALL) {
                state = false;
            } else {
                r = r - 1;
            }
        } else if (d == 3) { // 서
            if (arr[r][c+1] == WALL) {
                state = false;
            } else {
                c = c + 1;
            }
        }
    }
    public static int checkNotCleaned() {
        int notCleanedCount = 0;
        if (arr[r+1][c] != CLEANED) {
            notCleanedCount++;
        }
        if (arr[r-1][c] != CLEANED) {
            notCleanedCount++;
        }
        if (arr[r][c+1] != CLEANED) {
            notCleanedCount++;
        }
        if (arr[r][c-1] != CLEANED) {
            notCleanedCount++;
        }
        return notCleanedCount;
    }
    public static void goToForward() {
        if (d == 0) { // 북
            if (arr[r-1][c] == NOT_CLEANED) {
                r = r - 1;
            }
        } else if (d == 1) { // 동
            if (arr[r][c+1] == NOT_CLEANED) {
                c = c + 1;
            }
        } else if (d == 2) { // 남
            if (arr[r+1][c] == NOT_CLEANED) {
                r = r + 1;
            }
        } else if (d == 3) { // 서
            if (arr[r][c-1] == NOT_CLEANED) {
                c = c - 1;
            }
        }
    }
    public static int checkCleaned() {
        int cleanedCount = 0;
        if (arr[r+1][c] != NOT_CLEANED) {
            cleanedCount++;
        }
        if (arr[r-1][c] != NOT_CLEANED) {
            cleanedCount++;
        }
        if (arr[r][c-1] != NOT_CLEANED) {
            cleanedCount++;
        }
        if (arr[r][c+1] != NOT_CLEANED) {
            cleanedCount++;
        }
        return cleanedCount;
    }
}