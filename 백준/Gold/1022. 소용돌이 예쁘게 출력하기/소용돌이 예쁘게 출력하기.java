import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] {0,-1,0,1};
    static int[] dy = new int[] {1,0,-1,0};
    static int[][] arr;
    static int r1,c1,r2,c2,max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        arr = new int[r2-r1+1][c2-c1+1]; // 배열 범위 계산

        fill();
        print();
    }
    public static void fill() {
        int x=0, y=0, dir=0;
        int num=1, len =1, cnt =0;

        while(!endCheck()) {
            if(x >= r1 && x<=r2 && y>= c1 && y <= c2) {
                arr[x-r1][y-c1] = num;
            }

            num++;
            cnt++;
            x = x + dx[dir];
            y = y + dy[dir];

            if(cnt == len) {
                cnt = 0;
                if(dir == 1 || dir == 3) { // 방향이 위나 아래였으면 길이가 1 증가
                    len++;
                }
                dir = (dir+1)%4; // 방향 전환
            }
        }
        max = num - 1;
    }
    public static boolean endCheck() {
        return arr[0][0] != 0 && arr[r2-r1][0] != 0 && arr[0][c2-c1]!=0 && arr[r2-r1][c2-c1]!=0;
    }

    public static void print() {
        int maxLen = (int)Math.log10(max);
        int len;

        for(int i=0; i<=r2-r1; i++) {
            for(int j=0; j<= c2-c1; j++) {
                len = maxLen - (int) Math.log10(arr[i][j]);
                for(int k=0; k<len; k++) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

}