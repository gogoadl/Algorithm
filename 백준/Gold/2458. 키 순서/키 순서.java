import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 각 노드가 모든 점들과 연결되어 있는지 여부만 체크해주면 답을 구할 수 있기 때문에
    // 모든 정점에서 모든 정점으로의 탐색을 하는 플로이드 와샬 알고리즘을 활용할 것이다.
    // 해당 풀이 로직에서는 모든 정점에서 모든 정점을 탐색하되 최단경로 갱신이 아닌 연결 여부만 체크해 줄 것이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] check = new boolean[N][N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            check[a][b] = true;
        }

        // 모든 정점에서 모든 정점을 탐색하여 연결 여부를 체크한다.
        for(int k=0; k<N; k++) { // 중간 지점
            for(int i=0; i<N; i++) { // 시작 지점
                for(int j=0; j<N; j++) { // 도착 지점
                    if(check[i][k] && check[k][j]) { // i->k 연결 && k-> j 연결
                        check[i][j] = true;
                    }
                }
            }
        }
        // 정방향, 역방향을 탐색하여 각 노드의 연결되어 있는 노드 수를 카운트한다.
        int[] cnt = new int[N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(check[i][j] || check[j][i]) {
                    cnt[i] ++;
                }
            }
        }

        // 만약 연결되어있는 노드의 수가 n-1(자신 제외)이면 모든 학생과 비교가 가능하므로 결과값에 카운트한다.
        int res =0;
        for(int num : cnt) {
            if(num == N-1) res++;
        }
        System.out.println(res);
    }
}