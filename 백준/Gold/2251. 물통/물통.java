import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    static int[][][] visited;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static void dfs(int a, int b, int c) {
        // 물통에 물은 전부 넣는 경우
        if (visited[a][b][c] != 0) return;
        // 8, 9, 10
        // 0, 0, 10
        // 8, 0, 2
        // a->b, b->a, b->c, c->b, a->c, c->a
        visited[a][b][c] = 1;
        if (a == 0 && !arrayList.contains(c)) arrayList.add(c);
        if (a + b > A) { //a,b A 물통에 다 합치기 실패
            dfs(A, a + b - A, c);
        } else { //a,b A 물통에 다합치기
            dfs(a+b, 0, c);
        }
        if (a + b > B) {
            dfs(a+b-B, B, c);
        } else {
            dfs(0, a+b, c);
        }
        if (b+c > B) {
            dfs(a, B, b+c-B);
        } else {
            dfs(a, b+c, 0);
        }
        if (b+c > C) {
            dfs(a, b+c-C, C);
        } else {
            dfs(a, 0, b+c);
        }
        if (a+c > A) {
            dfs(A, b, a+c-A);
        } else {
            dfs(a+c, b, 0);
        }
        if (a+c > C) {
            dfs(a+c-C, b, C);
        } else {
            dfs(0, b, a+c);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new int[A+1][B+1][C+1];
        dfs(0, 0, C);
        Collections.sort(arrayList);
        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
    }
}
