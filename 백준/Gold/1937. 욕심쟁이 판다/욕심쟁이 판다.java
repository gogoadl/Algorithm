import java.util.*;
public class Main {
    static int n,m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] dp;
    static int max = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(dfs(i,j), max);
            }
        }
        System.out.println(max);
    }
    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(arr[nx][ny] > arr[x][y])
                    dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);
            }
        }
        return dp[x][y];
    }
}