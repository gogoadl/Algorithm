import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            int val = arr[i];
            int targetIndex = deque.indexOf(val);
            int halfIndex;
            if (deque.size() % 2 == 0) {
                halfIndex = deque.size() / 2 - 1;
            } else {
                halfIndex = deque.size() / 2;
            }
            if (targetIndex <= halfIndex) {
                for (int j = 0; j < targetIndex; j++) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }

            } else {
                for (int j = 0; j < deque.size() - targetIndex; j++) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
