import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> map;
    public static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            Pair[] pairs = new Pair[N+2]; // 시작 지점, 도착 지점

            for (int j = 0; j < N+2; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                pairs[j] = new Pair(x,y);
            }
            map = new ArrayList<>();
            for(int j = 0; j < N+2; ++j) map.add(new ArrayList<>());

            // 거리가 1000 이하인 정점끼리 연결
            for(int j = 0; j < N+1; ++j)
            {
                for(int k = j+1; k < N+2; ++k)
                {
                    int diff = Math.abs(pairs[j].first - pairs[k].first) + Math.abs(pairs[j].second - pairs[k].second);
                    if(diff <= 1000)
                    {
                        map.get(j).add(k);
                        map.get(k).add(j);
                    }
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }
    static String bfs()
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean [] visited = new boolean[N+2];
        visited[0] = true;

        while(!queue.isEmpty())
        {
            int value = queue.poll();

            if(value == N+1) return "happy";
            for(int i : map.get(value))
            {
                if(visited[i]) continue;
                visited[i] = true;
                queue.add(i);
            }
        }
        return "sad";
    }
}