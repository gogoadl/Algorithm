import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int testCaseCount = 10;
		LinkedList<String> linkedList = new LinkedList();
		for (int i = 1; i <= testCaseCount; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				linkedList.add(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < index; k++) {
				String I = st.nextToken();
				int start = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for (int j = 0; j < count; j++) {
					linkedList.add(start+j, st.nextToken());
				}
			}
			
			List<String> list = linkedList.subList(0, 10);
			sb.append("#").append(i).append(" ");
			for (String string : list	) {
				sb.append(string).append(" ");
			}
			sb.append("\n");
			linkedList.clear();
		}
		System.out.println(sb);
	}
}
