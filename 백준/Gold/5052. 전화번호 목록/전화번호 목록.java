import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
                map.put(arr[j], 1);
            }
            Arrays.sort(arr);

            boolean isConsist = solution(n, arr, map);
            sb.append(isConsist ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
    static boolean solution(int length, String[] number_list, HashMap<String, Integer> map) {
        for(int i=0; i<length; i++) { // 문자열 총 갯수
            for(int j=1; j<number_list[i].length(); j++) { // 길이가 가장 짧은 문자열은 검사하지 않는다.
                String value = number_list[i].substring(0, j); // 문자열을 잘라서 자른 문자열이 키값으로 존재하는지 검사
                if(map.containsKey(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}