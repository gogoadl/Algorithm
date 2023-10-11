import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] magnet;
    static int[] rotationDir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        magnet = new int[4][8];
        rotationDir = new int[4];
        for (int j = 0; j < 4; j++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int l = 0; l < 8; l++) {
                magnet[j][l] = s.charAt(l)-'0';
            }
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int j = 0; j < k; j++) {
            rotationDir = new int[4];
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken())-1; // 자석 번호
            int dir = Integer.parseInt(st.nextToken()); // 자석 방향
            rotationDir[idx] = dir;

            if (dir == -1) {
                updateLeft(idx, -1);
                updateRight(idx, -1);
            } else {
                updateLeft(idx, 1);
                updateRight(idx, 1);
            }
            for (int l = 0; l < 4; l++) {
                if (rotationDir[l] == -1) {
                    shiftUp(l);
                } else if (rotationDir[l] == 1){
                    shiftDown(l);
                }
            }
        }

        if (magnet[0][0] == 1) answer += 1;
        if (magnet[1][0] == 1) answer += 2;
        if (magnet[2][0] == 1) answer += 4;
        if (magnet[3][0] == 1) answer += 8;

        System.out.println(answer);
    }
    public static void updateLeft(int index, int direction) {
        if (index == 0) return;
        for (int i = index; i > 0; i--) {
            if (magnet[i][6] == magnet[i-1][2]) break;
            else {
                if (direction == 1) {
                    direction = -1;
                    rotationDir[i-1] = direction;
                } else {
                    direction = 1;
                    rotationDir[i-1] = direction;

                }
            }
        }
    }
    public static void updateRight(int index, int direction) {
        if (index == 3) return;
        for (int i = index; i < 3; i++) {
            if (magnet[i][2] == magnet[i+1][6]) break;
            else {
                if (direction == 1) {
                    direction = -1;
                    rotationDir[i+1] = direction;
                } else {
                    direction = 1;
                    rotationDir[i+1] = direction;
                }
            }
        }
    }
    public static void shiftUp(int idx) {
        int temp = magnet[idx][0];
        for (int i = 0; i < magnet[idx].length-1; i++) {
            magnet[idx][i] = magnet[idx][i+1];
        }
        magnet[idx][magnet[idx].length-1] = temp;
    }
    public static void shiftDown(int idx) {
        int temp = magnet[idx][magnet[idx].length-1];
        for (int i = magnet[idx].length-1; i > 0; i--) {
            magnet[idx][i] = magnet[idx][i-1];
        }
        magnet[idx][0] = temp;
    }
}
/*

1
2
0 0 1 0 0 1 0 0
1 0 0 1 1 1 0 1
0 0 1 0 1 1 0 0
0 0 1 0 1 1 0 1
1 1
3 -1
 */