import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon2961 {
	static int N;
	static Pair[] pairs;
	static boolean[] visited;
	static ArrayList<Pair[]> arraylist = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	static void comb(int start, int n, int r, int count) {
	    if (r == 0 || start == n) { // 더이상 뽑을게 없으면
	    	boolean exist = false;
	    	int mul = 1;
	    	int sum = 0;
	    	for (int i = 0; i < n; i++) {
				if (visited[i]) {
		    		exist = true;
					mul *= pairs[i].first;
					sum += pairs[i].second;
				}
			}
	    	
	    	if (exist && Math.abs(mul - sum) < answer ) {
	    		answer = Math.abs(mul - sum);
	    	}
	        return;
	    }

	    visited[start] = true;
	    comb(start + 1, n, r - 1, count); // 다음 탐색, 뽑은 갯수 증가
	    visited[start] = false; 
	    comb(start + 1, n, r, count); // 
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		pairs = new Pair[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(S,B);
		}
		for (int i = 1; i <= N; i++) {
			comb(0, N, i, i);
		}
		System.out.println(answer);
	}
}
class Pair {
	int first;
	int second;
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d %d", first, second);
	}
	
}