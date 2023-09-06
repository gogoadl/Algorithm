import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    // HashMap으로 풀기.
    // 1. 문자열 입력 받은 후 정렬
    // 2. hashMap에 추가
    // 3. hashMap의 0번 인덱스부터 끝까지 비교 연산
    // 4. String.startWith로 확인.
    // 5. 만약 startWith에서 true 나오면 탈출
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

        for(int i=0; i<length; i++) {
            for(int j=1; j<number_list[i].length(); j++) {
                if(map.containsKey(number_list[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    } // End of solution
    public static class Node {
        char value;
        ArrayList<Node> childNode = new ArrayList<>();
        boolean isEnd;
        public Node(char value, boolean isEnd) {
            this.value = value;
            this.isEnd = isEnd;
        }
        public void addChildNode(char value, boolean isEnd) {
            Node child = new Node(value, isEnd);
            childNode.add(child);
        }
        public Node find(char newval) {
            for (int i = 0; i < childNode.size(); i++) {
                Node child = childNode.get(i).find(newval);
                if (child != null)
                    return child;

            }
            return null;
        }
    }
}