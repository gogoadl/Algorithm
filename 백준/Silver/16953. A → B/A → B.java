import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long answer = 0;
        long start = Integer.parseInt(input[0]);
        long end = Integer.parseInt(input[1]);

        long[] first = new long[] {start, 1};
        PriorityQueue<long[]> queue = new PriorityQueue<long[]>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        queue.add(first);
        while (!queue.isEmpty()) {
            long[] value = queue.poll();
            if (value[0] == end) {
                answer = value[1];
                break;
            }
            if (value[0] > end) continue;
            String s = value[0] + "1";

            queue.add(new long[] {value[0] * 2, value[1] + 1});
            queue.add(new long[] {Long.parseLong(s), value[1] + 1});
        }
        if (answer == 0) {
            System.out.println(-1);
        } else
            System.out.println(answer);
    }
}