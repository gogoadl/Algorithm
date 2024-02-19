import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		char[][] array = new char[size][size];
		int length = 0;

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < size; i++) {
			int len = 0;
			for (int j = 0; j < size; j++) {
				// len = find(array);
				// length = Math.max(length,len);
				if (i + 1 < size) {
					if (array[i][j] != array[i+1][j]) {
						swap(array, i, j, i+1, j);
						len = find(array);
						length = Math.max(length,len);
						swap(array, i+1, j, i, j);
					}
				}

				if (j + 1 < size) {
					if (array[i][j] != array[i][j+1]) {
						swap(array, i, j, i, j+1);
						len = find(array);
						length = Math.max(length,len);
						swap(array, i, j+1, i, j);
					}
				}

			}
		}
		System.out.println(length);
	}
	public static void swap(char[][] array, int i1, int j1, int i2, int j2) {
		char tmp = array[i1][j1];
		array[i1][j1] = array[i2][j2];
		array[i2][j2] = tmp;
	}
	public static int find(char[][] arrays) {
		int maxCnt = 1;
		for (int i = 0; i < arrays.length; i++) {
			int jCnt = 1;
			int iCnt = 1;
			for (int j = 0; j < arrays.length; j++) {
				if (j+1 < arrays.length) {
					if (arrays[i][j] == arrays[i][j+1]) {
						jCnt++;
					} else {
						jCnt = 1;
					}
					if (jCnt > maxCnt)
						maxCnt = jCnt;
					if (arrays[j][i] == arrays[j+1][i]) {
						iCnt++;
					} else {
						iCnt = 1;
					}
					if (iCnt > maxCnt)
						maxCnt = iCnt;
				}
			}
		}
		return maxCnt;
	}
}