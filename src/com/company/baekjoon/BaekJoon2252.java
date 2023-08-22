import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2252 {
    public static class A{
        ArrayList<Integer> arrayList;
        int degree;
        public A(ArrayList arrayList, int degree) {
            this.arrayList = arrayList;
            this.degree = degree;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<A> lists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            lists.add(new A(new ArrayList(), 0));
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists.get(a).arrayList.add(b);
            lists.get(b).degree++;
        }

        Queue<A> queue = new LinkedList();

        for (int i = 1; i <= N; i++) {
            if (lists.get(i).degree == 0) {
                queue.add(lists.get(i)); // degree가 0인 노드를 큐에 추가
            }
        }

        while (!queue.isEmpty()) {
            while (!queue.isEmpty()){
                A a = queue.poll();
                a.degree = -1; // 검사한 노드는 다시 검사하지 않음

               sb.append(lists.indexOf(a)).append(" ");
                for(int i = 0; i < a.arrayList.size(); i++)
                   lists.get(a.arrayList.get(i)).degree--;
            }

            for (int i = 1; i <= N; i++) {
                if (lists.get(i).degree == 0) {
                    queue.add(lists.get(i)); // degree가 0인 노드를 큐에 추가
                }
            }
        }
        System.out.println(sb);
    }
}
