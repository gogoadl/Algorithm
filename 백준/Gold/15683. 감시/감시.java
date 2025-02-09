import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int [][]arr = new int[N][M];
        ArrayList<int[]> target = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0 && arr[i][j] < 6) {
                    target.add(new int[]{i,j,arr[i][j]});
                }
            }
        }

        setWatch(0, target, arr);
        System.out.println(minCount);
    }
    static void setWatch(int count, ArrayList<int[]> list, int[][] map) {
        if (count == list.size()) {
            int countZero = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        countZero++;
                    }
                }
            }
            minCount = Math.min(countZero, minCount);
            return;
        }
        int y = list.get(count)[0];
        int x = list.get(count)[1];
        int type = list.get(count)[2];
        int[][] tmp;
        if (type == 5) {
            tmp = copyMap(map);
            setLeft(y,x,tmp);
            setRight(y,x,tmp);
            setUp(y,x,tmp);
            setDown(y,x,tmp);
            setWatch(count+1, list, tmp);
        } else if (type == 4) {
            tmp = copyMap(map);
            setLeft(y,x,tmp);
            setRight(y,x,tmp);
            setUp(y,x,tmp);
            setWatch(count+1, list, tmp);
            
            tmp = copyMap(map);
            setLeft(y,x,tmp);
            setRight(y,x,tmp);
            setDown(y,x,tmp);
            setWatch(count+1, list, tmp);
            
            tmp = copyMap(map);
            setLeft(y,x,tmp);
            setUp(y,x,tmp);
            setDown(y,x,tmp);
            setWatch(count+1, list, tmp);
            
            tmp = copyMap(map);
            setRight(y,x,tmp);
            setUp(y,x,tmp);
            setDown(y,x,tmp);
            setWatch(count+1, list, tmp);
        } else if (type == 3) {
            tmp = copyMap(map);
            setRight(y,x,tmp);
            setUp(y,x,tmp);
            setWatch(count+1, list, tmp);

            tmp = copyMap(map);
            setRight(y,x,tmp);
            setDown(y,x,tmp);
            setWatch(count+1, list, tmp);

            tmp = copyMap(map);
            setLeft(y,x,tmp);
            setDown(y,x,tmp);
            setWatch(count+1, list, tmp);

            tmp = copyMap(map);
            setUp(y,x,tmp);
            setLeft(y,x,tmp);
            setWatch(count+1, list, tmp);

        } else if (type == 2) {
            tmp = copyMap(map);
            setLeft(y,x,tmp);
            setRight(y,x,tmp);
            setWatch(count+1, list, tmp);

            tmp = copyMap(map);
            setDown(y,x,tmp);
            setUp(y,x,tmp);
            setWatch(count+1, list, tmp);
        } else if (type == 1) {
            tmp = copyMap(map);
            setLeft(y,x,tmp);
            setWatch(count+1, list, tmp);

            tmp = copyMap(map);
            setRight(y,x,tmp);
            setWatch(count+1, list, tmp);

            tmp = copyMap(map);
            setUp(y,x,tmp);
            setWatch(count+1, list, tmp);

            tmp = copyMap(map);
            setDown(y,x,tmp);
            setWatch(count+1, list, tmp);
        }
    }
    static int getLeft(int y, int x, int[][] arr) {
        int count = 0;
        for (int j = x; j >= 0; j--) {
            if (arr[y][j] == 0) {
                count++;
            } else if (arr[y][j] == 6) break;
            else continue;
        }
        return count;
    }
    static int getRight(int y, int x, int[][] arr) {
        int count = 0;
        for (int j = x; j < M; j++) {
            if (arr[y][j] == 0) {
                count++;
            } else if (arr[y][j] == 6) break;
            else continue;
        }
        return count;
    }
    static int getDown(int y, int x, int[][] arr) {
        int count = 0;
        for (int j = y; j < N; j++) {
            if (arr[j][x] == 0) {
                count++;
            } else if (arr[j][x] == 6) break;
            else continue;
        }
        return count;
    }
    static int getUp(int y, int x, int[][] arr) {
        int count = 0;
        for (int j = y; j >= 0; j--) {
            if (arr[j][x] == 0) {
                count++;
            } else if (arr[j][x] == 6) break;
            else continue;
        }
        return count;
    }


    static int setLeft(int y, int x, int[][] arr) {
        int count = 0;
        for (int j = x; j >= 0; j--) {
            if (arr[y][j] == 0) {
                arr[y][j] = -1;
            } else if (arr[y][j] == 6) break;
            else continue;
        }
        return count;
    }
    static int setRight(int y, int x, int[][] arr) {
        int count = 0;
        for (int j = x; j < M; j++) {
            if (arr[y][j] == 0) {
                arr[y][j] = -1;
            } else if (arr[y][j] == 6) break;
            else continue;
        }
        return count;
    }
    static int setDown(int y, int x, int[][] arr) {
        int count = 0;
        for (int j = y; j < N; j++) {
            if (arr[j][x] == 0) {
                arr[j][x] = -1;
            } else if (arr[j][x] == 6) break;
            else continue;
        }
        return count;
    }
    static int setUp(int y, int x, int[][] arr) {
        int count = 0;
        for (int j = y; j >= 0; j--) {
            if (arr[j][x] == 0) {
                arr[j][x] = -1;
            } else if (arr[j][x] == 6) break;
            else continue;
        }
        return count;
    }
    public static int[][] copyMap(int[][] map) {
        int[][]tmp = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }
}
