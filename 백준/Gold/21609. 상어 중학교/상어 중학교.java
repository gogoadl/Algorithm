import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = 0;

    static int cnt = 0; // 블록 갯수
    static int rainbowCnt = 0; // 무지개 블록 갯수
    static int targetI = 0; // 행 번호
    static int targetJ = 0; // 열 번호
    static int target = 0;
    static int EMPTY_BLOCK = -2;
    static ArrayList<int[]> targetList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            cnt = 0; // 블록 갯수
            rainbowCnt = 0; // 무지개 블록 갯수
            targetI = 0; // 행 갯수
            targetJ = 0; // 열 갯수
            target = 0;
            targetList.clear();
            // BFS로 가장 큰 블록 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] != -1 && arr[i][j] != 0 && arr[i][j] != EMPTY_BLOCK) {
                        visited[i][j] = true;
                        bfs(i,j);

                    }
                }
            }

            if (cnt < 2) break;

            answer += cnt*cnt;

            // 가장 큰 블록 없애기
            setBlockEmpty();

            // 블록에 중력 적용하기
            gravity();

            // 90도 반시계 방향 회전
            rotation();

            // 블록에 중력 적용하기
            gravity();
        }
        System.out.println(answer);
    }
    public static void bfs(int i, int j) {
        int cCnt = 1; // 블록 갯수
        int cRainbowCnt = 0; // 무지개 블록 갯수
        int cTargetI = i; // 행 번호
        int cTargetJ = j; // 열 번호
        int cTarget = arr[i][j];
        ArrayList<int[]> cTargetList = new ArrayList<>();
        cTargetList.add(new int[] {i,j});
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i,j});
        while (!queue.isEmpty()) {
            int[] value = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int cx = value[0] + dx[k];
                int cy = value[1] + dy[k];

                if (cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
                if (visited[cx][cy]) continue;
                if (arr[i][j] == arr[cx][cy]) {
                    cCnt++;
                    queue.add(new int[] {cx, cy});
                    cTargetList.add(new int[] {cx,cy});
                    visited[cx][cy] = true;
                } else if (arr[cx][cy] == 0) {
                    cCnt++;
                    cRainbowCnt++;
                    queue.add(new int[] {cx, cy});
                    cTargetList.add(new int[] {cx,cy});
                    visited[cx][cy] = true;
                }
            }
        }
        if (cTargetList.size() < 2) return;
        selectTarget(cCnt, cRainbowCnt, cTargetI, cTargetJ, cTarget, cTargetList);

        for (int k = 0; k < cTargetList.size(); k++) {
            // 타겟이 선정되고 난 후 값이 0인 위치는 공유 가능하므로 다시 visited를 false로 변경해준다.
            int[] t = cTargetList.get(k);
            if (arr[t[0]][t[1]] == 0)
                visited[t[0]][t[1]] = false;
        }

    }
    public static void selectTarget(int cCnt, int cRainbowCnt, int cTargetI, int cTargetJ, int cTarget, ArrayList<int[]> cTargetList) {
        if (cCnt> cnt) {
            cnt = cCnt;
            rainbowCnt = cRainbowCnt;
            targetI = cTargetI;
            targetJ = cTargetJ;
            target = cTarget;
            targetList = cTargetList;
        } else if (cCnt == cnt) {
            if (cRainbowCnt > rainbowCnt) {
                cnt = cCnt;
                rainbowCnt = cRainbowCnt;
                targetI = cTargetI;
                targetJ = cTargetJ;
                target = cTarget;
                targetList = cTargetList;
            } else if (cRainbowCnt == rainbowCnt) {
                if (cTargetI > targetI) {
                    cnt = cCnt;
                    rainbowCnt = cRainbowCnt;
                    targetI = cTargetI;
                    targetJ = cTargetJ;
                    target = cTarget;
                    targetList = cTargetList;
                } else if (cTargetI == targetI) {
                    if (cTargetJ > targetJ) {
                        cnt = cCnt;
                        rainbowCnt = cRainbowCnt;
                        targetI = cTargetI;
                        targetJ = cTargetJ;
                        target = cTarget;
                        targetList = cTargetList;
                    }
                }
            }
        }
    }
    public static void setBlockEmpty() {
        for (int i = 0; i < targetList.size(); i++) {
            int[] target = targetList.get(i);
            arr[target[0]][target[1]] = EMPTY_BLOCK;
        }
    }
    public static void gravity() {
        for(int i = 0; i < N; ++i)
        {
            for(int j = N-1; j >= 0; --j)
            {
                if(arr[j][i] == EMPTY_BLOCK || arr[j][i] == -1) continue;
                int idx = j+1;
                while(true)
                {
                    if(idx == N) break;
                    if(arr[idx][i] == EMPTY_BLOCK) idx++;
                    else break;
                }
                if(idx == j+1) continue;
                arr[idx-1][i] = arr[j][i];
                arr[j][i] = EMPTY_BLOCK;
            }
        }
    }
    public static void rotation() {
        int [][] tmp = new int[N][N];
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                tmp[N-j-1][i] = arr[i][j];
            }
        }
        for(int i = 0; i < N; ++i)
        {
            System.arraycopy(tmp[i],0,arr[i],0,N);
        }
    }
}