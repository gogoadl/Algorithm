import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pair implements Comparable<Pair>{
        int c;
        String name;
        public Pair(int c, String name) {
            this.c = c;
            this.name = name;
        }

        @Override
        public int compareTo(Pair o) {
            if (c != o.c) { // 반이 다르다면
                // 반이 낮은 애가 먼저
                if ((o.c % 2) - (c % 2) == 0)
                    return c - o.c;
                else
                    return (o.c % 2) - (c % 2);
            } else { // 반이 같다면
                if (name.length() - o.name.length() == 0)
                    return name.compareTo(o.name);
                else
                    return name.length() - o.name.length();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] count = new int[n+1];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (c == 0 && name.equals("0")) {
                break;
            }
            if (count[c] >= m) continue;
            count[c]++;
            queue.add(new Pair(c,name));
        }
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            sb.append(String.format("%d %s\n", p.c, p.name));
        }
        System.out.println(sb);
    }

}