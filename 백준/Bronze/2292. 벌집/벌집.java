import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int value = 1;
        int idx = 6;
        while (true) {
            if (value >= N) break;
            value += idx;
            idx += 6;
            count++;
        }
        System.out.println(count);
//        1, 8, 20, 38, 62
//                7, 12, 18, 24

    }
}
