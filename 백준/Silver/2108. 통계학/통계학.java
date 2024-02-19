import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		int cnt = Integer.parseInt(st.nextToken());

		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;

		// 최소값, 최댓값, 중간값, 최빈값
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			list.add(value);
			a += value;
		}

		Collections.sort(list);

		int count = 0;
		int max = -1;
		c = list.get(0);
		boolean check = false;
		for (int i = 0; i < cnt-1; i++) {
			if (list.get(i).equals(list.get(i+1))) {
				count++;
			} else {
				count = 0;
			}
			if (max < count) {
				max = count;
				c = list.get(i);
				check = true;
			} else if (max == count && check) { // 최빈값이 여러개인 경우
				c = list.get(i);
				check = false;
			}
		}

		a = (int)Math.round((double) a / cnt);

		b = list.get(cnt / 2);

		d = list.get(cnt-1) - list.get(0);

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}