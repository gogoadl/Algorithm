import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2615 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = 19;
		String[][] arr = new String[length][length];

		
		for (int i = 0; i < length; i++) {
			arr[i] = br.readLine().split(" ");
		}
		/* 조건
		* 
		*
		*/
		int[] dx = {1,1,0,1};
		int[] dy = {-1,0,1,1};
		boolean isFound = false;
		for (int i = 0; i < length; i++) {
			if (isFound) // 찾았으면 탈출
				break;
			for (int j = 0; j < length; j++) {
				if (isFound) // 찾았으면 탈출
					break;
				if (!arr[i][j].equals("0")) { // 빈 칸이 아니라면 검사
					String target = arr[i][j];
					for (int k = 0; k < dy.length; k++) { // 방향검사
						int currentX = j + dx[k];
						int currentY = i + dy[k];
						
						int count = 0;
						if (currentX < 0 || currentX >= length || currentY < 0 || currentY >= length) {
							continue;
						}
						if (arr[currentY][currentX].equals(target)) { // 진행 방향에 같은 돌이 있다면
							for (int l = 1; l <= 5; l++) { // 5개 있는지 검사
								int cX = currentX + (dx[k] * l);
								int cY = currentY + (dy[k] * l);
								if (cX < 0 || cX >= length || cY < 0 || cY >= length) {
									break;
								}
								if (arr[cY][cX].equals(target)) {
									count++;
								} else
									break;
							}	
						}
						if (count == 3) { // 5개 있다면 
							int x1 = j + -dx[k];
							int y1 = i + -dy[k];
							if (x1 >= 0 && y1 >= 0 && arr[y1][x1].equals(target)) { // 이전 인덱스 비교해서 6개이상인지 확인
								break;
							}
							System.out.println(target + "\n" + (i+1) + " " + (j+1));
							isFound = true;
						}
					}
				}
			}
		}
		if (!isFound)
			System.out.println("0");
		
	}
}
