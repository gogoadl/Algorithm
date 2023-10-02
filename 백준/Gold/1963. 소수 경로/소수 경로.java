import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int start;
    static int end;
    static Queue<int[]> queue;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int q = 0; q < T; q++) {
            String[] input = br.readLine().split(" ");
            checked = new boolean[10000];
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            
            queue = new LinkedList<>();
            if (start == end) {
                sb.append("0\n");
                continue;
            }
            queue.add(new int[]{start, 0});
            while (!queue.isEmpty()) {
                int[] val = queue.poll();

                if (val[0] == end) {
                    sb.append(val[1]).append("\n");
                    break;
                }

                for (int j = 0; j <= 9; j++) {
                    if (j != get4(val[0])) {
                        int n1 = j * 1000+ get3(val[0]) * 100 + get2(val[0]) * 10 + get1(val[0]);
                        if (checkPrime(n1) && n1 > 1000 && !checked[n1]) {
                            queue.add(new int[]{n1, val[1]+1});
                            checked[n1] = true;
                        }
                    }
                    if (j != get3(val[0])) {
                        int n2 = get4(val[0]) * 1000 + j * 100 + get2(val[0]) * 10 + get1(val[0]);
                        if (checkPrime(n2) && n2 > 1000 && !checked[n2]) {
                            queue.add(new int[]{n2, val[1] + 1});
                            checked[n2] = true;
                        }
                    }
                    if (j != get2(val[0])) {
                        int n3 = get4(val[0]) * 1000 + get3(val[0])*100 + j * 10 + get1(val[0]);
                        if (checkPrime(n3) && n3 > 1000 && !checked[n3]) {
                            queue.add(new int[]{n3, val[1]+1});
                            checked[n3] = true;
                        }
                    }
                    if (j != get1(val[0])) {
                        int n4 = get4(val[0]) * 1000 + get3(val[0]) * 100 + get2(val[0]) * 10 + j;
                        if (checkPrime(n4) && n4 > 1000 && !checked[n4]) {
                            queue.add(new int[]{n4, val[1] + 1});
                            checked[n4] = true;
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
    public static boolean checkPrime(int number) {
        boolean isPrime = true;
        if (number == 1) isPrime = false;
        for (int k = 2; k <= Math.sqrt(number); k++) {
            if (number % k == 0) isPrime = false;
        }
        return isPrime;
    }
    public static int get1(int number){
        return number%10;
    }
    public static int get2(int number){
        return (number%100)/10;
    }
    public static int get3(int number){
        return (number%1000)/100;
    }
    public static int get4(int number){
        return (number)/1000;
    }
}