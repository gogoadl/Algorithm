import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<Long, Long> map = new HashMap<>();
    static long N;
    static long P;
    static long Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Long.parseLong(input[0]);
        P = Long.parseLong(input[1]);
        Q = Long.parseLong(input[2]);

        System.out.println(solve(N));
    }
    static long solve(long num) {
        if(num==0) return 1;
        if(map.containsKey(num)) return map.get(num);

        map.put(num, solve(num/P)+solve(num/Q));
        return map.get(num);
    }
}