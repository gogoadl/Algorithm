import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int n = Integer.parseInt(inputs[0]); // 접시 수
		int d = Integer.parseInt(inputs[1]); // 초밥 수
		int k = Integer.parseInt(inputs[2]); // 연속해서 먹는 수 
		int c = Integer.parseInt(inputs[3]); // 쿠폰 번호
		
		int[] arr = new int[n];
		int[] visited = new int[d+1];
		for (int i = 0; i < n; i++) { 
			arr[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		for (int i = 0; i < k; i++) { // 0~3까지 먹은 초밥 세팅 
			if (visited[arr[i]] == 0) {
				count++;
			}
			visited[arr[i]]++;
		}
		int max = count;
		// 0~3, 1~4, 2~5,...
		for (int i = 0; i < n; i++) {
			if (max <= count) {
				if (visited[c] == 0) { // 쿠폰 적용 가능하다면
					max = count + 1;
				} else
					max = count;
			}

			// 접시 한칸씩 밀기
			// 먹은 초밥중에 제일 앞에거 안먹은거로 바꾸고, i~k안에 한번이상 먹었는지 확인
			visited[arr[i]]--;
			if (visited[arr[i]] == 0) count--;
			
			// 다음 초밥 먹을 먹을 수 있다면 먹고 갯수 늘리기. 이미 먹었다면 먹은 갯수만 늘려주기
			if (visited[arr[(i+k)%n]] == 0) count++;
			visited[arr[(i+k)%n]]++;
		}
		System.out.println(max);
	}
}
