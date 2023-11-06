import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int current;
    static int N;
    static int D;

    static int[] movedDistance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ArrayList<int[]> arrayList = new ArrayList<int[]>();

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        movedDistance = new int[D+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arrayList.add(new int[]{start, end, value});
        }
        arrayList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        Arrays.fill(movedDistance, Integer.MAX_VALUE);
        int idx = 0;
        movedDistance[0] = 0;
        while (current < D) {
            while (idx < N) {
                if (arrayList.get(idx)[0] != current) break;

                if (arrayList.get(idx)[1] <= D) {
                    int dist = movedDistance[current] + arrayList.get(idx)[2];
                    if (dist < movedDistance[arrayList.get(idx)[1]]) {
                        movedDistance[arrayList.get(idx)[1]] = dist;
                    }
                }
                idx++;
            }

            if (movedDistance[current] + 1 < movedDistance[current+1]) {
                movedDistance[current+1] = movedDistance[current] + 1;
            }
            current++;
        }
        System.out.println(movedDistance[D]);
    }

}