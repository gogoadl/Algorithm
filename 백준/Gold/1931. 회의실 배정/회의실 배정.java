import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] meetingRooms = new int[N][2];
        int meetingCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingRooms[i][0] = start;
            meetingRooms[i][1] = end;
        }
        Arrays.sort(meetingRooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        int before = 0;
        for (int i = 0; i < meetingRooms.length; i++) {
            if (before <= meetingRooms[i][0]) {
                before = meetingRooms[i][1];
                meetingCount++;
            }
        }
        System.out.println(meetingCount);
    }
}