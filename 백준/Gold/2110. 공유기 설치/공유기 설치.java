import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 집의 위치를 정렬하고
    // 공유기 설치 위치의 거리가 가장 길어지기 위해서는
    // 집 마지막 위치 - 집 처음 위치 / 공유기 갯수로 판단했다.
    // 공유기가 설치될 위치는 처음, 마지막을 제외한 나머지라 생각했다.
    // 따라서 C-2회의 반복을 수행하면서 첫번째 인덱스에서 distance 만큼 떨어진 가장 가까운 부분을 찾다가 실패

    static int N;
    static int C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // start는 첫번째 집이고, 가장 마지막 집 위치 - 첫번째 집 위치
        // 설치 가능한 전체 공유기 갯수는?
        int low = 1;
        int high = arr[N-1] - arr[0] + 1;

        while(low < high) {
            int mid = (low + high) / 2;

            if (install(mid) < C) { // 설치 갯수가 적으면 거리를 좁혀야 함
                high = mid;
            } else { // 설치 갯수가 많으면 거리를 늘려야함
                low = mid + 1;
            }
        }


        System.out.println(low-1);
    }
    public static int install(int distance) {
        int count = 1; // 처음 1개 설치
        int startLocate = arr[0]; // 시작 위치
        for (int i = 0; i < arr.length; i++) {
            int locate = arr[i];

            if (locate - startLocate >= distance) { // 설정한 최소 거리보다 크거나 같으면 설치 가능
                count++;
                startLocate = locate; // 마지막 설치한 위치를 기준으로 다시 계산해야함.
            }
        }
        return count; // 설치 갯수 리턴
    }
}