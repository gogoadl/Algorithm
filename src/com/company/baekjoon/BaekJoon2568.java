import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2568 {
    public static class Pair implements Comparable<Pair>{
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair o) {
            return this.first - o.first;
        }
    }
    public static int search(int start, int end, int target, int[] arr) {
        int mid;
        while (start<end) {
            mid = (start + end) / 2;

            if (arr[mid]<target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int max = 0;
        ArrayList<Pair> arrayList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            arrayList.add(new Pair(a,b));
            max = Math.max(max, b);
        }
        Collections.sort(arrayList);
        int[] dp = new int[max+1];
        int[] target = new int[max+1];
        int index = 1;
        int tIndex = 1;
        // 최장 증가 부분수열 구하기
        for (int i = 0; i < N; i++) {
            if (arrayList.get(i).second > dp[index-1]) { // DP의 마지막 값 보다 array 값이 크면 dp 마지막 인덱스 업데이트
                dp[index] = arrayList.get(i).second;
                target[tIndex++] = index;
                index+=1;

            } else { // DP의 마지막 값보다 arr[i]가 작다면, arr[i]값이 들어갈 위치를 찾아준다.
                int idx = search(1, index-1, arrayList.get(i).second, dp);
                dp[idx] = arrayList.get(i).second;
                target[tIndex++] = idx;
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = N; i > 0; i--) {
            if (target[i] != index-1)
                priorityQueue.add(arrayList.get(i-1).second);
            else index--;
        }
        sb.insert(0, priorityQueue.size() + "\n");
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
